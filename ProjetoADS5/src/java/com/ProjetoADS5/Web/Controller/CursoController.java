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
public class CursoController {
    
    @RequestMapping(value = "PaginaCurso" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaCurso() {
        ModelAndView mv = new ModelAndView("Curso/CadastrarCurso");
        mv.addObject("ViewName", "Curso");
        return mv;
    }
    
    @RequestMapping(value = "PaginaEditarCurso" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaEditarCurso(@RequestParam String id) {
        ModelAndView mv = new ModelAndView("Curso/CadastrarCurso");
        mv.addObject("ViewName", "Curso");
        mv.addObject("ObjId", id);
        return mv;
    }
    
    @RequestMapping(value = "CadastrarCurso", method = RequestMethod.POST,headers = {"Content-type=application/json"})
    @ResponseBody
    public String CadastrarCurso(@RequestBody String obj) {       
        return WebServiceHelper.PostCrud("CadastrarCurso", obj, null);
    }
    
    @RequestMapping(value = "BuscarCurso", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarCurso(@RequestParam String id) {
        return WebServiceHelper.GetForObject("BuscarCurso", "id="+id, String.class);
    }
    
     @RequestMapping(value = "PesquisarCurso", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarCurso() {
        String retorno = WebServiceHelper.GetForObject("PesquisarCurso", null, String.class);
        return retorno;
    }
    
    @RequestMapping(value = "ExcluirCurso", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirCurso(@RequestParam String id) {
        return WebServiceHelper.GetForObject("ExcluirCurso", "id="+id, String.class);
    }
    
    
}
