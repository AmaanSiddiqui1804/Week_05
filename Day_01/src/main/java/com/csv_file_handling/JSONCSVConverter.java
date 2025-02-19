/* Convert JSON to CSV and Vice Versa
Read a JSON file containing a list of students.
Convert it into CSV format and save it.
Implement another method to read CSV and convert it back to JSON.
 */

package com.csv_file_handling;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONCSVConverter {

    public static void main(String[] args) {
        String jsonFile = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem14_JSON_File.json";
        String csvFile = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem14_CSV_File.csv";
        String outputJsonFile = "D:\\Week_05\\Day_01\\src\\main\\java\\com\\csv_files\\Problem14_JSON_FileRecreated.json";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, outputJsonFile);
    }

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFilePath, String csvFilePath) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
            JSONArray jsonArray = new JSONArray(jsonContent);

            FileWriter fileWriter = new FileWriter(csvFilePath);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("ID", "Name", "Age"));

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                csvPrinter.printRecord(
                        jsonObject.getInt("ID"),
                        jsonObject.getString("Name"),
                        jsonObject.getInt("Age")
                );
            }
            csvPrinter.close();
            System.out.println("JSON converted to CSV successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFilePath, String outputJsonFile) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            JSONArray jsonArray = new JSONArray();
            for (CSVRecord record : csvParser) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("ID", Integer.parseInt(record.get("ID")));
                jsonObject.put("Name", record.get("Name"));
                jsonObject.put("Age", Integer.parseInt(record.get("Age")));

                jsonArray.put(jsonObject);
            }
            csvParser.close();

            FileWriter fileWriter = new FileWriter(outputJsonFile);
            fileWriter.write(jsonArray.toString(4));
            fileWriter.close();

            System.out.println("CSV converted to JSON successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
