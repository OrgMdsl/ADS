package Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Contato implements java.io.Serializable {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;
    private Date dataCadastro;
    private List pessoaEmpresaContatos;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Contato() {
    }

    public Contato(Integer id) {
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

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List getPessoaEmpresaContatos() {
        return this.pessoaEmpresaContatos;
    }

    public void setPessoaEmpresaContatos(List pessoaEmpresaContatos) {
        this.pessoaEmpresaContatos = pessoaEmpresaContatos;
    }

}
