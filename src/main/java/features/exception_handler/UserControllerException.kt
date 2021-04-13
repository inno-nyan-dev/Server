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
}


class NoProductsFound(exceptionMessage: String = ConstantResponses.NO_PRODUCTS_FOUND) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}

class ImageIsEmptyException(exceptionMessage: String = ConstantResponses.IMAGE_IS_EMPTY) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}

class ImagesSizeTooBigException(exceptionMessage: String = ConstantResponses.IMAGE_SIZE_TOO_BIG(2)) : BaseCustomException(exceptionMessage) {
    var simpleResponse: SimpleResponse = SimpleResponse(exceptionMessage)
}