package Entidades;
import java.io.Serializable;

public class Editora implements Serializable{
    
    private String EditoraID;
    private String Nome;

    public String getID() {
        return EditoraID;
    }

    public String getNome() {
        return Nome;
    }

    public void setID(String EditoraID) {
        this.EditoraID = EditoraID;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
}
