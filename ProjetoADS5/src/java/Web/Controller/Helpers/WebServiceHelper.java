/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller.Helpers;

import static Factory.New.New;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author matheusdsl
 */
public class WebServiceHelper {

    static String BASE_PATH = "http://localhost:8080/";
    static String NAME_PROJECT = "ProjetoADS5/";

    public static String GetWebServiceUrl(String action, String parameters) {
        return BASE_PATH + NAME_PROJECT + action + "WS" + "?" + (parameters != null ? parameters : "");
    }
    
    public static <T> T GetFromJsonService(String url, Class<T> obj) {
        String resposta = New(RestTemplate.class).getForObject(url, String.class);
        return New(JsonHelper.class).FromJson(resposta, obj);
    }
    
    public static <T> ResponseEntity<String> GetToJsonService(String url) {
        return New(RestTemplate.class).getForObject(url, ResponseEntity.class);
    }
    
    public static <T> ResponseEntity<String> GetToJsonService(String action, String parameters) {
        String url = WebServiceHelper.GetWebServiceUrl(action, parameters);
        return WebServiceHelper.GetToJsonService(url);
    }
    
     public static <T> T GetFromJsonService(String action, String parameters, Class<T> obj) {
        String url = WebServiceHelper.GetWebServiceUrl(action, parameters);
        String resposta = New(RestTemplate.class).getForObject(url, String.class);
        return New(JsonHelper.class).FromJson(resposta, obj);
    }
     
    public static <T> ResponseEntity<T> PostCrud(String action, Class<T> clazz, T obj) {
        String url = WebServiceHelper.GetWebServiceUrl(action, null);
        return New(RestTemplate.class).postForEntity(url, obj, clazz);
       // return WebServiceHelper.ToJsonService(action, action)
    }
}
