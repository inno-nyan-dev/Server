package features.accounts

data class LoginEntity(
        var id: Long = -1L,
        var email: String = "",
        var password: String = "",
        var token: String = ""
) {
    fun isEmpty() = id == -1L
}

data class SignUpEntity(
        var email: String,
        var password: String,
        var token: String
)