package Business.Entity.Map;



import java.util.HashSet;
import java.util.Set;


public class ChamadoTipoChamado  implements java.io.Serializable {


     private int idTipoChamado;
     private Integer idTipoChamadoPai;
     private String descricao;
     private Integer quantidadeHoraSla;
     private Set<ChamadoHistorico> chamadoHistoricos = new HashSet<ChamadoHistorico>(0);

    public ChamadoTipoChamado() {
    }

	
    public ChamadoTipoChamado(int idTipoChamado) {
        this.idTipoChamado = idTipoChamado;
    }
    public ChamadoTipoChamado(int idTipoChamado, Integer idTipoChamadoPai, String descricao, Integer quantidadeHoraSla, Set<ChamadoHistorico> chamadoHistoricos) {
       this.idTipoChamado = idTipoChamado;
       this.idTipoChamadoPai = idTipoChamadoPai;
       this.descricao = descricao;
       this.quantidadeHoraSla = quantidadeHoraSla;
       this.chamadoHistoricos = chamadoHistoricos;
    }
   
    public int getIdTipoChamado() {
        return this.idTipoChamado;
    }
    
    public void setIdTipoChamado(int idTipoChamado) {
        this.idTipoChamado = idTipoChamado;
    }
    public Integer getIdTipoChamadoPai() {
        return this.idTipoChamadoPai;
    }
    
    public void setIdTipoChamadoPai(Integer idTipoChamadoPai) {
        this.idTipoChamadoPai = idTipoChamadoPai;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getQuantidadeHoraSla() {
        return this.quantidadeHoraSla;
    }
    
    public void setQuantidadeHoraSla(Integer quantidadeHoraSla) {
        this.quantidadeHoraSla = quantidadeHoraSla;
    }
    public Set<ChamadoHistorico> getChamadoHistoricos() {
        return this.chamadoHistoricos;
    }
    
    public void setChamadoHistoricos(Set<ChamadoHistorico> chamadoHistoricos) {
        this.chamadoHistoricos = chamadoHistoricos;
    }




}


