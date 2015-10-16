package Business.Entity.Map;

public class CoreGenericoItem  implements java.io.Serializable {

     private int idGenericoItem;
     private String sigla;
     private String descricao;
     private Boolean ativo;
     private transient CoreGenerico coreGenerico;

    

    public CoreGenericoItem() {
    }

	
    public CoreGenericoItem(int idGenericoItem) {
        this.idGenericoItem = idGenericoItem;
    }

    public CoreGenericoItem(int idGenericoItem, CoreGenerico coreGenerico, String sigla, String descricao, Boolean ativo) {
       this.idGenericoItem = idGenericoItem;
       this.sigla = sigla;
       this.descricao = descricao;
       this.ativo = ativo;
       this.coreGenerico = coreGenerico;
    }
   
    public int getIdGenericoItem() {
        return this.idGenericoItem;
    }
    
    public void setIdGenericoItem(int idGenericoItem) {
        this.idGenericoItem = idGenericoItem;
    }
    public String getSigla() {
        return this.sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Boolean getAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    public CoreGenerico getCoreGenerico() {
        return coreGenerico;
    }

    public void setCoreGenerico(CoreGenerico coreGenerico) {
        this.coreGenerico = coreGenerico;
    }

}


