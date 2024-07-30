import com.example.messaging_app.DatabaseConfig
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun getConnection(): Connection? {
    var connection: Connection? = null
    try {
        connection = DriverManager.getConnection(DatabaseConfig.JDBC_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD)
    } catch (e: SQLException) {
        e.printStackTrace()
    }
    return connection
}
