package Business.Entity.Map;

public class CoreSistema  implements java.io.Serializable {


     private int idSistema;

    public CoreSistema() {
    }

    public CoreSistema(int idSistema) {
       this.idSistema = idSistema;
    }
   
    public int getIdSistema() {
        return this.idSistema;
    }
    
    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }




}


