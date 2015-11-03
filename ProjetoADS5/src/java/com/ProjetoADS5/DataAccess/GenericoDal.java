/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess;

import com.ProjetoADS5.Business.Entity.Map.Generico;
import com.ProjetoADS5.DataAccess.Interface.IGenericoDal;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author matheusdsl
 */
public class GenericoDal extends DalHelper<Generico> implements IGenericoDal {

    @Override
    public Generico Buscar(String nome) {
        Session s = getSession();
        Criteria crit = s.createCriteria(Generico.class);
        try {
            crit.add(Restrictions.eq("nome", nome))
            .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            return (Generico) crit.uniqueResult();
        } finally {
            s.close();
        }
    }

}
