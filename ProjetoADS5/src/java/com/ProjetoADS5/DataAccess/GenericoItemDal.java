/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess;

import com.ProjetoADS5.Business.Entity.Map.Generico;
import com.ProjetoADS5.Business.Entity.Map.GenericoItem;
import com.ProjetoADS5.DataAccess.Interface.IGenericoDal;
import com.ProjetoADS5.DataAccess.Interface.IGenericoItemDal;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author matheusdsl
 */
public class GenericoItemDal extends DalHelper<GenericoItem> implements IGenericoItemDal {

    private IGenericoDal GenericoDal = new GenericoDal();

    @Override
    public GenericoItem BuscarPorSigla(String sigla, String nomePai) {
        Session s = getSession();
        Criteria crit = s.createCriteria(Generico.class);
        try {
            crit.add(Restrictions.eq("sigla", sigla));
            crit.add(Restrictions.eq("id_generico", GenericoDal.Buscar(nomePai).getId()));
            return (GenericoItem) crit.uniqueResult();
        } finally {
            s.close();
        }
    }

    @Override
    public List<GenericoItem> GetItens(Generico pai) {
        Session s = getSession();
        Criteria crit = s.createCriteria(Generico.class);
        try {
            crit.add(Restrictions.eq("id_generico", pai.getId()));
            return crit.list();
        } finally {
            s.close();
        }
    }

    @Override
    public List<GenericoItem> GetItens(Integer idPai) {
        Session s = getSession();
        Criteria crit = s.createCriteria(Generico.class);
        try {
            crit.add(Restrictions.eq("id_generico", idPai));
            return crit.list();
        } finally {
            s.close();
        }
    }
}
