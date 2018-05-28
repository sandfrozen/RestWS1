/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author tomek.buslowski
 */
public class MyJson {

    public static JsonObject Error(int code) {
        return Json.createObjectBuilder().add("code", code).build();
    }

    public static JsonObject Error(int code, String error) {
        return Json.createObjectBuilder()
                .add("code", code)
                .add("error", error)
                .build();
    }

    public static JsonObject Error(int code, String error, String message) {
        return Json.createObjectBuilder()
                .add("code", code)
                .add("error", error)
                .add("message", message)
                .build();
    }

}
