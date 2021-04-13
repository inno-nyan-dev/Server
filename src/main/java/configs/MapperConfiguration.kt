package configs

import base.Mappers
import features.accounts.mappers.LoginMapper
import features.accounts.mappers.SignUpMapper
import features.products.mappers.ProductMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
open class MapperConfiguration : WebMvcConfigurer {

    @Bean
    open fun productsMapper(): Mappers.IProductMapper = ProductMapper()

    @Bean
    open fun loginMapper(): Mappers.ILoginMapper = LoginMapper()

    @Bean
    open fun signUpMapper(): Mappers.ISignUpMapper = SignUpMapper()

}