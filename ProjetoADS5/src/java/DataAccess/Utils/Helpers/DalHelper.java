/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils.Helpers;

import Business.Common.Const.MessagesConst;
import Business.Common.Utils.Reflection;
import DataAccess.Hibernate.HibernateUtil;
import DataAccess.Hibernate.HibernateUtility;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
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
public class DalHelper<T> extends GenericDAOImpl<T, Long> implements IDalHelper<T> {

    private final Class<T> entityClass;

    public DalHelper() {
        this.entityClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    protected Session getSession() {
        return HibernateUtil.getSession();
    }

    @Override
    public T Buscar(Integer id) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("id", id));
        return (T) crit.uniqueResult();
    }

    @Override
    public List<T> Pesquisar() {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("ativo", true));
        return crit.list();
    }

    @Override
    public List<T> PesquisarInativos() {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("ativo", false));
        return crit.list();
    }

    @Override
    public List<T> PesquisarTodos() {
        Criteria crit = GetCriteria();
        return crit.list();
    }

    @Override
    public Criteria GetCriteria() {
        return getSession().createCriteria(entityClass);
    }

    @Override
    public ResponseEntity<String> Inserir(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");
        Reflection.set(obj, "dataCadastro", DateTime.now().toDate());
        try {
            s.save(obj);
            t.commit();
            return new ResponseEntity<String>(MessagesConst.INSERIDO, headers, HttpStatus.CREATED);
        } catch (Exception ex) {
            t.rollback();
            return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            s.close();
        }
    }

    @Override
    public ResponseEntity<String> Atualizar(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");
        try {
            s.update(obj);
            t.commit();
            return new ResponseEntity<String>(MessagesConst.ATUALIZADO, headers, HttpStatus.CREATED);
        } catch (Exception ex) {
            t.rollback();
            return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            s.close();
        }
    }

    @Override
    public ResponseEntity<String> InserirAtualizar(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");

        Object o = Reflection.get(obj, "id");
        if (o == null) {
            Reflection.set(obj, "dataCadastro", DateTime.now().toDate());
        }
        try {
            s.saveOrUpdate(obj);
            t.commit();
            return new ResponseEntity<String>(MessagesConst.INSERIDO, headers, HttpStatus.CREATED);
        } catch (Exception ex) {
            t.rollback();
            return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            s.close();
        }
    }

    @Override
    public ResponseEntity<String> Excluir(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");
        Reflection.set(obj, "ativo", false);
        try {
            s.update(obj);
            t.commit();
            return new ResponseEntity<String>(MessagesConst.LIXEIRA, headers, HttpStatus.CREATED);
        } catch (Exception ex) {
            t.rollback();
            return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            s.close();
        }
    }

    @Override
    public ResponseEntity<String> ExcluirFisicamente(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf8");
        try {
            s.delete(obj);
            t.commit();
            return new ResponseEntity<String>(MessagesConst.EXCLUÍDO, headers, HttpStatus.CREATED);
        } catch (Exception ex) {
            t.rollback();
            return new ResponseEntity<String>(ex.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            s.close();
        }
    }
}
