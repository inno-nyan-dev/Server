package features.accounts.mappers

import base.Mappers
import features.accounts.LoginEntity
import features.accounts.LoginRequest
import features.accounts.LoginResponse
import utils.sha256


class LoginMapper : Mappers.ILoginMapper {
    override fun toEntity(item: LoginRequest): LoginEntity {
        return LoginEntity(
                id = -1L,
                email = item.email,
                password = sha256(item.password),
                token = ""
        )
    }

    override fun toResponse(item: LoginEntity): LoginResponse {
        with(item) {
            return LoginResponse(
                    id = id,
                    email = email,
                    password = password,
                    token = token
            )
        }
    }
}