/* 2️⃣ Write Data to a CSV File
Create a CSV file with employee details (ID, Name, Department, Salary).
Write at least 5 records to the file.
 */
package com.csv_file_handling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem2_CSV_File.csv" ;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){

            bw.write("ID,Name,Department,Salary\n");
            bw.write("101,Amaan Siddiqui,IT,70000\n");
            bw.write("102,Nishank Bathri,Marketing,65000\n");
            bw.write("104,Tikesh Kardate,IOT,70000\n");
            bw.write("103,Abhay Gautam,Development,56000\n");
            System.out.println("CSV file written successfully!");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
