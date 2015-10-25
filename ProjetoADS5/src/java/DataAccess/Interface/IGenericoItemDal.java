/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Interface;

import Business.Entity.Map.Generico;
import Business.Entity.Map.GenericoItem;
import DataAccess.Utils.Helpers.IDalHelper;
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
