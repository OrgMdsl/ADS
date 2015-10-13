/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils.Helpers;

import java.util.Set;
import org.hibernate.Criteria;

/**
 *
 * @author matheusdsl
 * @param <T>
 */
public interface IDalHelper<T> {

    T Buscar(Integer id);

    Set<T> Pesquisar();

    Criteria GetCriteria();

    String Inserir(T obj);

    String Atualizar(T obj);

    String InserirAtualizar(T obj);

    String Excluir(T obj);
}
