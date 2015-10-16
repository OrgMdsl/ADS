/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Interface;

import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import DataAccess.Utils.Helpers.IDalHelper;
import java.util.Set;

/**
 *
 * @author matheusdsl
 */
public interface ICoreGenericoItemBll extends IDalHelper<CoreGenericoItem> {
    CoreGenericoItem BuscarPorSigla(String sigla, String nomePai);
    Set<CoreGenericoItem> GetItens(Integer idPai);
}
