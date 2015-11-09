/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business.Entity.Map;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author matheusdsl
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Professor extends Usuario implements Serializable {

    @Column(unique = true)
    private String rm;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Disciplina> disciplinas;

    public Professor() {
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
