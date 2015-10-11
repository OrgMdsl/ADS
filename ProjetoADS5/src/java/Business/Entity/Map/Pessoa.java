package Business.Entity.Map;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Pessoa  implements java.io.Serializable {


     private int idPessoa;
     private String nome;
     private Date dataNascimento;
     private String cpf;
     private String email;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);
     private Set<EnderecoPessoa> enderecoPessoas = new HashSet<EnderecoPessoa>(0);

    public Pessoa() {
    }

	
    public Pessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    public Pessoa(int idPessoa, String nome, Date dataNascimento, String cpf, String email, Set<Usuario> usuarios, Set<EnderecoPessoa> enderecoPessoas) {
       this.idPessoa = idPessoa;
       this.nome = nome;
       this.dataNascimento = dataNascimento;
       this.cpf = cpf;
       this.email = email;
       this.usuarios = usuarios;
       this.enderecoPessoas = enderecoPessoas;
    }
   
    public int getIdPessoa() {
        return this.idPessoa;
    }
    
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDataNascimento() {
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public Set<EnderecoPessoa> getEnderecoPessoas() {
        return this.enderecoPessoas;
    }
    
    public void setEnderecoPessoas(Set<EnderecoPessoa> enderecoPessoas) {
        this.enderecoPessoas = enderecoPessoas;
    }




}


