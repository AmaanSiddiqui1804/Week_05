package com.csv_file_handling;

import java.io.*;
import java.util.regex.*;

public class ValidatingCSV_File {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem8_CSV_File.csv" ;
        validateCSV(filePath);
    }

    public static void validateCSV(String filePath) {
        String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        String phoneRegex = "^[6789][0-9]{9}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (lineNumber == 1) continue; // Skip header row

                String[] fields = line.split(",");

                if (fields.length < 3) { // Assuming at least Name, Email, and Phone Number
                    System.out.println("Line " + lineNumber + " is incomplete: " + line);
                    continue;
                }

                String email = fields[1].trim();
                String phone = fields[2].trim();

                boolean isValidEmail = emailPattern.matcher(email).matches();
                boolean isValidPhone = phonePattern.matcher(phone).matches();

                if (!isValidEmail || !isValidPhone) {
                    System.out.print("Invalid data in line " + lineNumber + ": " + line);
                    if (!isValidEmail) System.out.print(" (Invalid Email)");
                    if (!isValidPhone) System.out.print(" (Invalid Phone)");
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
