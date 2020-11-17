package Entidades;
import java.io.Serializable;
import java.util.Date;

public class Funcionario implements Serializable{
    
    private String FuncionarioID;
    private String Nome;
    private String CPF;
    private String Telefone;
    private Date Admissao;

    public String getID() {
        return FuncionarioID;
    }

    public String getNome() {
        return Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTelefone() {
        return Telefone;
    }

    public Date getAdmissao() {
        return Admissao;
    }

    public void setID(String FuncionarioID) {
        this.FuncionarioID = FuncionarioID;
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

    public void setAdmissao(Date Admissao) {
        this.Admissao = Admissao;
    }
    
}
