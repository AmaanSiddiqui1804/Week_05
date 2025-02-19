/*  Read a CSV File and Print Data
Read a CSV file containing student details (ID, Name, Age, Marks).
Print each record in a structured format.
 */
package com.csv_file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem1_CSV_File.csv" ;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line ;

            br.readLine(); //to skip ID: ID, Name: Name, Age: Age, Marks: Marks

            while ((line = br.readLine()) != null){
                String[] columns = line.split(",");
                System.out.println("ID: " + columns[0] + ", Name: " + columns[1] +
                        ", Age: " + columns[2] + ", Marks: " + columns[3]);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
