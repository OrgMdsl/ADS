/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

import java.util.Set;

/**
 *
 * @author matheusdsl
 */
public class CoreGenerico {
    Integer id;
    String nome;
    String descricao;
    CoreGenericoItem itemDefault;
    Set<CoreGenericoItem> itens;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CoreGenericoItem getItemDefault() {
        return itemDefault;
    }

    public void setItemDefault(CoreGenericoItem itemDefault) {
        this.itemDefault = itemDefault;
    }

    public Set<CoreGenericoItem> getItens() {
        return itens;
    }

    public void setItens(Set<CoreGenericoItem> itens) {
        this.itens = itens;
    }
    
    
}
