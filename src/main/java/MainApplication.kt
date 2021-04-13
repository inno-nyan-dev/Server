import configs.ConnectionPool
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.io.IOException

@SpringBootApplication(scanBasePackages = ["features", "base", "configs"])
@EnableWebMvc
open class MainApplication {

    companion object {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(MainApplication::class.java, *args)
        }
    }
}
