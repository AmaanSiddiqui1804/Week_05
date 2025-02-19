/* 6️⃣ Convert a list of Java objects into a JSON array. */

package com.objects_to_json_array_6;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    String brand;
    String model;

    public Vehicle(String brand, String model){
        this.brand = brand;
        this.model = model;
    }
}
public class JavaObjectsToJsonArray {

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Tesla", "Model-S"));
        vehicles.add(new Vehicle("Tesla", "Model-3"));
        vehicles.add(new Vehicle("Tesla", "Model-X"));
        vehicles.add(new Vehicle("Tesla", "Model-Y"));

        vehicles.add(new Vehicle("Tata", "Safari"));
        vehicles.add(new Vehicle("Tata", "Curv"));

        JSONArray jsonArray = new JSONArray();

        for (Vehicle v1 : vehicles) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Brand", v1.brand);
            jsonObject.put("Model", v1.model);
            jsonArray.put(jsonObject);
        }

        // Printing JSON array
        System.out.println(jsonArray.toString(4));

    }
}
