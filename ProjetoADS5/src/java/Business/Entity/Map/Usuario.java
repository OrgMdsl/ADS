package Business.Entity.Map;

import java.util.HashSet;
import java.util.Set;

public class Usuario  implements java.io.Serializable {


     private int idUsuario;
     private CoreGenericoItem coreGenericoItemByIdStatus;
     private CoreGenericoItem coreGenericoItemByAtivo;
     private Pessoa pessoa;
     private UsuarioPerfil usuarioPerfil;
     private UsuarioSetor usuarioSetor;
     private String senha;
     private String usuario;
     private Set<UsuarioPersonalizacao> usuarioPersonalizacaos = new HashSet<UsuarioPersonalizacao>(0);
     private Set<ChamadoHistorico> chamadoHistoricosForIdUsuarioSolicitante = new HashSet<ChamadoHistorico>(0);
     private Set<ChamadoHistorico> chamadoHistoricosForIdUsuarioAtendente = new HashSet<ChamadoHistorico>(0);

    public Usuario() {
    }

	
    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Usuario(int idUsuario, CoreGenericoItem coreGenericoItemByIdStatus, CoreGenericoItem coreGenericoItemByAtivo, Pessoa pessoa, UsuarioPerfil usuarioPerfil, UsuarioSetor usuarioSetor, String senha, String usuario, Set<UsuarioPersonalizacao> usuarioPersonalizacaos, Set<ChamadoHistorico> chamadoHistoricosForIdUsuarioSolicitante, Set<ChamadoHistorico> chamadoHistoricosForIdUsuarioAtendente) {
       this.idUsuario = idUsuario;
       this.coreGenericoItemByIdStatus = coreGenericoItemByIdStatus;
       this.coreGenericoItemByAtivo = coreGenericoItemByAtivo;
       this.pessoa = pessoa;
       this.usuarioPerfil = usuarioPerfil;
       this.usuarioSetor = usuarioSetor;
       this.senha = senha;
       this.usuario = usuario;
       this.usuarioPersonalizacaos = usuarioPersonalizacaos;
       this.chamadoHistoricosForIdUsuarioSolicitante = chamadoHistoricosForIdUsuarioSolicitante;
       this.chamadoHistoricosForIdUsuarioAtendente = chamadoHistoricosForIdUsuarioAtendente;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public CoreGenericoItem getCoreGenericoItemByIdStatus() {
        return this.coreGenericoItemByIdStatus;
    }
    
    public void setCoreGenericoItemByIdStatus(CoreGenericoItem coreGenericoItemByIdStatus) {
        this.coreGenericoItemByIdStatus = coreGenericoItemByIdStatus;
    }
    public CoreGenericoItem getCoreGenericoItemByAtivo() {
        return this.coreGenericoItemByAtivo;
    }
    
    public void setCoreGenericoItemByAtivo(CoreGenericoItem coreGenericoItemByAtivo) {
        this.coreGenericoItemByAtivo = coreGenericoItemByAtivo;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public UsuarioPerfil getUsuarioPerfil() {
        return this.usuarioPerfil;
    }
    
    public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }
    public UsuarioSetor getUsuarioSetor() {
        return this.usuarioSetor;
    }
    
    public void setUsuarioSetor(UsuarioSetor usuarioSetor) {
        this.usuarioSetor = usuarioSetor;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Set<UsuarioPersonalizacao> getUsuarioPersonalizacaos() {
        return this.usuarioPersonalizacaos;
    }
    
    public void setUsuarioPersonalizacaos(Set<UsuarioPersonalizacao> usuarioPersonalizacaos) {
        this.usuarioPersonalizacaos = usuarioPersonalizacaos;
    }
    public Set<ChamadoHistorico> getChamadoHistoricosForIdUsuarioSolicitante() {
        return this.chamadoHistoricosForIdUsuarioSolicitante;
    }
    
    public void setChamadoHistoricosForIdUsuarioSolicitante(Set<ChamadoHistorico> chamadoHistoricosForIdUsuarioSolicitante) {
        this.chamadoHistoricosForIdUsuarioSolicitante = chamadoHistoricosForIdUsuarioSolicitante;
    }
    public Set<ChamadoHistorico> getChamadoHistoricosForIdUsuarioAtendente() {
        return this.chamadoHistoricosForIdUsuarioAtendente;
    }
    
    public void setChamadoHistoricosForIdUsuarioAtendente(Set<ChamadoHistorico> chamadoHistoricosForIdUsuarioAtendente) {
        this.chamadoHistoricosForIdUsuarioAtendente = chamadoHistoricosForIdUsuarioAtendente;
    }




}


