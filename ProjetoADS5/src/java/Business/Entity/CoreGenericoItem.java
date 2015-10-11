/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

/**
 *
 * @author matheusdsl
 */
public class CoreGenericoItem {
    Integer id;
    CoreGenerico generico;
    String sigla;
    String descricao;
    boolean ativo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CoreGenerico getGenerico() {
        return generico;
    }

    public void setGenerico(CoreGenerico generico) {
        this.generico = generico;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
}
