package Business.Entity.Map;


public class CoreConfiguracao  implements java.io.Serializable {


     private int idConfiguracao;

    public CoreConfiguracao() {
    }

    public CoreConfiguracao(int idConfiguracao) {
       this.idConfiguracao = idConfiguracao;
    }
   
    public int getIdConfiguracao() {
        return this.idConfiguracao;
    }
    
    public void setIdConfiguracao(int idConfiguracao) {
        this.idConfiguracao = idConfiguracao;
    }




}


