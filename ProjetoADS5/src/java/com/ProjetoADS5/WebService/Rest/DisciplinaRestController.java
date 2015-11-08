/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.WebService.Rest;


import com.ProjetoADS5.Business.Entity.Map.Disciplina;
import com.ProjetoADS5.Common.Const.ActionsConst;
import com.ProjetoADS5.Common.Const.MessagesConst;
import com.ProjetoADS5.Common.Utils.Reflection;
import com.ProjetoADS5.DataAccess.Hibernate.HibernateUtil;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.joda.time.DateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matheusdsl
 */
@RestController
public class DisciplinaRestController {
    
    @RequestMapping(value = "CadastrarDisciplina" + ActionsConst.WEB_SERVICE, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String CadastrarDisciplina(@RequestBody String obj) {
        Disciplina _obj = new JsonHelper().FromJson(obj, Disciplina.class);
        
        if (_obj.getId() == null) {
            return new DalHelper<Disciplina>(Disciplina.class).Inserir(_obj);
        } else {
            return new DalHelper<Disciplina>(Disciplina.class).Atualizar(_obj);
        }
    }
    
    @RequestMapping(value = "ExcluirDisciplina" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirDisciplina(@RequestParam String id) {
        Disciplina obj = new Disciplina();
        obj.setId(Integer.valueOf(id));
        return new DalHelper<Disciplina>(Disciplina.class).ExcluirFisicamente(obj);
    }
    
    @RequestMapping(value = "BuscarDisciplina" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarDisciplina(@RequestParam String id) {
        Disciplina o = new DalHelper<Disciplina>(Disciplina.class).Buscar(Integer.parseInt(id));    
        return new JsonHelper().ToJson(o, true);
    }
    
     @RequestMapping(value = "PesquisarDisciplina" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarDisciplina() {
        Session s = HibernateUtil.getSession();
        Criteria crit = s.createCriteria(Disciplina.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        try {
           return new JsonHelper().ToJson(crit.list(), true);
        } finally {
            s.close();
        }
        
    }
    
    
}
