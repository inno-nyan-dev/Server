package features.accounts

import base.BaseRepository
import base.Mappers
import base.OperationStatus
import configs.ConstantResponses.Companion.ACCOUNT_CREATED
import features.exception_handler.AccountNotCreatedException
import features.exception_handler.EmailOccupiedException
import features.exception_handler.WrongCredentialsException
import model.SimpleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class AccountRepository : BaseRepository() {

    @Autowired
    lateinit var accountPersistence: AccountPersistence

    @Autowired
    lateinit var loginMapper: Mappers.ILoginMapper

    @Autowired
    lateinit var signUpMapper: Mappers.ISignUpMapper

    fun signUp(signUpRequest: SignUpRequest): OperationStatus<LoginResponse> {
        val signUpEntity = signUpMapper.toEntity(signUpRequest)
        val ifAccountArleadyExists = accountPersistence.checkIfEmailOccupied(signUpEntity.email)
        if (ifAccountArleadyExists) {
            return OperationStatus.Error(EmailOccupiedException())
        }
        val result = accountPersistence.createAccount(signUpEntity)
        return when {
            result -> {
                val loginEntity = loginMapper.toEntity(LoginRequest(signUpRequest.email, signUpRequest.password))
                val loginResult = accountPersistence.login(loginEntity)
                OperationStatus.OK(message = SimpleResponse(ACCOUNT_CREATED), body = loginMapper.toResponse(loginResult))
            }
            else -> OperationStatus.Error(AccountNotCreatedException())
        }
    }

    fun login(loginRequest: LoginRequest): OperationStatus<LoginResponse> {
        val loginEntity = loginMapper.toEntity(loginRequest)
        val loginResult = accountPersistence.login(loginEntity)
        return when {
            loginResult.isEmpty() -> OperationStatus.Error(WrongCredentialsException())
            else -> OperationStatus.OK(body = loginMapper.toResponse(loginResult))
        }
    }
}