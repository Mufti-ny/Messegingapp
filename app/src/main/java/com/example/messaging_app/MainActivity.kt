package com.example.messaging_app


import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    main()


    }





    fun main() {
        val connection = getConnection()
        if (connection != null) {
            println("Connected to the database!")

            // Example query
            val query = "SELECT * FROM user"
            val statement = connection.createStatement()
            val resultSet = statement.executeQuery(query)

            while (resultSet.next()) {
                println("Column Value: ${resultSet.getString("username")}")
            }

            // Close resources
            resultSet.close()
            statement.close()
            connection.close()
        } else {
            println("Failed to connect to the database.")
        }
    }

    fun getConnection(): Connection? {
        var connection: Connection? = null
        try {
            connection = DriverManager.getConnection(DatabaseConfig.JDBC_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD)
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return connection
    }

}