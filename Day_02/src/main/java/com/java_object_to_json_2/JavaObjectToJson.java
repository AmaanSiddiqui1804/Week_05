/* 2️⃣ Convert a Java object (Car) into JSON format.
 */
package com.java_object_to_json_2;

import org.json.JSONObject;

class Car {
    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public JSONObject jsonObject() {
        JSONObject j1 = new JSONObject()
                .put("Brand", brand)
                .put("Model", model);
        return j1;
    }
}
public class JavaObjectToJson {
    public static void main(String[] args) {

        Car car = new Car("Toyota", "Supra");

        System.out.println(car.jsonObject().toString(4));
    }
}
