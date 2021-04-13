package features.favorite_foods

import base.BasePersistence
import features.products.ProductsEntity
import org.springframework.stereotype.Component

@Component
class FavoriteFoodsPersistence: BasePersistence() {

    fun getFavoriteFoods(userId: Long): List<ProductsEntity> {
        connect().use {
            val query = """SELECT * FROM favorites f 
                LEFT JOIN products p ON p.id = f.product_id
                WHERE f.user_id = ?"""
            it.prepareStatement(query).use {
                it.setLong(1,userId)
                it.executeQuery().use{
                    val result = mutableListOf<ProductsEntity>()
                    while(it.next()){
                        val productsEntity = ProductsEntity(
                                id = it.getLong("product_id"),
                                productName = it.getString("product_name"),
                                productImageUrl = it.getString("product_image_url"),
                                productDangLevel = it.getString("product_dang_level"),
                                productDescription = it.getString("product_description")
                        )
                        result.add(productsEntity)
                    }
                    return result
                }
            }
        }
    }

    fun addFavorites(userId: Long, productId: Long): Boolean {
        connect().use {
            val query = """INSERT INTO favorites VALUES(DEFAULT, ?, ?)"""
            it.prepareStatement(query).use {
                it.setLong(1, userId)
                it.setLong(2, productId)
                return it.executeUpdate() > 0
            }
        }
    }

    fun deleteFavorites(userId: Long, productId: Long): Boolean {
        connect().use {
            val query = """DELETE FROM favorites WHERE favorites.product_id = ? AND favorites.user_id = ?"""
            it.prepareStatement(query).use {
                it.setLong(1, productId)
                it.setLong(2, userId)
                return it.executeUpdate() > 0
            }
        }
    }
}