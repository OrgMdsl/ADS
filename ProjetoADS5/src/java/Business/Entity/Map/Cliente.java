package Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Cliente implements java.io.Serializable {

    private Integer id;
    private GenericoItem genericoItem;
    private PessoaEmpresa pessoaEmpresa;
    private Date dataCadastro;
    private List<Contrato> contratos;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente() {
    }

    public Cliente(PessoaEmpresa pessoaEmpresa) {
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

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List getContratos() {
        return this.contratos;
    }

    public void setContratos(List contratos) {
        this.contratos = contratos;
    }

}
