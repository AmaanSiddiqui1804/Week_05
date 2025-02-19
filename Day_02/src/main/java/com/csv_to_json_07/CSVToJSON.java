/* Convert CSV to JSON
 */
package com.csv_to_json_07;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileReader;

public class CSVToJSON {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\csv_to_json\\problem7 file.csv";

        try (FileReader reader = new FileReader(filePath);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            JSONArray jsonArray = new JSONArray();

            // Converting CSV to JSON
            for (CSVRecord record : csvParser) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name", record.get("name"));
                jsonObject.put("age", Integer.parseInt(record.get("age")));
                jsonObject.put("email", record.get("email"));
                jsonArray.put(jsonObject);
            }

            // Printing JSON output
            System.out.println(jsonArray.toString(4));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
