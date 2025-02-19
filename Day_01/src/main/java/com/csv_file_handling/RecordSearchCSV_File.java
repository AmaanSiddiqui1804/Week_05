/* 5️⃣ Search for a Record in CSV
Read an employees.csv file and search for an employee by name.
Print their department and salary.
 */
package com.csv_file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RecordSearchCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem2_CSV_File.csv" ;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                String name = columns[1];

                if (name.equalsIgnoreCase("Nishank Bathri")) {
                    String department = columns[2];  // Assuming department is in the 3rd column (index 2)
                    String salary = columns[3];      // Assuming salary is in the 4th column (index 3)
                    System.out.println("Name: " + name + ", Department: " + department + ", Salary: " + salary);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
