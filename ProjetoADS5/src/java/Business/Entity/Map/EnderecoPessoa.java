package Business.Entity.Map;

public class EnderecoPessoa  implements java.io.Serializable {


     private int idEnderecoPessoa;
     private Endereco endereco;
     private Pessoa pessoa;

    public EnderecoPessoa() {
    }

	
    public EnderecoPessoa(int idEnderecoPessoa) {
        this.idEnderecoPessoa = idEnderecoPessoa;
    }
    public EnderecoPessoa(int idEnderecoPessoa, Endereco endereco, Pessoa pessoa) {
       this.idEnderecoPessoa = idEnderecoPessoa;
       this.endereco = endereco;
       this.pessoa = pessoa;
    }
   
    public int getIdEnderecoPessoa() {
        return this.idEnderecoPessoa;
    }
    
    public void setIdEnderecoPessoa(int idEnderecoPessoa) {
        this.idEnderecoPessoa = idEnderecoPessoa;
    }
    public Endereco getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }




}


