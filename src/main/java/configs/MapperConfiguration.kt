package configs

import base.Mappers
import features.accounts.mappers.ProductMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class MapperConfiguration : WebMvcConfigurer {

    @Bean
    open fun productsMapper(): Mappers.IProductMapper = ProductMapper()

}