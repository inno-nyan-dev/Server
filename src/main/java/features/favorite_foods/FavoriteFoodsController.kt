package features.favorite_foods

import base.OperationStatus
import features.products.ProductsRepository
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import retrofit2.http.Query
import utils.Constants.Companion.FAVORITES
import utils.Constants.Companion.V1

@RestController
@RequestMapping(V1 + FAVORITES)
class FavoriteFoodsController {

    @Autowired
    lateinit var favoriteFoodsRepository: FavoriteFoodsRepository

    @ApiOperation("Получение списка избранных продуктов")
    @ResponseBody
    @RequestMapping("/favorites", method = [RequestMethod.GET])
    fun getProducts(@RequestHeader("access-token") token: String): ResponseEntity<*> {
        val products = favoriteFoodsRepository.getFavoriteProducts(token)
        return when (products) {
            is OperationStatus.OK -> {
                ResponseEntity.status(HttpStatus.OK).body(products.body)
            }
            is OperationStatus.Error -> {
                throw products.exception
            }
        }
    }

    @ApiOperation("Изменение статуса избранного у продукта")
    @ResponseBody
    @RequestMapping("/favorites", method = [RequestMethod.POST])
    fun toggleFavorites(@RequestHeader("access-token") token: String, @Query("productId") productId: Long): ResponseEntity<*> {
        val favResult = favoriteFoodsRepository.toggleFavorite(token, productId)
        return when (favResult) {
            is OperationStatus.OK -> {
                ResponseEntity.status(HttpStatus.OK).body(favResult.body)
            }
            is OperationStatus.Error -> {
                throw favResult.exception
            }
        }
    }
}