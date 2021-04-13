package configs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.web.servlet.config.annotation.*
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import utils.ImageHandler
import utils.ImageHandlerImpl


@Configuration
@EnableSwagger2
open class Configuration : WebMvcConfigurationSupport() {
    @Autowired
    lateinit var applicationContext: ConfigurableApplicationContext

    @Bean
    open fun corsConfigurer(): WebMvcConfigurer {
        return object : WebMvcConfigurerAdapter() {
            override fun addCorsMappings(registry: CorsRegistry?) {
                registry!!.addMapping("/api/**").allowedOrigins("*")
            }
        }
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    open fun imageHandler(): ImageHandler = ImageHandlerImpl()

    @Bean
    open fun postsApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .select()
                .paths(PathSelectors.regex("/api/v1.*"))
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder().title("JavaInUse API")
                .description("JavaInUse API reference for developers")
                .termsOfServiceUrl("http://javainuse.com")
                .contact("javainuse@gmail.com").license("JavaInUse License")
                .licenseUrl("javainuse@gmail.com").version("1.0").build()
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
    }
}

