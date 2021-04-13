package base

import features.accounts.ProductsEntity
import features.accounts.ProductsResponse

interface BaseMapper

interface BaseResponseMapper<Entity, Response> : BaseMapper {
    fun toResponse(item: Entity): Response
    fun toResponse(items: List<Entity>): List<Response> {
        val result = mutableListOf<Response>()
        items.forEach {
            result.add(toResponse(it))
        }
        return result
    }
}

interface BaseRequestMapper<Request, Entity> : BaseMapper {
    fun toEntity(item: Request): Entity
    fun toEntity(items: List<Request>): List<Entity> {
        val result = mutableListOf<Entity>()
        items.forEach {
            result.add(toEntity(it))
        }
        return result
    }
}

interface BaseEntityMapper<EntityA, EntityB> : BaseMapper {
    fun toEntity(item: EntityA): EntityB
    fun toEntity(items: List<EntityA>): List<EntityB> {
        val result = mutableListOf<EntityB>()
        items.forEach {
            result.add(toEntity(it))
        }
        return result
    }
}

interface Mappers {
    interface IProductMapper : BaseResponseMapper<ProductsEntity, ProductsResponse>
}