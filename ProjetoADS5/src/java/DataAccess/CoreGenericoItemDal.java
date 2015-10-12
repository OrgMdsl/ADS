/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import DataAccess.Interface.ICoreGenericoItemDal;
import DataAccess.Utils.Helpers.DalHelper;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author matheusdsl
 */
public class CoreGenericoItemDal extends DalHelper<CoreGenericoItem> implements ICoreGenericoItemDal {

    @Override
    public CoreGenericoItem Buscar(String sigla, Integer idCoreGenerico) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("sigla", sigla));
        crit.add(Restrictions.eq("id_generico", idCoreGenerico));
        return (CoreGenericoItem) crit.uniqueResult();
    }

    @Override
    public Set<CoreGenericoItem> GetItens(CoreGenerico pai) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("id_generico", pai.getIdGenerico()));
        return new HashSet<CoreGenericoItem>(crit.list());
    }
    
}
