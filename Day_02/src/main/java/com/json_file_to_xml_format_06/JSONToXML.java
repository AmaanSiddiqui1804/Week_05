/* 6️⃣ Convert JSON to XML format.
 */
package com.json_file_to_xml_format_06;

import org.json.JSONObject;
import org.json.XML;

public class JSONToXML {
    public static void main(String[] args) {
        // Defining JSON Object
        String filePath = "{ \"person\": { \"name\": \"Amaan\", \"age\": 22 } }";
        JSONObject jsonObject = new JSONObject(filePath);
        //System.out.println(jsonObject.toString(4));

        // Converting JSON to XML
        String xml = XML.toString(jsonObject);

        // Print XML output
        System.out.println("<root>" + xml + "</root>");
    }
}

