package Business.Entity.Map;

import java.util.Date;

public class Usuario implements java.io.Serializable {

    private Integer id;
    private GenericoItem genericoItem;
    private PessoaEmpresa pessoaEmpresa;
    private String usuario;
    private String senha;
    private Date dataCadastro;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario() {
    }

    public Usuario(PessoaEmpresa pessoaEmpresa) {
        this.pessoaEmpresa = pessoaEmpresa;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GenericoItem getGenericoItem() {
        return this.genericoItem;
    }

    public void setGenericoItem(GenericoItem genericoItem) {
        this.genericoItem = genericoItem;
    }

    public PessoaEmpresa getPessoaEmpresa() {
        return this.pessoaEmpresa;
    }

    public void setPessoaEmpresa(PessoaEmpresa pessoaEmpresa) {
        this.pessoaEmpresa = pessoaEmpresa;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
