package com.merge_json_object4;

import org.json.JSONObject;

public class MergeJsonObject {
    public static void main(String[] args) {
        //First Object
        JSONObject j1 = new JSONObject()
                .put("name", "Amaan")
                .put("age", 22);
        //Second Object
        JSONObject j2 = new JSONObject()
                .put("email", "amaan121@example.com")
                .put("city", "Bhopal");

        //Merging two objects
        for(String str : j2.keySet()){
            j1.put(str, j2.get(str));
        }

        System.out.println(j1.toString(4));
    }
}
