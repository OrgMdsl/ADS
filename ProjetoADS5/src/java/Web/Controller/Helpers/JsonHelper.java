/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller.Helpers;

import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author matheusdsl
 * @param <T>
 */
public class JsonHelper<T> {
    
    private final Gson gson;

    public JsonHelper() {
        this.gson = new Gson();
    }

    public ResponseEntity<String> ToJson(T obj)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        String json = gson.toJson(obj);
        return new ResponseEntity<String>(json, headers, HttpStatus.CREATED);
    }
    
}
