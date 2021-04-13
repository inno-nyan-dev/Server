package features.accounts.mappers

import base.Mappers
import features.accounts.ProductsEntity
import features.accounts.ProductsResponse


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