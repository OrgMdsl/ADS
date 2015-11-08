/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller.Helpers;

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
    JsonHelper JsonHelper = new JsonHelper();

    public static String GetWebServiceUrl(String action, String parameters) {
        return BASE_PATH + NAME_PROJECT + action + "WS" + "?" + (parameters != null ? parameters : "");
    }

    public static <T> T GetForObject(String action, String parameters, Class<T> classe) {
        RestTemplate template = new RestTemplate();
        String url = WebServiceHelper.GetWebServiceUrl(action, parameters);
        T resposta = template.getForObject(url, classe);
        return resposta;
    }

    public static <T> T GetFromJsonService(String url, Class<T> obj) {
        String resposta = new RestTemplate().getForObject(url, String.class);
        return new JsonHelper().FromJson(resposta, obj);
    }

    public static <T> ResponseEntity<T> GetToJsonService(String url, Class<T> obj) {
        return new RestTemplate().getForEntity(url, obj);
    }

    public static <T> ResponseEntity<T> GetToJsonService(String action, String parameters, Class<T> obj) {
        String url = WebServiceHelper.GetWebServiceUrl(action, parameters);
        ResponseEntity<T> retorno = WebServiceHelper.GetToJsonService(url, obj);
        return retorno;
    }

    public static <T> T GetFromJsonService(String action, String parameters, Class<T> obj) {
        String url = WebServiceHelper.GetWebServiceUrl(action, parameters);
        String resposta = new RestTemplate().getForObject(url, String.class);
        return new JsonHelper().FromJson(resposta, obj);
    }

    public static String PostCrud(String action, String obj, Map<String, String> vars) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");
        String url = WebServiceHelper.GetWebServiceUrl(action, null);
        String t = "";
        if (vars != null) {
            t = new RestTemplate().postForObject(url, obj, String.class, vars);
        } else {
            t = new RestTemplate().postForObject(url, obj, String.class);
        }
        return t;
    }

    public static ResponseEntity<String> SendParam(String action, String parametros) {
        String url = WebServiceHelper.GetWebServiceUrl(action, parametros);
        return new RestTemplate().getForEntity(url, String.class);
    }
}
