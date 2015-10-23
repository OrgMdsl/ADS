/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Business.Entity.Map.Generico;
import DataAccess.Interface.IGenericoDal;
import DataAccess.Utils.Helpers.DalHelper;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author matheusdsl
 */
public class GenericoDal extends DalHelper<Generico> implements IGenericoDal {
    
    @Override
    public Generico Buscar(String nome) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("nome", nome));
        return (Generico) crit.uniqueResult();
    }
    
    
}
