/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller.Helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;

/**
 *
 * @author matheusdsl
 */
public class JsonHelper {

    public <T> String ToJson(T obj, boolean exclude) {
        Gson gson = null;
        if (exclude) {
            gson = new GsonBuilder().serializeNulls().serializeSpecialFloatingPointValues().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        } else {
            gson = new GsonBuilder().serializeNulls().serializeSpecialFloatingPointValues().create();
        }
        String json = gson.toJson(obj);
        return json;
    }

    public <T> T FromJson(String json, Class<T> obj) {
        return new Gson().fromJson(json, obj);
    }
}
