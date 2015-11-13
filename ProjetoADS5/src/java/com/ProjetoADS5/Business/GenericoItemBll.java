/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business;

import com.ProjetoADS5.Business.Entity.Map.GenericoItem;
import com.ProjetoADS5.Business.Interface.IGenericoItemBll;
import com.ProjetoADS5.DataAccess.GenericoItemDal;
import com.ProjetoADS5.DataAccess.Interface.IGenericoItemDal;
import com.ProjetoADS5.DataAccess.Utils.Helpers.DalHelper;
import java.util.List;

/**
 *
 * @author matheusdsl
 */
public class GenericoItemBll extends DalHelper<GenericoItem> implements IGenericoItemBll {

    public final IGenericoItemDal GenericoItemDal = new GenericoItemDal(GenericoItem.class);

    public GenericoItemBll(Class<GenericoItem> entidade) {
        super(entidade);
    }

    @Override
    public GenericoItem BuscarPorSigla(String sigla, String nomePai) {
        return GenericoItemDal.BuscarPorSigla(sigla, nomePai);
    }

    @Override
    public List<GenericoItem> GetItens(Integer idPai) {
        return GenericoItemDal.GetItens(idPai);
    }

    @Override
    public String AtivarDesativar(Integer id) throws Exception {
        GenericoItem obj = GenericoItemDal.Buscar(id);
        obj.setAtivo(!obj.getAtivo());      
        return GenericoItemDal.Atualizar(obj);         
    }
}
