package features.products

import base.BaseRepository
import base.Mappers
import base.OperationStatus
import features.exception_handler.NoProductsFound
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import utils.ImageHandler


@Component
class ProductsRepository : BaseRepository() {

    @Autowired
    lateinit var productsPersistence: ProductsPersistence

    @Autowired
    lateinit var imageHandler: ImageHandler

    @Autowired
    lateinit var productsMapper: Mappers.IProductMapper

    fun getProducts(): OperationStatus<List<ProductsResponse>> {
        val result = productsPersistence.getProducts()
        return when {
            result.isEmpty() -> OperationStatus.Error(NoProductsFound())
            else -> OperationStatus.OK(body = productsMapper.toResponse(result))
        }
    }
}