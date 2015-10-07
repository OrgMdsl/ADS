/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Business.ExemploBll;
import Business.Interface.IExemploBll;
import Business.Entity.Exemplo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Web.Controller.Helpers.JsonHelper;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author matheusdsl
 */
@Controller
public class ExemploController {

    private final IExemploBll ExemploBll;

    public ExemploController() {
        this.ExemploBll = new ExemploBll();
    }

    @RequestMapping(value = "ExibeExemplo", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ExibeExemplo(@RequestParam int id) {
        return new JsonHelper<Exemplo>().ToJson(this.ExemploBll.Buscar(id));
    }
}
