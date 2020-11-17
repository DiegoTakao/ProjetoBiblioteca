package Persitencia;
import Entidades.Emprestimo;
import java.util.List;


public interface IEmprestimo {
    
    public void inserir(Emprestimo emprestimo);
    
    public boolean editar(Emprestimo emprestimo);
    
    public boolean remover(String id);
    
    public Emprestimo procuraID(String id);
    
    public List<Emprestimo> listar();
    
}