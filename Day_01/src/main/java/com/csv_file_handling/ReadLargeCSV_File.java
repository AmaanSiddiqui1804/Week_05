/* Read Large CSV File Efficiently
Given a large CSV file (500MB+), implement a memory-efficient way to read it in chunks.
Process only 100 lines at a time and display the count of records processed.
 */
package com.csv_file_handling;

import java.io.*;

public class ReadLargeCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem11_CSV_File.csv";
        processLargeCSV(filePath);
    }

    public static void processLargeCSV(String filePath) {
        int batchSize = 100;
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header

            while ((line = br.readLine()) != null) {
                recordCount++;

                if (recordCount % batchSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }

            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            System.err.println("Error reading large file: " + e.getMessage());
        }
    }
}
