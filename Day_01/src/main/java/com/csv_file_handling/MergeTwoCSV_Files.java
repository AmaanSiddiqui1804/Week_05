/* 🔟 Merge Two CSV Files
You have two CSV files:
students1.csv (contains ID, Name, Age)
students2.csv (contains ID, Marks, Grade)
Merge both files based on ID and create a new file containing all details.
 */
package com.csv_file_handling;

import java.io.*;
import java.util.*;

class StudentRecord {
    int id;
    String name;
    int age;
    int marks;
    String grade;

    public StudentRecord(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeTwoCSV_Files {
    public static void main(String[] args) {

        String filePath1 = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem9_CSV_File.csv";  // ID, Name, Age
        String filePath2 = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem10_CSV_File.csv";  // ID, Marks, Grade
        String outputFile = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem10_mergedCSV_File.csv";

        mergeCSV(filePath1, filePath2, outputFile);
    }

    public static void mergeCSV(String file1, String file2, String outputFile) {
        Map<Integer, StudentRecord> studentMap = new HashMap<>();

        //Reading File 1
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line;
            br1.readLine(); // Skipping header

            while ((line = br1.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());

                studentMap.put(id, new StudentRecord(id, name, age, 0, ""));
                System.out.println(studentMap);
            }
        } catch (IOException e) {
            System.err.println("Error reading first file: " + e.getMessage());
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            String line;
            br2.readLine(); // Skipping header

            while ((line = br2.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                int marks = Integer.parseInt(parts[1].trim());
                String grade = parts[2].trim();

                if (studentMap.containsKey(id)) {
                    StudentRecord student = studentMap.get(id);
                    student.marks = marks;
                    student.grade = grade;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading second file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            for (StudentRecord student : studentMap.values()) {
                writer.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing merged file: " + e.getMessage());
        }

        System.out.println("Merged CSV file created successfully.");
    }
}
