/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Interface;

import Business.Entity.Map.Generico;
import Business.Entity.Map.GenericoItem;
import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.util.Set;

/**
 *
 * @author matheusdsl
 */
public interface IGenericoItemDal extends GenericDAO<GenericoItem, Long> {
    GenericoItem Buscar(Integer id);
    GenericoItem BuscarPorSigla(String sigla, String nomePai);
    Set<GenericoItem> GetItens(Generico pai);
    Set<GenericoItem> GetItens(Integer idPai);
}
