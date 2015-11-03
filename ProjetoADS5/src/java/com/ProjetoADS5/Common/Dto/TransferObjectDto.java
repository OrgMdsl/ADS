/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Common.Dto;

import org.springframework.http.ResponseEntity;

/**
 *
 * @author matheusdsl
 * @param <T>
 */
public class TransferObjectDto<T> {
    
    T objeto;
    ResponseEntity<String> reponseEntity;
    String mensagem;

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public ResponseEntity<String> getReponseEntity() {
        return reponseEntity;
    }

    public void setReponseEntity(ResponseEntity<String> reponseEntity) {
        this.reponseEntity = reponseEntity;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
    
}
