package com.ProjetoADS5.Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Contrato implements java.io.Serializable {

    private Integer id;
    private Cliente cliente;
    private Date dataCadastro;
    private List<ContratoMaquina> contratoMaquinas;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Contrato() {
    }

    public Contrato(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List getContratoMaquinas() {
        return this.contratoMaquinas;
    }

    public void setContratoMaquinas(List contratoMaquinas) {
        this.contratoMaquinas = contratoMaquinas;
    }

}
