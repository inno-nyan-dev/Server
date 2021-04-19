package features.accounts

data class LoginResponse(
        val id: Long = -1,
        val email: String = "",
        @Transient
        val password: String = "",
        val token: String = ""
)
