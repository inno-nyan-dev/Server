package features.accounts

import base.BasePersistence
import org.springframework.stereotype.Component

@Component
class AccountPersistence : BasePersistence() {

    fun createAccount(signUpEntity: SignUpEntity): Boolean {
        connect().use {
            val query = """INSERT INTO users VALUES(DEFAULT, ?, ?, ?)"""
            it.prepareStatement(query).use {
                it.setString(1, signUpEntity.email)
                it.setString(2, signUpEntity.password)
                it.setString(3, signUpEntity.token)
                return it.executeUpdate() > 0
            }
        }
    }

    fun login(loginEntity: LoginEntity): LoginEntity {
        connect().use {
            val query = """SELECT * FROM users u WHERE u.email = ? AND u.password = ?"""
            it.prepareStatement(query).use {
                it.setString(1, loginEntity.email)
                it.setString(2, loginEntity.password)
                it.executeQuery().use {
                    return if (it.next()) {
                        LoginEntity(it.getLong("id"), it.getString("email"), it.getString("password"), it.getString("token"))
                    } else {
                        LoginEntity()
                    }
                }
            }
        }
    }

    fun checkIfEmailOccupied(email: String): Boolean {
        connect().use {
            val query = """SELECT * FROM users u WHERE u.email = ?"""
            it.prepareStatement(query).use {
                it.setString(1, email)
                it.executeQuery().use {
                    return it.next()
                }
            }
        }
    }
}