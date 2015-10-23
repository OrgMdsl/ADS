package Business.Entity.Map;
// Generated 23/10/2015 01:12:45 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * ObjetoAtributoValor generated by hbm2java
 */
public class ObjetoAtributoValor  implements java.io.Serializable {


     private int idObjetoAtributoValor;
     private AtributoOpcao atributoOpcao;
     private Auditoria auditoria;
     private ObjetoAtributo objetoAtributo;
     private Date dataCadastro;

    public ObjetoAtributoValor() {
    }

	
    public ObjetoAtributoValor(int idObjetoAtributoValor) {
        this.idObjetoAtributoValor = idObjetoAtributoValor;
    }
    public ObjetoAtributoValor(int idObjetoAtributoValor, AtributoOpcao atributoOpcao, Auditoria auditoria, ObjetoAtributo objetoAtributo, Date dataCadastro) {
       this.idObjetoAtributoValor = idObjetoAtributoValor;
       this.atributoOpcao = atributoOpcao;
       this.auditoria = auditoria;
       this.objetoAtributo = objetoAtributo;
       this.dataCadastro = dataCadastro;
    }
   
    public int getIdObjetoAtributoValor() {
        return this.idObjetoAtributoValor;
    }
    
    public void setIdObjetoAtributoValor(int idObjetoAtributoValor) {
        this.idObjetoAtributoValor = idObjetoAtributoValor;
    }
    public AtributoOpcao getAtributoOpcao() {
        return this.atributoOpcao;
    }
    
    public void setAtributoOpcao(AtributoOpcao atributoOpcao) {
        this.atributoOpcao = atributoOpcao;
    }
    public Auditoria getAuditoria() {
        return this.auditoria;
    }
    
    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }
    public ObjetoAtributo getObjetoAtributo() {
        return this.objetoAtributo;
    }
    
    public void setObjetoAtributo(ObjetoAtributo objetoAtributo) {
        this.objetoAtributo = objetoAtributo;
    }
    public Date getDataCadastro() {
        return this.dataCadastro;
    }
    
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }




}


