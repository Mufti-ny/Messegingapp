package com.example.messaging_app

import getConnection

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
