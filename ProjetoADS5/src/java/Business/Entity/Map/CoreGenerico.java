package Business.Entity.Map;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class CoreGenerico  implements Serializable {


     private int idGenerico;
     private CoreGenericoItem coreGenericoItem;
     private String nome;
     private String descricao;
     private Set<CoreGenericoItem> coreGenericoItems = new HashSet<CoreGenericoItem>(0);

    public CoreGenerico() {
    }

	
    public CoreGenerico(int idGenerico) {
        this.idGenerico = idGenerico;
    }
    public CoreGenerico(int idGenerico, CoreGenericoItem coreGenericoItem, String nome, String descricao, Set<CoreGenericoItem> coreGenericoItems) {
       this.idGenerico = idGenerico;
       this.coreGenericoItem = coreGenericoItem;
       this.nome = nome;
       this.descricao = descricao;
       this.coreGenericoItems = coreGenericoItems;
    }
   
    public int getIdGenerico() {
        return this.idGenerico;
    }
    
    public void setIdGenerico(int idGenerico) {
        this.idGenerico = idGenerico;
    }
    public CoreGenericoItem getCoreGenericoItem() {
        return this.coreGenericoItem;
    }
    
    public void setCoreGenericoItem(CoreGenericoItem coreGenericoItem) {
        this.coreGenericoItem = coreGenericoItem;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set<CoreGenericoItem> getCoreGenericoItems() {
        return this.coreGenericoItems;
    }
    
    public void setCoreGenericoItems(Set<CoreGenericoItem> coreGenericoItems) {
        this.coreGenericoItems = coreGenericoItems;
    }




}


