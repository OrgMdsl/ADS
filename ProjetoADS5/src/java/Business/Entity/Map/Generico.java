package Business.Entity.Map;

import java.util.Date;
import java.util.List;

public class Generico implements java.io.Serializable {

    private Integer id;
    private String nome;
    private String descricao;
    private Date dataCadastro;
    private List<GenericoItem> genericoItems;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Generico() {
    }

    public Generico(Integer id) {
        this.id = id;
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

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List getGenericoItems() {
        return this.genericoItems;
    }

    public void setGenericoItems(List genericoItems) {
        this.genericoItems = genericoItems;
    }

}
