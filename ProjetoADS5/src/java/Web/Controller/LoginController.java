/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author matheusdsl
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "PaginaLogin", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaLogin() {
        ModelAndView mv = new ModelAndView("Login/Login"); //Arquivo que será aberto
        mv.addObject("ViewName", "Entrar"); //Nome da página
        mv.addObject("JsArchive", "additional/Login.js"); //Caminho do arquivo JS da página
        mv.addObject("PanelName", "Realizar login"); //Nome da tabela
        return mv;
    }
    
    @RequestMapping(value = "FazerLogin", produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> FazerLogin() {
        ResponseEntity<String> a = null;
        return a;//Teste
    }
    
}
