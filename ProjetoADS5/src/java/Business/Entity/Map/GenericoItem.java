package Business.Entity.Map;

import java.util.Date;

public class GenericoItem implements java.io.Serializable {

    private Integer id;
    private transient Generico generico;
    private String descricao;
    private String sigla;
    private Date dataCadastro;
    /*private List clientes;
    private List maquinasForIdCategoriaMaquina;
    private List objetos;
    private List maquinasForIdTipoMaquina;
    private List componenteMaquinas;
    private List maquinasForIdAmbienteFuncionamento;
    private List usuarios;
    private List atributos;*/
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public GenericoItem() {
    }

    public GenericoItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Generico getGenerico() {
        return this.generico;
    }

    public void setGenerico(Generico generico) {
        this.generico = generico;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    /*
    public List getClientes() {
        return this.clientes;
    }

    public void setClientes(List clientes) {
        this.clientes = clientes;
    }

    public List getMaquinasForIdCategoriaMaquina() {
        return this.maquinasForIdCategoriaMaquina;
    }

    public void setMaquinasForIdCategoriaMaquina(List maquinasForIdCategoriaMaquina) {
        this.maquinasForIdCategoriaMaquina = maquinasForIdCategoriaMaquina;
    }

    public List getObjetos() {
        return this.objetos;
    }

    public void setObjetos(List objetos) {
        this.objetos = objetos;
    }

    public List getMaquinasForIdTipoMaquina() {
        return this.maquinasForIdTipoMaquina;
    }

    public void setMaquinasForIdTipoMaquina(List maquinasForIdTipoMaquina) {
        this.maquinasForIdTipoMaquina = maquinasForIdTipoMaquina;
    }

    public List getComponenteMaquinas() {
        return this.componenteMaquinas;
    }

    public void setComponenteMaquinas(List componenteMaquinas) {
        this.componenteMaquinas = componenteMaquinas;
    }

    public List getMaquinasForIdAmbienteFuncionamento() {
        return this.maquinasForIdAmbienteFuncionamento;
    }

    public void setMaquinasForIdAmbienteFuncionamento(List maquinasForIdAmbienteFuncionamento) {
        this.maquinasForIdAmbienteFuncionamento = maquinasForIdAmbienteFuncionamento;
    }

    public List getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }

    public List getAtributos() {
        return this.atributos;
    }

    public void setAtributos(List atributos) {
        this.atributos = atributos;
    }
    */
}
