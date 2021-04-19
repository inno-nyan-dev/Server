package features.exception_handler

import configs.ConstantResponses
import model.SimpleResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

abstract class BaseCustomException(exceptionMessage: String) : RuntimeException(exceptionMessage)


@RestControllerAdvice
class UserControllerException {

    @ExceptionHandler
    fun handleNoProductsFoundException(exception: NoProductsFound): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.simpleResponse)
    }

    @ExceptionHandler
    fun handleImageIsEmptyException(exception: ImageIsEmptyException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.simpleResponse)
    }

    @ExceptionHandler
    fun handleImagesSizeTooBigException(exception: ImagesSizeTooBigException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.simpleResponse)
    }

    @ExceptionHandler
    fun handleWrongCredentialsException(exception: WrongCredentialsException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.simpleResponse)
    }

    @ExceptionHandler
    fun handleAccountNotCreatedException(exception: AccountNotCreatedException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.simpleResponse)
    }

    @ExceptionHandler
    fun handleEmailOccupiedException(exception: EmailOccupiedException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.simpleResponse)
    }
}


class NoProductsFound(exceptionMessage: String = ConstantResponses.NO_PRODUCTS_FOUND) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}

class WrongCredentialsException(exceptionMessage: String = ConstantResponses.WRONG_CREDENTIALS) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}

class AccountNotCreatedException(exceptionMessage: String = ConstantResponses.ACCOUNT_NOT_CREATED) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}

class EmailOccupiedException(exceptionMessage: String = ConstantResponses.EMAIL_OCCUPIED) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}

class ImageIsEmptyException(exceptionMessage: String = ConstantResponses.IMAGE_IS_EMPTY) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}

class ImagesSizeTooBigException(exceptionMessage: String = ConstantResponses.IMAGE_SIZE_TOO_BIG(2)) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}