/* 1️⃣5️⃣ Encrypt and Decrypt CSV Data
Encrypt the sensitive fields (e.g., Salary, Email) while writing to a CSV file.
Decrypt them when reading the file.
 */
package com.csv_file_handling;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV_File {
    private static final String SECRET_KEY = "1112245095123456"; // 16-byte key

    public static void main(String[] args) {
        String inputCSV = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem15_CSV_File.csv";
        String encryptedCSV = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem15_EncryptedCSV_File.csv";
        String decryptedCSV = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem15_DecryptedCSV_File.csv";

        encryptCSV(inputCSV, encryptedCSV);
        decryptCSV(encryptedCSV, decryptedCSV);
    }

    // Method to encrypt sensitive fields in the CSV file
    public static void encryptCSV(String inputCSV, String outputCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputCSV));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSV))) {

            String line;
            writer.write(br.readLine() + "\n"); // Write header to encrypted file

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length < 4) continue;

                fields[3] = encrypt(fields[3]); // Encrypt Email
                fields[4] = encrypt(fields[4]); // Encrypt Salary

                writer.write(String.join(",", fields) + "\n");
            }
            System.out.println("CSV encrypted successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to decrypt sensitive fields in the CSV file
    public static void decryptCSV(String inputCSV, String outputCSV) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputCSV));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputCSV))) {

            String line;
            writer.write(br.readLine() + "\n"); // Write header to decrypted file

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length < 4) continue;

                fields[3] = decrypt(fields[3]); // Decrypt Email
                fields[4] = decrypt(fields[4]); // Decrypt Salary

                writer.write(String.join(",", fields) + "\n");
            }
            System.out.println("CSV decrypted successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to encrypt data using AES
    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    // Method to decrypt data using AES
    private static String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(SECRET_KEY.getBytes(), "AES"));
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }
}
