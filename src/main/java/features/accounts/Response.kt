package features.accounts

data class LoginResponse(
        val id: Long,
        val email: String,
        @Transient
        val password: String,
        val token: String
)
