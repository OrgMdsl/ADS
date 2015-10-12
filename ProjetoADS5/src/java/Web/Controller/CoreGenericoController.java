/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Business.CoreGenericoBll;
import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.Exemplo;
import Web.Controller.Helpers.JsonHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author matheusdsl
 */
@Controller
public class CoreGenericoController {
    
    private final CoreGenericoBll CoreGenericoBll = new CoreGenericoBll();
    
    
    @RequestMapping(value = "BuscaCoreGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaCoreGenerico(@RequestParam int id) {
        return new JsonHelper<CoreGenerico>().ToJson(this.CoreGenericoBll.Buscar(id));
    }    
    
    @RequestMapping(value = "BuscaCoreGenericoNome", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> BuscaCoreGenericoNome(@RequestParam String nome) {
        return new JsonHelper<CoreGenerico>().ToJson(this.CoreGenericoBll.GetByName(nome));
    }     
    
    @RequestMapping(value = "SalvarCoreGenerico", produces = "text/html; charset=UTF8")
    @ResponseBody
    public String SalvarCoreGenerico(@RequestParam String nome) {
        CoreGenerico c = new CoreGenerico();
        c.setNome(nome);
        c.setDescricao("Nível");
        
        new CoreGenericoBll().save(c);
        return "SALVOU ESSA BAGAÇA!!!";
    }
}
