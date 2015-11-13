/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.WebService.Rest;

import com.ProjetoADS5.Business.Entity.Map.Professor;
import com.ProjetoADS5.Business.Entity.Map.Disciplina;
import com.ProjetoADS5.Common.Const.ActionsConst;
import com.ProjetoADS5.Common.Const.MessagesConst;
import com.ProjetoADS5.Common.Utils.Reflection;
import com.ProjetoADS5.DataAccess.Hibernate.HibernateUtil;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import com.ProjetoADS5.Web.Controller.Helpers.JsonHelper;
import java.util.ArrayList;
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
public class ProfessorRestController {

    @RequestMapping(value = "CadastrarProfessor" + ActionsConst.WEB_SERVICE, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String CadastrarProfessor(@RequestBody String obj) throws Exception {
        Professor _obj = new JsonHelper().FromJson(obj, Professor.class);
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        List<Professor> professores = new ArrayList<Professor>();
        professores.add(_obj);
        
        _obj.getDisciplinas().stream().forEach((d) -> {
            Disciplina disciplina = new DalHelper<Disciplina>(Disciplina.class).Buscar(d.getId());
            disciplina.setProfessores(professores);
            disciplinas.add(disciplina);
        });      
        _obj.setDisciplinas(disciplinas);
        
        if (_obj.getId() == null) {
            return new JsonHelper().ToJson(new DalHelper<Professor>(Professor.class).Inserir(_obj), true);
        } else {
            return new JsonHelper().ToJson(new DalHelper<Professor>(Professor.class).Atualizar(_obj), true);
        }
    }

    @RequestMapping(value = "ExcluirProfessor" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirProfessor(@RequestParam String id) throws Exception {
        Professor obj = new Professor();
        obj.setId(Integer.valueOf(id));
        return new JsonHelper().ToJson(new DalHelper<Professor>(Professor.class).ExcluirFisicamente(obj), true);
    }

    @RequestMapping(value = "BuscarProfessor" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarProfessor(@RequestParam String id) throws Exception {
        Professor o = new DalHelper<Professor>(Professor.class).Buscar(Integer.parseInt(id));
        return new JsonHelper().ToJson(o, true);
    }

    @RequestMapping(value = "PesquisarProfessor" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarProfessor() throws Exception {
        Session s = HibernateUtil.getSession();
        Criteria crit = s.createCriteria(Professor.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        try {
            return new JsonHelper().ToJson(crit.list(), true);
        } finally {
            s.close();
        }

    }

}
