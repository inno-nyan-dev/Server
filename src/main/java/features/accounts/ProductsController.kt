package features.accounts

import base.OperationStatus
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import utils.Constants.Companion.PRODUCTS
import utils.Constants.Companion.V1

@RestController
@RequestMapping(V1 + PRODUCTS)
class ProductsController {

    @Autowired
    lateinit var productsRepository: ProductsRepository

    @ApiOperation("Получение списка продуктов")
    @ResponseBody
    @RequestMapping("/products", method = [RequestMethod.GET])
    fun getProducts(): ResponseEntity<*> {
        val products = productsRepository.getProducts()
        return when (products) {
            is OperationStatus.OK -> {
                ResponseEntity.status(HttpStatus.OK).body(products.body)
            }
            is OperationStatus.Error -> {
                throw products.exception
            }
        }
    }
}
