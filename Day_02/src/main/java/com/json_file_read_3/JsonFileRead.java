/* 3️⃣ Read a JSON file and extract only specific fields (e.g., name, email).
 */
package com.json_file_read_3;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileRead {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\json_file_read3\\JsonFileRead.json";

        try {
            //Reading json family
            String content = new String(Files.readAllBytes(Path.of(filePath)));

            //Parsing json file
            JSONArray jsonArray = new JSONArray(content);

            //Printing name and email
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println("Name: " + jsonObject.getString("name") + "\nEmail: " + jsonObject.getString("email"));

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
