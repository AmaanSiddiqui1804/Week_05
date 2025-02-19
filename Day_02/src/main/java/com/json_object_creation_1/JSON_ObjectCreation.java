/*1️⃣ Create a JSON object for a Student with fields: name, age, and subjects (array).

 */
package com.json_object_creation_1;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON_ObjectCreation {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject.put("name", "Amaan");
        jsonObject.put("age",22);
        jsonArray.put("Maths");
        jsonArray.put("JAVA");
        jsonArray.put("Digital Electronics");
        jsonArray.put("Embedded Systems");
        jsonObject.put("Subjects", jsonArray );

        System.out.println(jsonObject.toString(4));

    }
}

