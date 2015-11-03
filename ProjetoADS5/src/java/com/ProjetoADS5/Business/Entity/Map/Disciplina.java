/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetoADS5.Business.Entity.Map;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author matheusdsl
 */
@Entity
public class Disciplina implements Serializable {

    @Id
    @Column(name = "id_disciplina")
    Integer id;
    
    @Column
    String nome;
    
    @ManyToMany(mappedBy = "disciplinas")
    private List<Professor> professores;
    
    @ManyToMany
    List<Generico> conteudos;
    
    @ManyToMany(mappedBy = "disciplinas")
    private List<Curso> cursos;

    public Disciplina() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<Generico> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Generico> conteudos) {
        this.conteudos = conteudos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    

}
