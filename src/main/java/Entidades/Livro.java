package Entidades;
import java.io.Serializable;

public class Livro implements Serializable{
    
    private String LivroID;
    private String ISBN;
    private String Titulo;
    private int Ano;

    public String getID() {
        return LivroID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public int getAno() {
        return Ano;
    }

    public void setID(String LivroID) {
        this.LivroID = LivroID;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }
    
}
