/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;

import com.ProjetoADS5.Common.Const.AttributesConst;
import com.ProjetoADS5.Business.Entity.Map.Usuario;
import com.ProjetoADS5.Common.Dto.JsonResponseDto;
import com.ProjetoADS5.Web.Controller.Helpers.CookieHelper;

import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import com.ProjetoADS5.Web.Controller.Helpers.WebServiceHelper;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author matheusdsl
 */
@Controller
public class LoginController {

    JsonHelper JsonHelper = new JsonHelper();

    @RequestMapping(value = "PaginaLogin", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ModelAndView PaginaLogin(
            HttpServletRequest request,
            @CookieValue(value = "usuarioCookie", defaultValue = "") String usuarioCookie,
            @CookieValue(value = "senhaCookie", defaultValue = "") String senhaCookie) {
        ModelAndView mv = new ModelAndView("Login/Login"); //Arquivo que será aberto

        Cookie c = CookieHelper.obterCookie("usuarioCookie", request);
        if (c != null) {
            mv.addObject("usuarioCookie", c.getValue());
        }

        c = CookieHelper.obterCookie("senhaCookie", request);
        if (c != null) {
            mv.addObject("senhaCookie", c.getValue());
        }

        mv.addObject("ViewName", "Entrar"); //Nome da página
        mv.addObject("JsArchive", "additional/Login.js"); //Caminho do arquivo JS da página
        mv.addObject("PanelName", "Realizar login"); //Nome da tabela
        return mv;
    }

    @RequestMapping(value = "FazerLogin", produces = "application/json; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> FazerLogin(
            @RequestBody String obj,           
            HttpServletRequest request,
            HttpServletResponse response) {
        HttpSession sessao = request.getSession();
        Usuario u = JsonHelper.FromJson(obj, Usuario.class);
        String parametros
                = "usuario=" + u.getUsuario()
                + "&senha=" + u.getSenha();
/*
            Cookie c = new Cookie("usuarioCookie", u.getUsuario());
            c.setMaxAge(60); // em segundos
            response.addCookie(c);

            c = new Cookie("senhaCookie", u.getSenha());
            c.setMaxAge(60); // em segundos
            response.addCookie(c);
        */
        
        ResponseEntity<String> retorno = WebServiceHelper.GetToJsonService("FazerLogin", parametros, String.class);
        
        u = JsonHelper.FromJson(retorno.getBody(), Usuario.class);
        
        if(u == null)
            sessao.setAttribute(AttributesConst.LOGADO, false);
        else
            sessao.setAttribute(AttributesConst.LOGADO, true);
        
        
                
        return retorno;
    }

}
