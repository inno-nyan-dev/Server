package utils

import base.OperationStatus
import configs.ConstantResponses.Companion.IMAGE_IS_EMPTY
import configs.ConstantResponses.Companion.IMAGE_SIZE_TOO_BIG
import features.exception_handler.ImageIsEmptyException
import features.exception_handler.ImagesSizeTooBigException
import org.springframework.web.multipart.MultipartFile
import java.awt.AlphaComposite
import java.awt.Image
import java.awt.image.BufferedImage
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream

interface ImageHandler {
    val MAXIMUM_IMAGE_SIZE_MB: Int
    fun isFileSizeOk(file: MultipartFile): Boolean
    fun createResizedCopy(originalImage: Image,
                          scaledWidth: Int, scaledHeight: Int,
                          preserveAlpha: Boolean): BufferedImage

    fun saveFile(file: MultipartFile, route: String): OperationStatus<String>
}

class ImageHandlerImpl : ImageHandler {
    override val MAXIMUM_IMAGE_SIZE_MB: Int
        get() = 2

    /**
     * Проверка файла на максимальный размер
     *
     * @param file - файл
     * @return - true, если допустимый размер больше размера файла
     */
    override fun isFileSizeOk(file: MultipartFile): Boolean {
        val size = file.size
        val availableSize = MAXIMUM_IMAGE_SIZE_MB * 1024 * 1024
        return availableSize > size
    }

    /**
     * Изменяет размер файла
     *
     * @param originalImage - Исходное изображение
     * @param scaledWidth   - требуемая ширина
     * @param scaledHeight  - требуемая высота
     * @param preserveAlpha - сохранение альфа канала
     * @return - изображение с измененным размером
     */
    override fun createResizedCopy(originalImage: Image,
                                   scaledWidth: Int, scaledHeight: Int,
                                   preserveAlpha: Boolean): BufferedImage {
        val imageType = if (preserveAlpha) BufferedImage.TYPE_INT_RGB else BufferedImage.TYPE_INT_ARGB
        val scaledBI = BufferedImage(scaledWidth, scaledHeight, imageType)
        val g = scaledBI.createGraphics()
        if (preserveAlpha) {
            g.composite = AlphaComposite.Src
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null)
        g.dispose()
        return scaledBI
    }

    /**
     * Сохранение файла
     *
     * @param file   - исходный файл
     * @param route  - путь для сохранения без имени
     * @return - ответ об успешности или безуспешности операции типа ResponseEntity
     */
    override fun saveFile(file: MultipartFile, route: String): OperationStatus<String> {
        fun createFile(): OperationStatus<String> {
            val fileName = "${sha256(createRandomString(64))}.jpg"
            val bytes = file.bytes
            val f = File("$route/$fileName")
            val stream = BufferedOutputStream(FileOutputStream(f))
            stream.write(bytes)
            stream.close()
            return OperationStatus.OK(body = fileName)
        }
        return when {
            file.isEmpty -> OperationStatus.Error(ImageIsEmptyException(IMAGE_IS_EMPTY))
            !isFileSizeOk(file) -> OperationStatus.Error(ImagesSizeTooBigException(IMAGE_SIZE_TOO_BIG(MAXIMUM_IMAGE_SIZE_MB)))
            else -> createFile()
        }
    }
}