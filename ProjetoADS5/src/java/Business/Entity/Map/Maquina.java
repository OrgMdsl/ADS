package Business.Entity.Map;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Maquina implements java.io.Serializable {

    private Integer id;
    private GenericoItem genericoItemByIdCategoriaMaquina;
    private GenericoItem genericoItemByIdTipoMaquina;
    private GenericoItem genericoItemByIdAmbienteFuncionamento;
    private Maquina maquina;
    private String descricao;
    private String modelo;
    private Date dataUltimaRevisao;
    private Date dataCadastro;
    private List componenteMaquinas;
    private List contratoMaquinas;
    private List maquinas;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Maquina() {
    }

    public Maquina(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GenericoItem getGenericoItemByIdCategoriaMaquina() {
        return this.genericoItemByIdCategoriaMaquina;
    }

    public void setGenericoItemByIdCategoriaMaquina(GenericoItem genericoItemByIdCategoriaMaquina) {
        this.genericoItemByIdCategoriaMaquina = genericoItemByIdCategoriaMaquina;
    }

    public GenericoItem getGenericoItemByIdTipoMaquina() {
        return this.genericoItemByIdTipoMaquina;
    }

    public void setGenericoItemByIdTipoMaquina(GenericoItem genericoItemByIdTipoMaquina) {
        this.genericoItemByIdTipoMaquina = genericoItemByIdTipoMaquina;
    }

    public GenericoItem getGenericoItemByIdAmbienteFuncionamento() {
        return this.genericoItemByIdAmbienteFuncionamento;
    }

    public void setGenericoItemByIdAmbienteFuncionamento(GenericoItem genericoItemByIdAmbienteFuncionamento) {
        this.genericoItemByIdAmbienteFuncionamento = genericoItemByIdAmbienteFuncionamento;
    }

    public Maquina getMaquina() {
        return this.maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getDataUltimaRevisao() {
        return this.dataUltimaRevisao;
    }

    public void setDataUltimaRevisao(Date dataUltimaRevisao) {
        this.dataUltimaRevisao = dataUltimaRevisao;
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

    public List getContratoMaquinas() {
        return this.contratoMaquinas;
    }

    public void setContratoMaquinas(List contratoMaquinas) {
        this.contratoMaquinas = contratoMaquinas;
    }

    public List getMaquinas() {
        return this.maquinas;
    }

    public void setMaquinas(List maquinas) {
        this.maquinas = maquinas;
    }

}
