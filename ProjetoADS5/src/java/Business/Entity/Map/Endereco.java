package Business.Entity.Map;

import java.util.HashSet;
import java.util.Set;

public class Endereco  implements java.io.Serializable {


     private int idEndereco;
     private String cep;
     private String numero;
     private Set<EnderecoPessoa> enderecoPessoas = new HashSet<EnderecoPessoa>(0);

    public Endereco() {
    }

	
    public Endereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public Endereco(int idEndereco, String cep, String numero, Set<EnderecoPessoa> enderecoPessoas) {
       this.idEndereco = idEndereco;
       this.cep = cep;
       this.numero = numero;
       this.enderecoPessoas = enderecoPessoas;
    }
   
    public int getIdEndereco() {
        return this.idEndereco;
    }
    
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Set<EnderecoPessoa> getEnderecoPessoas() {
        return this.enderecoPessoas;
    }
    
    public void setEnderecoPessoas(Set<EnderecoPessoa> enderecoPessoas) {
        this.enderecoPessoas = enderecoPessoas;
    }




}


