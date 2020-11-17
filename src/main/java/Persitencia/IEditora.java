package Persitencia;
import Entidades.Editora;
import java.util.List;


public interface IEditora {
    
    public void inserir(Editora editora);
    
    public boolean editar(Editora editora);
    
    public boolean remover(String id);
    
    public Editora procuraID(String id);
    
    public List<Editora> listar();
    
}