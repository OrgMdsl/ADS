package com.ProjetoADS5.Business.Entity.Map;

import java.util.Date;

public class ComponenteMaquina implements java.io.Serializable {

    private Integer id;
    private Fabricante fabricante;
    private GenericoItem genericoItem;
    private Maquina maquina;
    private Objeto objeto;
    private Date dataCadastro;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ComponenteMaquina() {
    }

    public ComponenteMaquina(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Fabricante getFabricante() {
        return this.fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public GenericoItem getGenericoItem() {
        return this.genericoItem;
    }

    public void setGenericoItem(GenericoItem genericoItem) {
        this.genericoItem = genericoItem;
    }

    public Maquina getMaquina() {
        return this.maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Objeto getObjeto() {
        return this.objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
