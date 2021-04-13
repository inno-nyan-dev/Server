package configs

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import configs.DevEnvConfigs.Companion.getDBConnectParams
import java.sql.Connection

class ConnectionPool {

    var ds: HikariDataSource

    init {
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = getDBConnectParams()
        hikariConfig.maximumPoolSize = 50
        hikariConfig.idleTimeout = 60000L
        hikariConfig.leakDetectionThreshold = 100000L
        ds = HikariDataSource(hikariConfig)
    }

    companion object {
        @JvmStatic
        val instance: ConnectionPool = ConnectionPool()
    }

    fun getConnection(): Connection {
        return ds.connection
    }


}