/*Modify a CSV File (Update a Value)
Read a CSV file and increase the salary of employees from the "IT" department by 10%.
Save the updated records back to a new CSV file.
 */
package com.csv_file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ModifyCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem2_CSV_File.csv" ;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                if(line.trim().isBlank()){
                    continue;
                }
                String[] columns = line.split(",");
                double salary = Double.parseDouble(columns[3]) ;
                String department = columns[2];

                if ("IT".equalsIgnoreCase(department)) {
                    String name = columns[1];
                    salary *= 1.10;
                    System.out.println("Name: " + name + ", Department: " + department + ", Salary: " + salary);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
