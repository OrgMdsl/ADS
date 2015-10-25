package Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class AtributoOpcao implements java.io.Serializable {

    private Integer id;
    private Atributo atributo;
    private String opcao;
    private Date dataCadastro;
    private List objetoAtributoValors;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public AtributoOpcao() {
    }

    public AtributoOpcao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Atributo getAtributo() {
        return this.atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public String getOpcao() {
        return this.opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List getObjetoAtributoValors() {
        return this.objetoAtributoValors;
    }

    public void setObjetoAtributoValors(List objetoAtributoValors) {
        this.objetoAtributoValors = objetoAtributoValors;
    }

}
