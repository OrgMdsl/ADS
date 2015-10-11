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
public class Chamado {
    Integer id;
    String descricaoSolicitacao;
    String descricaoSolucaoFinal;
    String tituloSolicitacao;
    Set<ChamadoHistorico> historico;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricaoSolicitacao() {
        return descricaoSolicitacao;
    }

    public void setDescricaoSolicitacao(String descricaoSolicitacao) {
        this.descricaoSolicitacao = descricaoSolicitacao;
    }

    public String getDescricaoSolucaoFinal() {
        return descricaoSolucaoFinal;
    }

    public void setDescricaoSolucaoFinal(String descricaoSolucaoFinal) {
        this.descricaoSolucaoFinal = descricaoSolucaoFinal;
    }

    public String getTituloSolicitacao() {
        return tituloSolicitacao;
    }

    public void setTituloSolicitacao(String tituloSolicitacao) {
        this.tituloSolicitacao = tituloSolicitacao;
    }

    public Set<ChamadoHistorico> getHistorico() {
        return historico;
    }

    public void setHistorico(Set<ChamadoHistorico> historico) {
        this.historico = historico;
    }
    
    
}
