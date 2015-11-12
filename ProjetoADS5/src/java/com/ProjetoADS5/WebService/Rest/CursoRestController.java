/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.WebService.Rest;

import com.ProjetoADS5.Business.Entity.Map.Curso;
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
public class CursoRestController {

    @RequestMapping(value = "CadastrarCurso" + ActionsConst.WEB_SERVICE, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String CadastrarCurso(@RequestBody String obj) {
        Curso _obj = new JsonHelper().FromJson(obj, Curso.class, true);
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(_obj);
        
        _obj.getDisciplinas().stream().forEach((d) -> {
            Disciplina disciplina = new DalHelper<Disciplina>(Disciplina.class).Buscar(d.getId());
            disciplina.setCursos(cursos);
            disciplinas.add(disciplina);
        });      
        _obj.setDisciplinas(disciplinas);
        
        if (_obj.getId() == null) {
            return new DalHelper<Curso>(Curso.class).Inserir(_obj);
        } else {
            return new DalHelper<Curso>(Curso.class).Atualizar(_obj);
        }
    }

    @RequestMapping(value = "ExcluirCurso" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String ExcluirCurso(@RequestParam String id) {
        Curso obj = new Curso();
        obj.setId(Integer.valueOf(id));
        return new DalHelper<Curso>(Curso.class).ExcluirFisicamente(obj);
    }

    @RequestMapping(value = "BuscarCurso" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String BuscarCurso(@RequestParam String id) {
        Curso o = new DalHelper<Curso>(Curso.class).Buscar(Integer.parseInt(id));
        return new JsonHelper().ToJson(o, true);
    }

    @RequestMapping(value = "PesquisarCurso" + ActionsConst.WEB_SERVICE, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String PesquisarCurso() {
        Session s = HibernateUtil.getSession();
        Criteria crit = s.createCriteria(Curso.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        try {
            return new JsonHelper().ToJson(crit.list(), true);
        } finally {
            s.close();
        }

    }

}
