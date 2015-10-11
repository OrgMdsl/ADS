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
public class UsuarioPerfil {
    Integer id;
    String descricao;
    CoreGenericoItem nivelAcesso;
    Set<Usuario> usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CoreGenericoItem getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(CoreGenericoItem nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
