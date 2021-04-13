package configs

class ConstantResponses {
    companion object {
        val NO_PRODUCTS_FOUND = "Не найдено продуктов"
        val IMAGE_SIZE_TOO_BIG = fun(imageSize: Int) = "Размер изображения превышает $imageSize МБ."
        const val IMAGE_IS_EMPTY = "Изображение не найдено"
    }
}
