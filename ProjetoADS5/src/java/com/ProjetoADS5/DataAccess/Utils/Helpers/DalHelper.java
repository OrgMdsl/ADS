/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess.Utils.Helpers;

import com.ProjetoADS5.Common.Const.MessagesConst;
import com.ProjetoADS5.Common.Utils.Reflection;
import com.ProjetoADS5.DataAccess.Hibernate.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author matheusdsl
 * @param <T>
 */
public class DalHelper<T> implements IDalHelper<T> {

    private final Class<T> entityClass;

    public DalHelper(Class<T> entidade) {
        this.entityClass = entidade;
    }

    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    @Override
    public T Buscar(Integer id) {
        Session s = getSession();
        Criteria crit = s.createCriteria(entityClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        try {
            crit.add(Restrictions.eq("id", id));
            return (T) crit.uniqueResult();
        } finally {
            s.close();
        }
    }

    @Override
    public T BuscarPorAtributo(String atributo, String valor) {
        Session s = getSession();
        Criteria crit = s.createCriteria(entityClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        try {
            crit.add(Restrictions.eq(atributo, valor));
            return (T) crit.uniqueResult();
        } finally {
            //s.close();
        }
    }

    @Override
    public List<T> Pesquisar() {
        Session s = getSession();
        Criteria crit = s.createCriteria(entityClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        try {
            return crit.list();
        } finally {
            //s.close();
        }
    }

    @Override
    public List<T> PesquisarInativos() {
        Session s = getSession();
        Criteria crit = s.createCriteria(entityClass);
        try {
            crit.add(Restrictions.eq("ativo", false))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return crit.list();
        } finally {
            //s.close();
        }
    }

    @Override
    public List<T> PesquisarTodos() {
        Session s = getSession();
        Criteria crit = s.createCriteria(entityClass)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        try {
            return crit.list();
        } finally {
            //s.close();
        }
    }

    @Override
    public String Inserir(T obj) throws Exception {
        Session s = getSession();
        Transaction t = s.beginTransaction();

        Reflection.set(obj, "dataCadastro", DateTime.now().toDate());
        try {
            s.save(obj);
            t.commit();
            return MessagesConst.INSERIDO;
        } catch (Exception ex) {
            t.rollback();
            throw new Exception(ex.getMessage());
        } finally {
            s.close();
        }
    }

    @Override
    public String Atualizar(T obj) throws Exception {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        try {
            s.update(obj);
            t.commit();
            return MessagesConst.ATUALIZADO;
        } catch (Exception ex) {
            t.rollback();
            throw new Exception(ex.getMessage());
        } finally {
            s.close();
        }
    }

    @Override
    public String InserirAtualizar(T obj) throws Exception {
        Session s = getSession();
        Transaction t = s.beginTransaction();

        try {
            s.saveOrUpdate(obj);
            t.commit();
            return MessagesConst.INSERIDO;
        } catch (Exception ex) {
            t.rollback();
           throw new Exception(ex.getMessage());
        } finally {
            s.close();
        }
    }

    @Override
    public String Excluir(T obj) throws Exception {
        Session s = getSession();
        Transaction t = s.beginTransaction();

        Reflection.set(obj, "ativo", false);
        try {
            s.update(obj);
            t.commit();
            return MessagesConst.LIXEIRA;
        } catch (Exception ex) {
            t.rollback();
            throw new Exception(ex.getMessage());
        } finally {
            s.close();
        }
    }

    @Override
    public String ExcluirFisicamente(T obj) throws Exception {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        try {
            s.delete(obj);
            t.commit();
            return MessagesConst.EXCLUÍDO;
        } catch (Exception ex) {
            t.rollback();
            throw new Exception(ex.getMessage());
        } finally {
            s.close();
        }
    }

    @Override
    public String ToggleStatus(T obj) throws Exception {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        Boolean ativo = (Boolean) Reflection.get(obj, "ativo");
        if (ativo != null) {
            if (ativo) {
                Reflection.set(obj, "ativo", false);
            } else {
                Reflection.set(obj, "ativo", true);
            }
        } else {
            return "Não é possível alterar o status deste item, pois o mesmo não possui este atributo.";
        }
        try {
            s.update(obj);
            t.commit();
            return MessagesConst.ATUALIZADO;
        } catch (Exception ex) {
            t.rollback();
            throw new Exception(ex.getMessage());
        } finally {
            s.close();
        }
    }

    @Override
    public String ToggleStatus(Integer id) throws Exception {
        T obj = this.Buscar(id);
        return this.ToggleStatus(obj);
    }
}
