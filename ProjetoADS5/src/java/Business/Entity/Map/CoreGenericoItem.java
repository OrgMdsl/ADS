package Business.Entity.Map;

import java.util.HashSet;
import java.util.Set;

public class CoreGenericoItem  implements java.io.Serializable {


     private int idGenericoItem;
     private CoreGenerico coreGenerico;
     private String sigla;
     private String descricao;
     private Boolean ativo;

    public CoreGenericoItem() {
    }

	
    public CoreGenericoItem(int idGenericoItem) {
        this.idGenericoItem = idGenericoItem;
    }
    public CoreGenericoItem(int idGenericoItem, CoreGenerico coreGenerico, String sigla, String descricao, Boolean ativo) {
       this.idGenericoItem = idGenericoItem;
       this.coreGenerico = coreGenerico;
       this.sigla = sigla;
       this.descricao = descricao;
       this.ativo = ativo;
    }
   
    public int getIdGenericoItem() {
        return this.idGenericoItem;
    }
    
    public void setIdGenericoItem(int idGenericoItem) {
        this.idGenericoItem = idGenericoItem;
    }
    public CoreGenerico getCoreGenerico() {
        return this.coreGenerico;
    }
    
    public void setCoreGenerico(CoreGenerico coreGenerico) {
        this.coreGenerico = coreGenerico;
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

}


