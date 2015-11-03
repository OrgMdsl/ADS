/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;

import com.ProjetoADS5.Business.Entity.Map.Curso;
import com.ProjetoADS5.DataAccess.Hibernate.HibernateUtil;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author matheusdsl
 */
@Controller
public class CursoController {
    
    @RequestMapping(value = "CadastrarCurso", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public void CadastrarCurso(@RequestBody String obj) {
        Curso _obj = new JsonHelper().FromJson(obj, Curso.class);
                
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        try {
            s.saveOrUpdate(_obj);
            t.commit();            
        } catch (Exception ex) {
            t.rollback();            
        } finally {
            s.close();
        }
    }
    
    @RequestMapping(value = "BuscarCurso", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarCurso(@RequestParam String id) {
        Curso c = new DalHelper<Curso>().Buscar(Integer.parseInt(id));    
        return new JsonHelper().ToJson(c, true);
    }
    
     @RequestMapping(value = "PesquisarCurso", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarCurso() {
        List<Curso> c = new DalHelper<Curso>().Pesquisar();    
        return new JsonHelper().ToJson(c, true);
    }
    
}
