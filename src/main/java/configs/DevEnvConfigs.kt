package configs


class DevEnvConfigs {
    companion object {
        private val DEPLOY_LEVEL_VALUE = DEPLOY_LEVEL.PRODUCTION

        fun getDBConnectParams(): String = when (DEPLOY_LEVEL_VALUE) {
            DEPLOY_LEVEL.DEBUG ->
                "jdbc:mysql://localhost:3306/rabbit?useUnicode=true&characterEncoding=utf-8" +
                        "&autoReconnect=true&tcpKeepAlive=true&serverTimezone=UTC" +
                        "&useSSL=false&useAffectedRows=true&user=root&password=root"
            DEPLOY_LEVEL.PRODUCTION ->
                "jdbc:mysql://mysql:3306/rabbit?useUnicode=true&characterEncoding=utf-8&" +
                        "autoReconnect=true&tcpKeepAlive=true&serverTimezone=" +
                        "UTC&useSSL=false&useAffectedRows=true&user=user&password=user"
        }

        fun getImageSavePath(): String = when (DEPLOY_LEVEL_VALUE) {
            DEPLOY_LEVEL.DEBUG ->
                "/Users/bozman/JavaImages/"
            DEPLOY_LEVEL.PRODUCTION ->
                "/home/backend/images/"
        }
    }

    private enum class DEPLOY_LEVEL {
        DEBUG, PRODUCTION
    }
}
