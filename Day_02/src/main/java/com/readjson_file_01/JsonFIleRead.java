/* 1️⃣ Read a JSON file and print all keys and values
 */
package com.readjson_file_01;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonFIleRead {
    public static void main(String[] args) {
        String filePath = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\readjson_file_01\\JsonFile01.json";
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            System.out.println("JSON Structure: " + jsonNode.toPrettyString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
