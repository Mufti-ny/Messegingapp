package com.example.messaging_app

import android.database.SQLException
import java.sql.DriverManager

fun main() {
    try {
        DriverManager.getConnection(DatabaseConfig.JDBC_URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD).use { connection ->
            println("Connected to the database!")

            val query = "SELECT * FROM user"
            connection.createStatement().use { statement ->
                statement.executeQuery(query).use { resultSet ->
                    while (resultSet.next()) {
                        println("Column Value: ${resultSet.getString("username")}")
                    }
                }
            }
        }
    } catch (e: SQLException) {
        e.printStackTrace()
    }
}
