package base

import configs.ConnectionPool
import java.sql.Connection

open class BasePersistence {
    fun connect(): Connection {
        return ConnectionPool.instance.getConnection()
    }
}