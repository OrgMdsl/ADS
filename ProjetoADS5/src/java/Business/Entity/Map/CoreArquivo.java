package Business.Entity.Map;


import java.util.HashSet;
import java.util.Set;


public class CoreArquivo  implements java.io.Serializable {


     private int idArquivo;
     private String nome;
     private String extensao;
     private byte[] arquivo;
     private String url;
     private transient Set<ChamadoHistorico> chamadoHistoricos = new HashSet<ChamadoHistorico>(0);

    public CoreArquivo() {
    }

	
    public CoreArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }
    public CoreArquivo(int idArquivo, String nome, String extensao, byte[] arquivo, String url, Set<ChamadoHistorico> chamadoHistoricos) {
       this.idArquivo = idArquivo;
       this.nome = nome;
       this.extensao = extensao;
       this.arquivo = arquivo;
       this.url = url;
       this.chamadoHistoricos = chamadoHistoricos;
    }
   
    public int getIdArquivo() {
        return this.idArquivo;
    }
    
    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getExtensao() {
        return this.extensao;
    }
    
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }
    public byte[] getArquivo() {
        return this.arquivo;
    }
    
    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public Set<ChamadoHistorico> getChamadoHistoricos() {
        return this.chamadoHistoricos;
    }
    
    public void setChamadoHistoricos(Set<ChamadoHistorico> chamadoHistoricos) {
        this.chamadoHistoricos = chamadoHistoricos;
    }




}


