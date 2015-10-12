/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils.Helpers;

import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author matheusdsl
 * @param <T>
 */
public interface IDalHelper<T> {
    T Buscar(Integer id);
    List<T> Pesquisar();
    Criteria GetCriteria();
}
