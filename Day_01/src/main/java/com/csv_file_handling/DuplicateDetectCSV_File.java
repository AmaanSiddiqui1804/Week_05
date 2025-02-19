/* Detect Duplicates in a CSV File
Read a CSV file and detect duplicate entries based on the ID column.
Print all duplicate records.
 */
package com.csv_file_handling;

import java.io.*;
import java.util.*;

public class DuplicateDetectCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem12_CSV_File.csv";  // CSV file with duplicates
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Set<Integer> seenIds = new HashSet<>();
        List<String> duplicateRows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue; // Skip header

                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());

                if (!seenIds.add(id)) {
                    duplicateRows.add(line);
                }
            }

            if (duplicateRows.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String row : duplicateRows) {
                    System.out.println(row);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}
