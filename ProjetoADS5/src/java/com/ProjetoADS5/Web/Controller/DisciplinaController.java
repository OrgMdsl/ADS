/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;


import com.ProjetoADS5.Business.Entity.Map.Disciplina;
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
public class DisciplinaController {
    
    @RequestMapping(value = "CadastrarDisciplina", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public void CadastrarDisciplina(@RequestBody String obj) {
        Disciplina _obj = new JsonHelper().FromJson(obj, Disciplina.class);
             
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
    
    @RequestMapping(value = "BuscarDisciplina", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarDisciplina(@RequestParam String id) {
        Disciplina o = new DalHelper<Disciplina>().Buscar(Integer.parseInt(id));    
        return new JsonHelper().ToJson(o, true);
    }
    
     @RequestMapping(value = "PesquisarDisciplina", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarDisciplina() {
        List<Disciplina> o = new DalHelper<Disciplina>().Pesquisar();    
        return new JsonHelper().ToJson(o, true);
    }
    
    
}
