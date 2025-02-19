/* 3️⃣ Read and Count Rows in a CSV File
Read a CSV file and count the number of records (excluding the header row).
 */
package com.csv_file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRowsCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem1_CSV_File.csv" ;
        int lineCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line ;
            reader.readLine();
            while ((line = reader.readLine()) != null){
                lineCount++;
            }
            System.out.println("Total number of lines in the CSV files are: " + lineCount);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
