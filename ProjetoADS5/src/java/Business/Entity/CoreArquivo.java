/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

/**
 *
 * @author matheusdsl
 */
public class CoreArquivo {
    Integer id;
    String nome;
    String extensao;
    Byte arquivo;
    String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    public Byte getArquivo() {
        return arquivo;
    }

    public void setArquivo(Byte arquivo) {
        this.arquivo = arquivo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
