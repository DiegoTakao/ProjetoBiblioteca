package Entidades;
import java.io.Serializable;

public class Cadastro implements Serializable{
    
    private String CadastroID;
    private String Nome;
    private String CPF;
    private String Telefone;

    public String getNome() {
        return Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getID() {
        return CadastroID;
    }

    public void setID(String CadastroID) {
        this.CadastroID = CadastroID;
    }
    
}
