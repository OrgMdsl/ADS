package Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Objeto implements java.io.Serializable {

    private Integer id;
    private GenericoItem tipoObjeto;
    private String descricao;
    private Date dataCadastro;
    private List objetoAtributos;
    private List componenteMaquinas;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Objeto() {
    }

    public Objeto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GenericoItem getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(GenericoItem tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
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

    public List getObjetoAtributos() {
        return this.objetoAtributos;
    }

    public void setObjetoAtributos(List objetoAtributos) {
        this.objetoAtributos = objetoAtributos;
    }

    public List getComponenteMaquinas() {
        return this.componenteMaquinas;
    }

    public void setComponenteMaquinas(List componenteMaquinas) {
        this.componenteMaquinas = componenteMaquinas;
    }

}
