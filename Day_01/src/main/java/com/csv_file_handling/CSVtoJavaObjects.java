/* 9️⃣ Convert CSV Data into Java Objects
Read a CSV file and convert each row into a Student Java object.
Store the objects in a List<Student> and print them.
 */
package com.csv_file_handling;

import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student {ID =" + id + ", Name = '" + name + "', Age =" + age + "}";
    }
}

public class CSVtoJavaObjects {

    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem9_CSV_File.csv";  // CSV file path
        List<Student> studentList = readCSV(filePath);

        // Printing the student objects
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    //Method to read CSV file
    public static List<Student> readCSV(String filePath) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue; // Skip header

                String[] data = line.split(",");
                if (data.length < 3) continue;

                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());

                students.add(new Student(id, name, age));
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return students;
    }
}
