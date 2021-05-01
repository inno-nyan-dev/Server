package features.favorite_foods

import base.BaseRepository
import base.Mappers
import base.OperationStatus
import configs.ConstantResponses.Companion.FAVORITES_ADDED
import configs.ConstantResponses.Companion.FAVORITES_REMOVED
import features.accounts.AccountPersistence
import features.exception_handler.FavoriteProductsNotFound
import features.exception_handler.UserNotFoundException
import features.products.ProductsResponse
import model.SimpleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FavoriteFoodsRepository : BaseRepository() {
    @Autowired
    lateinit var favoriteFoodsPersistence: FavoriteFoodsPersistence

    @Autowired
    lateinit var accountPersistence: AccountPersistence

    @Autowired
    lateinit var productsMapper: Mappers.IProductMapper

    fun getFavoriteProducts(token: String): OperationStatus<List<ProductsResponse>> {
        val user =  accountPersistence.getUserByToken(token)
        when(user){
            null -> return OperationStatus.Error(UserNotFoundException())
        }
        val result = favoriteFoodsPersistence.getFavoriteFoods(user!!.userId)
        return when {
            result.isEmpty() -> OperationStatus.Error(FavoriteProductsNotFound())
            else -> OperationStatus.OK(body = productsMapper.toResponse(result))
        }
    }

    fun toggleFavorite(token: String, productId: Long): OperationStatus<Boolean> {
        val user = accountPersistence.getUserByToken(token)
        when (user) {
            null -> return OperationStatus.Error(UserNotFoundException())
        }
        val products = favoriteFoodsPersistence.getFavoriteFoods(user!!.userId)
        return if (products.find { it.id == productId } != null) {
            favoriteFoodsPersistence.deleteFavorites(user.userId, productId)
            OperationStatus.OK(message = SimpleResponse(FAVORITES_REMOVED))

        } else {
            favoriteFoodsPersistence.addFavorites(user.userId, productId)
            OperationStatus.OK(message = SimpleResponse(FAVORITES_ADDED))
        }
    }
}