package Persitencia;
import Entidades.Livro;
import java.util.List;


public interface ILivro {
    
    public void inserir(Livro livro);
    
    public boolean editar(Livro livro);
    
    public boolean remover(String id);
    
    public Livro procuraID(String id);
    
    public List<Livro> listar();
    
}
