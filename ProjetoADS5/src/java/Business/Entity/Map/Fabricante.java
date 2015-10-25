package Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Fabricante implements java.io.Serializable {

    private Integer id;
    private String descricao;
    private Date dataCadastro;
    private List<ComponenteMaquina> componenteMaquinas;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Fabricante() {
    }

    public Fabricante(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List getComponenteMaquinas() {
        return this.componenteMaquinas;
    }

    public void setComponenteMaquinas(List componenteMaquinas) {
        this.componenteMaquinas = componenteMaquinas;
    }

}
