/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess.Utils.Helpers;

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

    String Inserir(T obj);

    String Atualizar(T obj);

    String InserirAtualizar(T obj);

    String Excluir(T obj);
    
    String ExcluirFisicamente(T obj);
    
    String ToggleStatus(T obj);
    
    String ToggleStatus(Integer id);
}
