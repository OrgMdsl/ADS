package Business.Entity.Map;

import java.util.HashSet;
import java.util.Set;

public class UsuarioSetor  implements java.io.Serializable {


     private int idSetor;
     private String nome;
     private transient Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public UsuarioSetor() {
    }

	
    public UsuarioSetor(int idSetor) {
        this.idSetor = idSetor;
    }
    public UsuarioSetor(int idSetor, String nome, Set<Usuario> usuarios) {
       this.idSetor = idSetor;
       this.nome = nome;
       this.usuarios = usuarios;
    }
   
    public int getIdSetor() {
        return this.idSetor;
    }
    
    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


