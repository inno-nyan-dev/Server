package features.products

data class ProductsResponse(
        var id: Long = -1,
        var productName: String = "",
        var productImageUrl: String = "",
        var productDangLevel: String = "",
        var productDescription: String = ""
)
