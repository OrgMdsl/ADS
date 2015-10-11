/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Business.Entity.Exemplo;
import Web.Controller.Helpers.JsonHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Programador
 */
@Controller
public class ChamadoController {
    /*
    @RequestMapping(value = "ExibeExemplo", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ExibeExemplo(@RequestParam int id) {
        return new JsonHelper<Exemplo>().ToJson();
    }
    */
}
