package features.products.mappers

import base.Mappers
import features.products.ProductsEntity
import features.products.ProductsResponse


class ProductMapper : Mappers.IProductMapper {
    override fun toResponse(item: ProductsEntity): ProductsResponse {
        with(item) {
            return ProductsResponse(
                    id = id,
                    productName = productName,
                    productImageUrl = productImageUrl,
                    productDangLevel = productDangLevel,
                    productDescription = productDescription

            )
        }
    }
}