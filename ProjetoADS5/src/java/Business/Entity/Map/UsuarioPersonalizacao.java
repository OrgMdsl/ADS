package Business.Entity.Map;

public class UsuarioPersonalizacao  implements java.io.Serializable {


     private int idPersonalizacao;
     private Usuario usuario;

    public UsuarioPersonalizacao() {
    }

	
    public UsuarioPersonalizacao(int idPersonalizacao) {
        this.idPersonalizacao = idPersonalizacao;
    }
    public UsuarioPersonalizacao(int idPersonalizacao, Usuario usuario) {
       this.idPersonalizacao = idPersonalizacao;
       this.usuario = usuario;
    }
   
    public int getIdPersonalizacao() {
        return this.idPersonalizacao;
    }
    
    public void setIdPersonalizacao(int idPersonalizacao) {
        this.idPersonalizacao = idPersonalizacao;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }




}


