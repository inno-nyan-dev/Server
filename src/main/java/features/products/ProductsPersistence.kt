package features.products

import base.BasePersistence
import org.springframework.stereotype.Component

@Component
class ProductsPersistence : BasePersistence() {

    fun getProducts(): List<ProductsEntity> {
        connect().use {
            val query = """SELECT * FROM products"""
            it.prepareStatement(query).use {
                it.executeQuery().use {
                    val result = mutableListOf<ProductsEntity>()
                    while (it.next()) {
                        result.add(
                                ProductsEntity(
                                        id = it.getLong("id"),
                                        productName = it.getString("product_name"),
                                        productImageUrl = it.getString("product_image_url"),
                                        productDangLevel = it.getString("product_dang_level"),
                                        productDescription = it.getString("product_description")
                                )
                        )
                    }
                    return result
                }
            }
        }
    }
}