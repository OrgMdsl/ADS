/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;


import com.ProjetoADS5.Web.Common.Const.AccessControlConst;
import com.ProjetoADS5.Web.Controller.Helpers.WebServiceHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author matheusdsl
 */
@Controller
public class ProfessorController {
    
    @RequestMapping(value = "PaginaProfessor" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaProfessor() {
        ModelAndView mv = new ModelAndView("Professor/CadastrarProfessor");
        mv.addObject("ViewName", "Professor");
        return mv;
        
    }
    
    @RequestMapping(value = "PaginaEditarProfessor" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaEditarProfessor(@RequestParam String id) {
        ModelAndView mv = new ModelAndView("Professor/CadastrarProfessor");
        mv.addObject("ViewName", "Professor");
        mv.addObject("ObjId", id);
        return mv;
    }
    
    @RequestMapping(value = "CadastrarProfessor", method = RequestMethod.POST,headers = {"Content-type=application/json"})
    @ResponseBody
    public String CadastrarProfessor(@RequestBody String obj) {       
        return WebServiceHelper.PostCrud("CadastrarProfessor", obj, null);
    }
    
    @RequestMapping(value = "BuscarProfessor", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarProfessor(@RequestParam String id) {
        return WebServiceHelper.GetForObject("BuscarProfessor", "id="+id, String.class);
    }
    
     @RequestMapping(value = "PesquisarProfessor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarProfessor() {
        String retorno = WebServiceHelper.GetForObject("PesquisarProfessor", null, String.class);
        return retorno;
    }
    
    @RequestMapping(value = "ExcluirProfessor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirProfessor(@RequestParam String id) {
        return WebServiceHelper.GetForObject("ExcluirProfessor", "id="+id, String.class);
    }
    
    
}
