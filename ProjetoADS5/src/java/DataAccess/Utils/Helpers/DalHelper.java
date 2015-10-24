/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils.Helpers;

import Business.Common.Const.MessagesConst;
import Business.Entity.Map.Auditoria;
import br.com.configuration.HibernateUtility;
import com.google.gson.Gson;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.json.JSONException;
import org.json.JSONObject;

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
        return HibernateUtility.getSession();
    }

    @Override
    public T Buscar(Integer id) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("id", id));
        return (T) crit.uniqueResult();
    }

    @Override
    public Set<T> Pesquisar() {
        Criteria crit = GetCriteria();
        return new HashSet<T>(crit.list());
    }

    @Override
    public Criteria GetCriteria() {
        return getSession().createCriteria(entityClass);
    }

    @Override
    public String Inserir(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        try {
            s.save(obj);
            t.commit();
            return MessagesConst.INSERIDO;
        } catch (Exception ex) {
            t.rollback();
            throw ex;
        } finally {
            s.close();
        }
    }

    @Override
    public String Atualizar(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        try {

            s.update(obj);
            t.commit();
            return MessagesConst.ATUALIZADO;
        } catch (Exception ex) {
            t.rollback();
            throw ex;
        } finally {
            s.close();
        }
    }

    @Override
    public String InserirAtualizar(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        try {
            s.saveOrUpdate(obj);
            t.commit();
            return MessagesConst.INSERIDO;
        } catch (Exception ex) {
            t.rollback();
            throw ex;
        } finally {
            s.close();
        }
    }

    @Override
    public String Excluir(T obj) {
        Session s = getSession();
        Transaction t = s.beginTransaction();
        try {
            s.delete(obj);
            t.commit();
            return MessagesConst.EXCLUÍDO;
        } catch (Exception ex) {
            t.rollback();
            throw ex;
        } finally {
            s.close();
        }
    }

    private void Auditoria(T obj) {
        JsonHelper json = new JsonHelper();
        Gson gson = new Gson();
        String j = json.ToJson(obj);
        JSONObject object = new JSONObject(json);
        Object auditoria = null;
        try {
            auditoria = object.getJSONObject("auditoria");
        } catch (JSONException ex) {
            Logger.getLogger(DalHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        Auditoria a = (Auditoria) auditoria;

        Auditoria audit = new Auditoria();
    }
}
