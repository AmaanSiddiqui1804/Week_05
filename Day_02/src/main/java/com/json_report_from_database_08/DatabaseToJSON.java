package com.json_report_from_database_08;

import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class DatabaseToJSON {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "12345678";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            JSONArray jsonArray = new JSONArray();

            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("age", rs.getInt("age"));
                jsonObject.put("email", rs.getString("email"));
                jsonArray.put(jsonObject);
            }

            // Print JSON report
            System.out.println(jsonArray.toString(4));

        } catch (SQLException e) {
            System.out.println(e.getErrorCode()+ " " + e.getMessage());
        }
    }
}

