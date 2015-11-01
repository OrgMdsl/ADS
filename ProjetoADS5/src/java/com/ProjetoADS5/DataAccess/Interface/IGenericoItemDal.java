/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess.Interface;

import com.ProjetoADS5.Business.Entity.Map.Generico;
import com.ProjetoADS5.Business.Entity.Map.GenericoItem;
import com.ProjetoADS5.DataAccess.Utils.Helpers.IDalHelper;
import java.util.List;

/**
 *
 * @author matheusdsl
 */
public interface IGenericoItemDal extends  IDalHelper<GenericoItem> {
    GenericoItem Buscar(Integer id);
    GenericoItem BuscarPorSigla(String sigla, String nomePai);
    List<GenericoItem> GetItens(Generico pai);
    List<GenericoItem> GetItens(Integer idPai);
}
