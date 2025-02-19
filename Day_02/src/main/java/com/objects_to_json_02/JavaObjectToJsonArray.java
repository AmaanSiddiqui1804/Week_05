package com.objects_to_json_02;

import org.json.JSONObject;

class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    //Method to make java object to json array
    public JSONObject jsonObject() {
        JSONObject j1 = new JSONObject()
                .put("Brand", brand)
                .put("Model", model);
        return j1;
    }
}

class Food {
    private String item;
    private String type;

    public Food(String item, String type) {
        this.item = item;
        this.type = type;
    }
    public String getItem() {
        return item;
    }
    public String getType() {
        return type;
    }
}

public class JavaObjectToJsonArray {
    public static void main(String[] args) {

        Car car = new Car("Toyota", "Supra");
        System.out.println(car.jsonObject().toString(4));

        //Creating json array of objects
        Food food = new Food("Biryani", "Chicken");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("item", food.getItem());
        jsonObject1.put("type", food.getType());

        // printing JSON with 4-space indentation
        System.out.println(jsonObject1.toString(4));

    }
}

