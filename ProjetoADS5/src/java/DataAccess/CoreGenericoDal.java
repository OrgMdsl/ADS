/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import DataAccess.Interface.ICoreGenericoDal;
import DataAccess.Utils.Helpers.DalHelper;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author matheusdsl
 */
public class CoreGenericoDal extends GenericDAOImpl<CoreGenerico, Long> implements ICoreGenericoDal {

    @Override
    public CoreGenerico Buscar(Integer id) {
        return new DalHelper<CoreGenerico>().Buscar(id);
    }
    @Override
    public CoreGenerico Buscar(String nome) {
        Criteria crit = getSession().createCriteria(CoreGenerico.class);
        crit.add(Restrictions.eq("nome", nome));
        return (CoreGenerico) crit.uniqueResult();
    }
}
