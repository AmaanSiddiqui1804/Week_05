/* 5️⃣ Merge two JSON files into a single JSON object.
 */
package com.merge_2_json_files_05;

import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeJsonFilesToObject {
    public static void main(String[] args) {
        try {

            String jsonFilePath1 = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\merge_2_json_files\\problem05 File1.json";
            String jsonFilePath2 = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\merge_2_json_files\\problem05 File2.json";

            JSONObject json1 = getJsonObject(jsonFilePath1, jsonFilePath2);


            System.out.println("Merged JSON: " + json1.toString(4));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static JSONObject getJsonObject(String jsonFilePath1, String jsonFilePath2) throws FileNotFoundException {
        FileReader reader1 = new FileReader(jsonFilePath1);
        JSONTokener token1 = new JSONTokener(reader1);
        JSONObject json1 = new JSONObject(token1);

        // Read the second JSON file
        FileReader reader2 = new FileReader(jsonFilePath2);
        JSONTokener token2 = new JSONTokener(reader2);
        JSONObject json2 = new JSONObject(token2);

        // Merging the second JSON into the first
        json1.put("merged", json2);  // Adds the second JSON as a field inside the first
        return json1;
    }
}
