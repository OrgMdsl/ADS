/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.WebService.Rest;

import com.ProjetoADS5.Common.Const.ActionsConst;
import com.ProjetoADS5.Business.Entity.Map.Usuario;
import com.ProjetoADS5.Business.Interface.IUsuarioBll;
import com.ProjetoADS5.Business.UsuarioBll;

import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matheusdsl
 */
@RestController
public class LoginRestController {

    private final IUsuarioBll UsuarioBll = new UsuarioBll(Usuario.class);
    private final JsonHelper JsonHelper = new JsonHelper();

    @RequestMapping(value = "FazerLogin" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=UTF8")
    @ResponseBody
    public String FazerLogin(String usuario, String senha, HttpSession sessao) throws Exception {
        Usuario obj = this.UsuarioBll.ValidarUsuario(usuario, senha);
        String retorno = JsonHelper.ToJson(obj, true);
        return retorno;
    }

}
