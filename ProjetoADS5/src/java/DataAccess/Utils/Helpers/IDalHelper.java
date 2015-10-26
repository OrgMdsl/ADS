/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Utils.Helpers;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author matheusdsl
 * @param <T>
 */
public interface IDalHelper<T> {
        
    T Buscar(Integer id);

    List<T> Pesquisar();
    
    List<T> PesquisarInativos();
    
    List<T> PesquisarTodos();

    ResponseEntity<String> Inserir(T obj);

    ResponseEntity<String> Atualizar(T obj);

    ResponseEntity<String> InserirAtualizar(T obj);

    ResponseEntity<String> Excluir(T obj);
    
    ResponseEntity<String> ExcluirFisicamente(T obj);
    
    ResponseEntity<String> ToggleStatus(T obj);
    
    ResponseEntity<String> ToggleStatus(Integer id);
}
