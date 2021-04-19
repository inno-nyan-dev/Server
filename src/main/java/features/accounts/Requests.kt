package features.accounts

data class SignUpRequest(
        var email: String,
        var password: String
)

data class LoginRequest(
        var email: String,
        var password: String
)