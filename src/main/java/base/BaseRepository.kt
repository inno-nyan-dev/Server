package base

import features.exception_handler.BaseCustomException
import model.SimpleResponse
import org.springframework.stereotype.Component

@Component
abstract class BaseRepository

sealed class OperationStatus<T> {
    data class OK<T>(val message: SimpleResponse = SimpleResponse(""), val body: T? = null) : OperationStatus<T>()
    data class Error<T>(val exception: BaseCustomException) : OperationStatus<T>()
}