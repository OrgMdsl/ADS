/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller.Helpers;

import static com.ProjetoADS5.Factory.New.New;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author matheusdsl
 */
public class WebServiceHelper {

    static String BASE_PATH = "http://localhost:8080/";
    static String NAME_PROJECT = "ProjetoADS5/";
    JsonHelper JsonHelper = New(JsonHelper.class);

    public static String GetWebServiceUrl(String action, String parameters) {
        return BASE_PATH + NAME_PROJECT + action + "WS" + "?" + (parameters != null ? parameters : "");
    }

    public static <T> T GetFromJsonService(String url, Class<T> obj) {
        String resposta = New(RestTemplate.class).getForObject(url, String.class);
        return New(JsonHelper.class).FromJson(resposta, obj);
    }

    public static <T> String GetToJsonService(String url) {
        return New(RestTemplate.class).getForObject(url, String.class);
    }

    public static <T> ResponseEntity<String> GetToJsonService(String action, String parameters) {
        String url = WebServiceHelper.GetWebServiceUrl(action, parameters);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");
        return new ResponseEntity<String>(WebServiceHelper.GetToJsonService(url), headers, HttpStatus.OK);
    }

    public static <T> T GetFromJsonService(String action, String parameters, Class<T> obj) {
        String url = WebServiceHelper.GetWebServiceUrl(action, parameters);
        String resposta = New(RestTemplate.class).getForObject(url, String.class);
        return New(JsonHelper.class).FromJson(resposta, obj);
    }

    public static ResponseEntity<String> PostCrud(String action, String obj, Map<String, String> vars) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");

        try {
            String url = WebServiceHelper.GetWebServiceUrl(action, null);
            String t = "";
            if (vars != null) {
                t = New(RestTemplate.class).postForObject(url, obj, String.class, vars);
            } else {
                t = New(RestTemplate.class).postForObject(url, obj, String.class);
            }

            return new ResponseEntity<String>(t, headers, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.NOT_FOUND);
        }
        // return WebServiceHelper.ToJsonService(action, action)
    }
}
