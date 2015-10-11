/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Entity;

import java.util.Set;

/**
 *
 * @author matheusdsl
 */
public class Usuario {
    Integer id;
    UsuarioPerfil perfil;
    Pessoa pessoa;
    UsuarioSetor setor;
    CoreGenericoItem status;
    String senha;
    String usuario;
    CoreGenericoItem ativo;
    Set<UsuarioPersonalizacao> personalizacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(UsuarioPerfil perfil) {
        this.perfil = perfil;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public UsuarioSetor getSetor() {
        return setor;
    }

    public void setSetor(UsuarioSetor setor) {
        this.setor = setor;
    }

    public CoreGenericoItem getStatus() {
        return status;
    }

    public void setStatus(CoreGenericoItem status) {
        this.status = status;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public CoreGenericoItem getAtivo() {
        return ativo;
    }

    public void setAtivo(CoreGenericoItem ativo) {
        this.ativo = ativo;
    }

    public Set<UsuarioPersonalizacao> getPersonalizacoes() {
        return personalizacoes;
    }

    public void setPersonalizacoes(Set<UsuarioPersonalizacao> personalizacoes) {
        this.personalizacoes = personalizacoes;
    }
    
    
}
