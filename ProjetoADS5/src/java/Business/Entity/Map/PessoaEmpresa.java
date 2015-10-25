package Business.Entity.Map;

import java.util.Date;
import java.util.List;

public class PessoaEmpresa implements java.io.Serializable {

    private Integer id;
    private String nome;
    private String cnpj;
    private String cpf;
    private Date dataCadastro;
    private Cliente cliente;
    private List pessoaEmpresaEnderecos;
    private List pessoaEmpresaContatos;
    private Usuario usuario;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public PessoaEmpresa() {
    }

    public PessoaEmpresa(Integer id) {
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

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List getPessoaEmpresaEnderecos() {
        return this.pessoaEmpresaEnderecos;
    }

    public void setPessoaEmpresaEnderecos(List pessoaEmpresaEnderecos) {
        this.pessoaEmpresaEnderecos = pessoaEmpresaEnderecos;
    }

    public List getPessoaEmpresaContatos() {
        return this.pessoaEmpresaContatos;
    }

    public void setPessoaEmpresaContatos(List pessoaEmpresaContatos) {
        this.pessoaEmpresaContatos = pessoaEmpresaContatos;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
