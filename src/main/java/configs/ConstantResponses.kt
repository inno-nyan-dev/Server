package configs

class ConstantResponses {
    companion object {
        const val ACCOUNT_CREATED = "Account successfully created"
        const val ACCOUNT_NOT_CREATED = "Error occur in creating the account"
        const val EMAIL_OCCUPIED = "Email is already occupied"
        const val WRONG_CREDENTIALS = "Email or password is incorrect"
        const val NO_PRODUCTS_FOUND = "No products found"
        val IMAGE_SIZE_TOO_BIG = fun(imageSize: Int) = "The size of the image exceeds $imageSize MB."
        const val IMAGE_IS_EMPTY = "The image was not found"
        const val USER_NOT_FOUND = "User with this token was not found "
        const val NO_FAVORITE_PRODUCTS  = "No favorite products found  "
        const val FAVORITES_REMOVED = "Product was successfully deleted from favorites"
        const val FAVORITES_ADDED = "Product was successfully added to favorites"
    }
}
