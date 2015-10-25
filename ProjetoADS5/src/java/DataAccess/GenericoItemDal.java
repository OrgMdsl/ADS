/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Business.Entity.Map.Generico;
import Business.Entity.Map.GenericoItem;
import DataAccess.Interface.IGenericoDal;
import DataAccess.Interface.IGenericoItemDal;
import DataAccess.Utils.Helpers.DalHelper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author matheusdsl
 */
public class GenericoItemDal extends DalHelper<GenericoItem> implements IGenericoItemDal {

    private IGenericoDal GenericoDal = new GenericoDal();

    @Override
    public GenericoItem BuscarPorSigla(String sigla, String nomePai) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("sigla", sigla));
        crit.add(Restrictions.eq("id_generico", GenericoDal.Buscar(nomePai).getId()));
        return (GenericoItem) crit.uniqueResult();
    }

    @Override
    public List<GenericoItem> GetItens(Generico pai) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("id_generico", pai.getId()));
        return crit.list();
    }

    @Override
    public List<GenericoItem> GetItens(Integer idPai) {
        Criteria crit = GetCriteria();
        crit.add(Restrictions.eq("id_generico", idPai));
        return crit.list();
    }   
}
