package Business.Entity;
// Generated 10/10/2015 01:12:01 by Hibernate Tools 4.3.1



/**
 * Exemplo generated by hbm2java
 */
public class Exemplo  implements java.io.Serializable {


     private Integer id;
     private String nome;

    public Exemplo() {
    }

    public Exemplo(String nome) {
       this.nome = nome;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }




}


