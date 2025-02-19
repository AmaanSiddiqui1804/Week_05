/* 1️⃣3️⃣ Generate a CSV Report from Database
Fetch employee records from a database and write them into a CSV file.
Include headers: Employee ID, Name, Department, Salary.
 */
package com.csv_file_handling;

import java.io.*;
import java.sql.*;

public class CSV_FileFromDatabase {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/company";  // Random details not accurate
        String username = "username";
        String password = "password";
        String csvFilePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem13_CSV_File.csv";

        exportToCSV(jdbcURL, username, password, csvFilePath);
    }

    public static void exportToCSV(String jdbcURL, String username, String password, String csvFilePath) {
        String sql = "SELECT id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {

            writer.write("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV file generated successfully!");
        } catch (SQLException | IOException e) {
            System.err.println("Error exporting data: " + e.getMessage());
        }
    }
}
