/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils.Helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;

/**
 *
 * @author matheusdsl
 */
public class JsonHelper {
    
    public <T> String ToJson(T obj) {
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        String json = gson.toJson(obj);
        return json;
    }

}
