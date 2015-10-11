package Business.Entity.Map;



import java.util.HashSet;
import java.util.Set;

public class Chamado  implements java.io.Serializable {


     private int idChamado;
     private String descricaoSolicitacao;
     private String descricaoSolucaoFinal;
     private String tituloSolicitacao;
     private Set<ChamadoHistorico> chamadoHistoricos = new HashSet<ChamadoHistorico>(0);

    public Chamado() {
    }

	
    public Chamado(int idChamado) {
        this.idChamado = idChamado;
    }
    public Chamado(int idChamado, String descricaoSolicitacao, String descricaoSolucaoFinal, String tituloSolicitacao, Set<ChamadoHistorico> chamadoHistoricos) {
       this.idChamado = idChamado;
       this.descricaoSolicitacao = descricaoSolicitacao;
       this.descricaoSolucaoFinal = descricaoSolucaoFinal;
       this.tituloSolicitacao = tituloSolicitacao;
       this.chamadoHistoricos = chamadoHistoricos;
    }
   
    public int getIdChamado() {
        return this.idChamado;
    }
    
    public void setIdChamado(int idChamado) {
        this.idChamado = idChamado;
    }
    public String getDescricaoSolicitacao() {
        return this.descricaoSolicitacao;
    }
    
    public void setDescricaoSolicitacao(String descricaoSolicitacao) {
        this.descricaoSolicitacao = descricaoSolicitacao;
    }
    public String getDescricaoSolucaoFinal() {
        return this.descricaoSolucaoFinal;
    }
    
    public void setDescricaoSolucaoFinal(String descricaoSolucaoFinal) {
        this.descricaoSolucaoFinal = descricaoSolucaoFinal;
    }
    public String getTituloSolicitacao() {
        return this.tituloSolicitacao;
    }
    
    public void setTituloSolicitacao(String tituloSolicitacao) {
        this.tituloSolicitacao = tituloSolicitacao;
    }
    public Set<ChamadoHistorico> getChamadoHistoricos() {
        return this.chamadoHistoricos;
    }
    
    public void setChamadoHistoricos(Set<ChamadoHistorico> chamadoHistoricos) {
        this.chamadoHistoricos = chamadoHistoricos;
    }




}


