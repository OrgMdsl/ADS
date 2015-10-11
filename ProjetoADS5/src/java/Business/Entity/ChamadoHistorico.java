/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

import java.util.Date;

/**
 *
 * @author matheusdsl
 */
public class ChamadoHistorico {

    Integer id;
    Chamado chamado;
    Usuario atendente;
    Usuario solicitante;
    CoreArquivo arquivo;
    CoreGenericoItem chamadoPrioridade;
    CoreGenericoItem chamadoNivel;
    CoreGenericoItem chamadoStatus;
    ChamadoTipoChamado tipoChamado;
    Date data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Usuario getAtendente() {
        return atendente;
    }

    public void setAtendente(Usuario atendente) {
        this.atendente = atendente;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public CoreArquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(CoreArquivo arquivo) {
        this.arquivo = arquivo;
    }

    public CoreGenericoItem getChamadoPrioridade() {
        return chamadoPrioridade;
    }

    public void setChamadoPrioridade(CoreGenericoItem chamadoPrioridade) {
        this.chamadoPrioridade = chamadoPrioridade;
    }

    public CoreGenericoItem getChamadoNivel() {
        return chamadoNivel;
    }

    public void setChamadoNivel(CoreGenericoItem chamadoNivel) {
        this.chamadoNivel = chamadoNivel;
    }

    public CoreGenericoItem getChamadoStatus() {
        return chamadoStatus;
    }

    public void setChamadoStatus(CoreGenericoItem chamadoStatus) {
        this.chamadoStatus = chamadoStatus;
    }

    public ChamadoTipoChamado getTipoChamado() {
        return tipoChamado;
    }

    public void setTipoChamado(ChamadoTipoChamado tipoChamado) {
        this.tipoChamado = tipoChamado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
