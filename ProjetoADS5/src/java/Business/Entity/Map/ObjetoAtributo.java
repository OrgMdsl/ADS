package Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class ObjetoAtributo implements java.io.Serializable {

    private Integer id;
    private Atributo atributo;
    private Objeto objeto;
    private String valor;
    private Date dataCadastro;
    private List objetoAtributoValors;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ObjetoAtributo() {
    }

    public ObjetoAtributo(Integer id) {
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

    public Objeto getObjeto() {
        return this.objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public String getValor() {
        return this.valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
