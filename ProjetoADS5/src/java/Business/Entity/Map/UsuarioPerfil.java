package Business.Entity.Map;

import java.util.HashSet;
import java.util.Set;

public class UsuarioPerfil  implements java.io.Serializable {


     private int idPerfil;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

    public UsuarioPerfil() {
    }

	
    public UsuarioPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    public UsuarioPerfil(int idPerfil, Set<Usuario> usuarios) {
       this.idPerfil = idPerfil;
       this.usuarios = usuarios;
    }
   
    public int getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }




}


