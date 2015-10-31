/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller.Helpers;

import static Factory.New.New;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Modifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author matheusdsl
 */
public class JsonHelper {
    
    public <T> ResponseEntity<String> ToJson(T obj) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");
        Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
        String json = gson.toJson(obj);
        return new ResponseEntity<String>(json, headers, HttpStatus.CREATED);
    }
    
    public <T> T FromJson(String json, Class<T> obj) {
        return new Gson().fromJson(json, obj);
    }  
}
