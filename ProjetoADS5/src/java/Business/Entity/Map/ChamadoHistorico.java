package Business.Entity.Map;



import java.util.Date;

public class ChamadoHistorico  implements java.io.Serializable {


     private int idChamadoHistorico;
     private Chamado chamado;
     private ChamadoTipoChamado chamadoTipoChamado;
     private CoreArquivo coreArquivo;
     private CoreGenericoItem coreGenericoItemByIdChamadoStatus;
     private CoreGenericoItem coreGenericoItemByIdChamadoNivel;
     private CoreGenericoItem coreGenericoItemByIdChamadoPrioridade;
     private Usuario usuarioByIdUsuarioSolicitante;
     private Usuario usuarioByIdUsuarioAtendente;
     private Date data;

    public ChamadoHistorico() {
    }

	
    public ChamadoHistorico(int idChamadoHistorico) {
        this.idChamadoHistorico = idChamadoHistorico;
    }
    public ChamadoHistorico(int idChamadoHistorico, Chamado chamado, ChamadoTipoChamado chamadoTipoChamado, CoreArquivo coreArquivo, CoreGenericoItem coreGenericoItemByIdChamadoStatus, CoreGenericoItem coreGenericoItemByIdChamadoNivel, CoreGenericoItem coreGenericoItemByIdChamadoPrioridade, Usuario usuarioByIdUsuarioSolicitante, Usuario usuarioByIdUsuarioAtendente, Date data) {
       this.idChamadoHistorico = idChamadoHistorico;
       this.chamado = chamado;
       this.chamadoTipoChamado = chamadoTipoChamado;
       this.coreArquivo = coreArquivo;
       this.coreGenericoItemByIdChamadoStatus = coreGenericoItemByIdChamadoStatus;
       this.coreGenericoItemByIdChamadoNivel = coreGenericoItemByIdChamadoNivel;
       this.coreGenericoItemByIdChamadoPrioridade = coreGenericoItemByIdChamadoPrioridade;
       this.usuarioByIdUsuarioSolicitante = usuarioByIdUsuarioSolicitante;
       this.usuarioByIdUsuarioAtendente = usuarioByIdUsuarioAtendente;
       this.data = data;
    }
   
    public int getIdChamadoHistorico() {
        return this.idChamadoHistorico;
    }
    
    public void setIdChamadoHistorico(int idChamadoHistorico) {
        this.idChamadoHistorico = idChamadoHistorico;
    }
    public Chamado getChamado() {
        return this.chamado;
    }
    
    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    public ChamadoTipoChamado getChamadoTipoChamado() {
        return this.chamadoTipoChamado;
    }
    
    public void setChamadoTipoChamado(ChamadoTipoChamado chamadoTipoChamado) {
        this.chamadoTipoChamado = chamadoTipoChamado;
    }
    public CoreArquivo getCoreArquivo() {
        return this.coreArquivo;
    }
    
    public void setCoreArquivo(CoreArquivo coreArquivo) {
        this.coreArquivo = coreArquivo;
    }
    public CoreGenericoItem getCoreGenericoItemByIdChamadoStatus() {
        return this.coreGenericoItemByIdChamadoStatus;
    }
    
    public void setCoreGenericoItemByIdChamadoStatus(CoreGenericoItem coreGenericoItemByIdChamadoStatus) {
        this.coreGenericoItemByIdChamadoStatus = coreGenericoItemByIdChamadoStatus;
    }
    public CoreGenericoItem getCoreGenericoItemByIdChamadoNivel() {
        return this.coreGenericoItemByIdChamadoNivel;
    }
    
    public void setCoreGenericoItemByIdChamadoNivel(CoreGenericoItem coreGenericoItemByIdChamadoNivel) {
        this.coreGenericoItemByIdChamadoNivel = coreGenericoItemByIdChamadoNivel;
    }
    public CoreGenericoItem getCoreGenericoItemByIdChamadoPrioridade() {
        return this.coreGenericoItemByIdChamadoPrioridade;
    }
    
    public void setCoreGenericoItemByIdChamadoPrioridade(CoreGenericoItem coreGenericoItemByIdChamadoPrioridade) {
        this.coreGenericoItemByIdChamadoPrioridade = coreGenericoItemByIdChamadoPrioridade;
    }
    public Usuario getUsuarioByIdUsuarioSolicitante() {
        return this.usuarioByIdUsuarioSolicitante;
    }
    
    public void setUsuarioByIdUsuarioSolicitante(Usuario usuarioByIdUsuarioSolicitante) {
        this.usuarioByIdUsuarioSolicitante = usuarioByIdUsuarioSolicitante;
    }
    public Usuario getUsuarioByIdUsuarioAtendente() {
        return this.usuarioByIdUsuarioAtendente;
    }
    
    public void setUsuarioByIdUsuarioAtendente(Usuario usuarioByIdUsuarioAtendente) {
        this.usuarioByIdUsuarioAtendente = usuarioByIdUsuarioAtendente;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }




}


