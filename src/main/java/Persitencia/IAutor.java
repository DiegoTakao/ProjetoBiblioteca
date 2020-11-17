package Persitencia;
import Entidades.Autor;
import java.util.List;


public interface IAutor {
    
    public void inserir(Autor autor);
    
    public boolean editar(Autor autor);
    
    public boolean remover(String id);
    
    public Autor procuraID(String id);
    
    public List<Autor> listar();
    
}