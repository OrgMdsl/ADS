/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Web.Controller;

import com.ProjetoADS5.WebService.Rest.*;
import com.ProjetoADS5.Business.Entity.Map.Disciplina;
import com.ProjetoADS5.Business.Entity.Map.Professor;
import com.ProjetoADS5.Common.Const.ActionsConst;
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
public class ProfessorController {

    @RequestMapping(value = "CadastrarProfessor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public void CadastrarProfessor(@RequestBody String obj) {
        Professor _obj = new JsonHelper().FromJson(obj, Professor.class);

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

    @RequestMapping(value = "BuscarProfessor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarProfessor(@RequestParam String id) {
        Professor o = new DalHelper<Professor>().Buscar(Integer.parseInt(id));
        return new JsonHelper().ToJson(o, true);
    }

    @RequestMapping(value = "PesquisarProfessor", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarProfessor() {
        List<Professor> o = new DalHelper<Professor>().Pesquisar();
        return new JsonHelper().ToJson(o, true);
    }

}
