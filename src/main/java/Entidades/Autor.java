package Entidades;
import java.io.Serializable;

public class Autor implements Serializable{
    
    private String AutorID;
    private String Nome;
    private String Nacionalidade;

    public String getNome() {
        return Nome;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setNacionalidade(String Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
    }

    public String getID() {
        return AutorID;
    }

    public void setID(String AutorID) {
        this.AutorID = AutorID;
    }
    
}
