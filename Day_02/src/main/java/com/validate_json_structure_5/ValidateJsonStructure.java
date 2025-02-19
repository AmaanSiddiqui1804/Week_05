/* 5️⃣ Validate JSON structure using Jackson. */

package com.validate_json_structure_5;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper ;

import java.io.File;
import java.io.IOException;

public class ValidateJsonStructure {
    public static void main(String[] args) {

        String filePath = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\validate_json_structure\\File.json";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            System.out.println("Valid JSON Structure: " + jsonNode.toPrettyString());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
