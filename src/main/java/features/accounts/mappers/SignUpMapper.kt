package features.accounts.mappers

import base.Mappers
import features.accounts.SignUpEntity
import features.accounts.SignUpRequest
import utils.createToken
import utils.sha256


class SignUpMapper : Mappers.ISignUpMapper {
    override fun toEntity(item: SignUpRequest): SignUpEntity {
        with(item) {
            return SignUpEntity(
                    email = email,
                    password = sha256(password),
                    token = createToken(email, password)
            )
        }
    }
}