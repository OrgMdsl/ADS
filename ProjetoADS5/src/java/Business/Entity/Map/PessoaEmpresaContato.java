package Business.Entity.Map;

import java.util.Date;

public class PessoaEmpresaContato implements java.io.Serializable {

    private Integer id;
    private Contato contato;
    private PessoaEmpresa pessoaEmpresa;
    private Date dataCadastro;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public PessoaEmpresaContato() {
    }

    public PessoaEmpresaContato(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contato getContato() {
        return this.contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public PessoaEmpresa getPessoaEmpresa() {
        return this.pessoaEmpresa;
    }

    public void setPessoaEmpresa(PessoaEmpresa pessoaEmpresa) {
        this.pessoaEmpresa = pessoaEmpresa;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
