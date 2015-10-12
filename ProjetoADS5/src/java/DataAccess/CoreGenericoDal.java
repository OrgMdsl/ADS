/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Business.Entity.Map.CoreGenerico;
import DataAccess.Interface.ICoreGenericoDal;
import DataAccess.Utils.Helpers.DalHelper;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author matheusdsl
 */
public class CoreGenericoDal extends DalHelper<CoreGenerico> implements ICoreGenericoDal {
    
    @Override
    public CoreGenerico Buscar(String nome) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("nome", nome));
        return (CoreGenerico) crit.uniqueResult();
    }
}
