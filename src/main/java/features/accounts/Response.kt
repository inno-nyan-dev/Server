package features.accounts

data class ProductsResponse(
        var id: Long,
        var productName: String,
        var productImageUrl: String,
        var productDangLevel: String,
        var productDescription: String
)
