/*4️⃣ Filter Records from CSV
Read a CSV file and filter students who have scored more than 80 marks.
Print only the qualifying records.
 */
package com.csv_file_handling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem1_CSV_File.csv" ;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line ;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String [] columns = line.split(",");
                int marks = Integer.parseInt(columns[3]); //Marks are in 4th column

                if(marks > 80){
                    System.out.println("ID: " + columns[0] + ", Name: " + columns[1] +
                            ", Age: " + columns[2] + ", Marks: " + columns[3]);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
