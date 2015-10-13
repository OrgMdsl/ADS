/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Interface;

import Business.Entity.Map.CoreGenerico;
import Business.Entity.Map.CoreGenericoItem;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.util.Set;

/**
 *
 * @author matheusdsl
 */
public interface ICoreGenericoItemDal extends GenericDAO<CoreGenericoItem, Long> {
    CoreGenericoItem Buscar(Integer id);
    CoreGenericoItem BuscarPorSigla(String sigla, String nomePai);
    Set<CoreGenericoItem> GetItens(CoreGenerico pai);
}
