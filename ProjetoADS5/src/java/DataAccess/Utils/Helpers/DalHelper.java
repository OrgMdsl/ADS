/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils.Helpers;

import br.com.configuration.HibernateUtility;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
    public List<T> Pesquisar() {
        Criteria crit = GetCriteria();
        return crit.list();
    }

    @Override
    public Criteria GetCriteria() {
        return getSession().createCriteria(entityClass);
    }

}
