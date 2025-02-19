

package com.json_file_email_validation_03;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class EmailValidation {
    public static void main(String[] args) {

        String filePath = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\json_file_email_validation03\\File02.json";

        try {
            //reading json file
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            //Converting file content to JSON array
            JSONArray students = new JSONArray(content);

            //Defining JSON schema for email validation
            String schemaEmail = "{"
                    + "\"type\" : \"object\", "
                    + "\"properties\" : {"
                    + "  \"email\" : { \"type\": \"string\", \"format\": \"email\" }"
                    + "},"
                    + "\"required\": [\"email\"]"
                    + "}";

            //Converting schema to JSON
            JSONObject jsonObject = new JSONObject(schemaEmail);
            Schema schema = SchemaLoader.load(jsonObject);

            // Validating Each Email
            for (int i = 0; i < students.length(); i++) {

                JSONObject student = students.getJSONObject(i);
                String name = student.getString("name"); // Get name
                String email = student.getString("email"); // Get email

                try {
                    // Validating the email field
                    schema.validate(new JSONObject().put("email", email));
                    System.out.println(name + " (" + email + ")  Correct");
                } catch (Exception e) {
                    System.out.println(name + " (" + email + ")  Incorrect");
                }
            }
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}