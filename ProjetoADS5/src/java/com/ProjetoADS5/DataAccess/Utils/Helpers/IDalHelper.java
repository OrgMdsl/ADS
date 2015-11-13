/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.DataAccess.Utils.Helpers;

import java.util.List;

/**
 *
 * @author matheusdsl
 * @param <T>
 */
public interface IDalHelper<T> {
        
    T Buscar(Integer id);
    
    T BuscarPorAtributo(String atributo, String valor);
    
    List<T> Pesquisar();
    
    List<T> PesquisarInativos();
    
    List<T> PesquisarTodos();

    String Inserir(T obj) throws Exception;

    String Atualizar(T obj) throws Exception;

    String InserirAtualizar(T obj) throws Exception;

    String Excluir(T obj) throws Exception;
    
    String ExcluirFisicamente(T obj) throws Exception;
    
    String ToggleStatus(T obj) throws Exception;
    
    String ToggleStatus(Integer id) throws Exception;
}
