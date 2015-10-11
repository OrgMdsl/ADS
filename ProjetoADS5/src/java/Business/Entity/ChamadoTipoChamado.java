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
public class ChamadoTipoChamado {
    Integer id;
    Integer quantidadeHorasSla;
    String descricao;
    ChamadoTipoChamado tipoChamadoPai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidadeHorasSla() {
        return quantidadeHorasSla;
    }

    public void setQuantidadeHorasSla(Integer quantidadeHorasSla) {
        this.quantidadeHorasSla = quantidadeHorasSla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ChamadoTipoChamado getTipoChamadoPai() {
        return tipoChamadoPai;
    }

    public void setTipoChamadoPai(ChamadoTipoChamado tipoChamadoPai) {
        this.tipoChamadoPai = tipoChamadoPai;
    }
    
}
