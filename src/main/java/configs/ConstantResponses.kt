package configs

class ConstantResponses {
    companion object {
        const val ACCOUNT_CREATED = "Аккаунт успешно создан"
        const val ACCOUNT_NOT_CREATED = "Не удалось создать аккаунт"
        const val EMAIL_OCCUPIED = "Эта почта уже занята"
        const val WRONG_CREDENTIALS = "Почта или пароль неверные"
        const val NO_PRODUCTS_FOUND = "Не найдено продуктов"
        val IMAGE_SIZE_TOO_BIG = fun(imageSize: Int) = "Размер изображения превышает $imageSize МБ."
        const val IMAGE_IS_EMPTY = "Изображение не найдено"
    }
}
