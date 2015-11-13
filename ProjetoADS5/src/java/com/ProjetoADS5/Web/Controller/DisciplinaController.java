/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;


import com.ProjetoADS5.Business.Entity.Map.Disciplina;
import com.ProjetoADS5.DataAccess.Hibernate.HibernateUtil;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import com.ProjetoADS5.Web.Common.Const.AccessControlConst;
import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import com.ProjetoADS5.Web.Controller.Helpers.WebServiceHelper;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.ResponseEntity;
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
public class DisciplinaController {
    
    @RequestMapping(value = "PaginaDisciplina" + AccessControlConst.RESTRITO, produces = "text/html; charset=UTF8")
    public ModelAndView PaginaDisciplina() {
        ModelAndView mv = new ModelAndView("Disciplina/CadastrarDisciplina");
        mv.addObject("ViewName", "Disciplina");
        return mv;
    }
    
    @RequestMapping(value = "CadastrarDisciplina", method = RequestMethod.POST,headers = {"Content-type=application/json"})
    @ResponseBody
    public String CadastrarDisciplina(@RequestBody String obj) {       
        return WebServiceHelper.PostCrud("CadastrarDisciplina", obj, null);
    }
    
    @RequestMapping(value = "BuscarDisciplina", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarDisciplina(@RequestParam String id) {
        return WebServiceHelper.GetForObject("BuscarDisciplina", "id="+id, String.class);
    }
    
     @RequestMapping(value = "PesquisarDisciplina", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarDisciplina() {
        String retorno = WebServiceHelper.GetForObject("PesquisarDisciplina", null, String.class);
        return retorno;
    }
    
    @RequestMapping(value = "ExcluirDisciplina", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirDisciplina(@RequestParam String id) {
        String retorno = WebServiceHelper.GetForObject("ExcluirDisciplina", "id="+id, String.class);
        return retorno;
    }
    
    
}
