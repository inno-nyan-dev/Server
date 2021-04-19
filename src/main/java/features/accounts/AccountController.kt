package features.accounts

import base.OperationStatus
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import utils.Constants.Companion.ACCOUNT
import utils.Constants.Companion.V1

@RestController
@RequestMapping(V1 + ACCOUNT)
class AccountController {

    @Autowired
    lateinit var accountRepository: AccountRepository

    @ApiOperation("Регистрация")
    @ResponseBody
    @RequestMapping("/signup", method = [RequestMethod.POST])
    fun signUp(@RequestBody body: SignUpRequest): ResponseEntity<*> {
        val signUpResult = accountRepository.signUp(body)
        return when (signUpResult) {
            is OperationStatus.OK -> {
                ResponseEntity.status(HttpStatus.OK).body(signUpResult.body)
            }
            is OperationStatus.Error -> {
                throw signUpResult.exception
            }
        }
    }

    @ApiOperation("Авторизация")
    @ResponseBody
    @RequestMapping("/login", method = [RequestMethod.POST])
    fun login(@RequestBody body: LoginRequest): ResponseEntity<*> {
        val loginResult = accountRepository.login(body)
        return when (loginResult) {
            is OperationStatus.OK -> {
                ResponseEntity.status(HttpStatus.OK).body(loginResult.body)
            }
            is OperationStatus.Error -> {
                throw loginResult.exception
            }
        }
    }
}
