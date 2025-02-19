/* Sort CSV Records by a Column
Read a CSV file and sort the records by Salary in descending order.
Print the top 5 highest-paid employees.
 */
package com.csv_file_handling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SortCSV_File {
    public static void main(String[] args) {
        String inputFilePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem2_CSV_File.csv" ;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {

            //Arraylist to store salary records
            List<String []> records = new ArrayList<>();
            String header = br.readLine(); //reading first line header line
            String line;
            records.add(header.split(","));

            //Reading each line
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                records.add(columns);
            }


            // Sorting the records by salary in descending order
            for (int i = 1; i < records.size(); i++) {  // Start from 1 to skip header
                for (int j = i + 1; j < records.size(); j++) {

                    int salary1 = Integer.parseInt(records.get(i)[3]);
                    int salary2 = Integer.parseInt(records.get(j)[3]);

                    // Swapping the salary if record at j is higher than record at i
                    if (salary1 < salary2) {
                        String[] temp = records.get(i);
                        records.set(i, records.get(j));
                        records.set(j, temp);
                    }
                }
            }

            System.out.println("Top 5 Highest Salaries");
            System.out.println(records.get(0)[0] + "," + records.get(0)[1] + "," + records.get(0)[2] + "," + records.get(0)[3]);  // Print the header
            for (int i = 1; i <= 5 && i < records.size(); i++) {
                String[] record = records.get(i);
                System.out.println("ID: " + record[0] + ", Name: " + record[1] +
                        ", Department: " + record[2] + ", Salary: " + record[3]);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
