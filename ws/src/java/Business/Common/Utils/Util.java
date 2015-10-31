/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Common.Utils;

import Business.Dto.Common.ErroDto;
import com.google.gson.Gson;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author matheusdsl
 */
public class Util {

    public static String DecimalDuasCasas(double valor)    
    {     
         return String.format("%.2f", valor);      
    }
    
    public static String EnviaErros(List<ErroDto> obj)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        String json = new Gson().toJson(obj);
        return json;
    }
}
