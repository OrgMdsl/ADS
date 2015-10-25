package Business.Entity.Map;

import java.util.Date;

public class ObjetoAtributoValor implements java.io.Serializable {

    private Integer id;
    private AtributoOpcao atributoOpcao;
    private ObjetoAtributo objetoAtributo;
    private Date dataCadastro;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public ObjetoAtributoValor() {
    }

    public ObjetoAtributoValor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AtributoOpcao getAtributoOpcao() {
        return this.atributoOpcao;
    }

    public void setAtributoOpcao(AtributoOpcao atributoOpcao) {
        this.atributoOpcao = atributoOpcao;
    }

    public ObjetoAtributo getObjetoAtributo() {
        return this.objetoAtributo;
    }

    public void setObjetoAtributo(ObjetoAtributo objetoAtributo) {
        this.objetoAtributo = objetoAtributo;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
