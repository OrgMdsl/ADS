package com.ProjetoADS5.Business.Entity.Map;

import java.util.Date;
import java.util.List;


public class Atributo implements java.io.Serializable {

    private Integer id;
    private GenericoItem genericoItem;
    private String descricao;
    private Date dataCadastro;
    private List<ObjetoAtributo> objetoAtributos;
    private List<Atributo> atributoOpcaos;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Atributo() {
    }

    public Atributo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GenericoItem getGenericoItem() {
        return this.genericoItem;
    }

    public void setGenericoItem(GenericoItem genericoItem) {
        this.genericoItem = genericoItem;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List getObjetoAtributos() {
        return this.objetoAtributos;
    }

    public void setObjetoAtributos(List objetoAtributos) {
        this.objetoAtributos = objetoAtributos;
    }

    public List getAtributoOpcaos() {
        return this.atributoOpcaos;
    }

    public void setAtributoOpcaos(List atributoOpcaos) {
        this.atributoOpcaos = atributoOpcaos;
    }

}
