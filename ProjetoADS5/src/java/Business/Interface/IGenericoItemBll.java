/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Interface;

import Business.Entity.Map.GenericoItem;
import DataAccess.Utils.Helpers.IDalHelper;
import java.util.List;
import java.util.Set;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author matheusdsl
 */
public interface IGenericoItemBll extends IDalHelper<GenericoItem> {
    GenericoItem BuscarPorSigla(String sigla, String nomePai);
    List<GenericoItem> GetItens(Integer idPai);
    ResponseEntity<String> AtivarDesativar(Integer id);
}
