package com.json_file_filter_7;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\json_file_filter\\File7.json";
        try {
            // Read JSON file
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            // Filter and print records with age > 25
            JSONArray filteredArray = new JSONArray();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.getInt("age") > 25) {
                    filteredArray.put(obj);
                }
            }

            // Print filtered JSON
            System.out.println(filteredArray.toString(4));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
