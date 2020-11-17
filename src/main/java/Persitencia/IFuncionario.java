package Persitencia;
import Entidades.Funcionario;
import java.util.List;

public interface IFuncionario {
    
    public void inserir(Funcionario funcionario);
    
    public boolean editar(Funcionario funcionario);
    
    public boolean remover(String id);
    
    public Funcionario procuraID(String id);
    
    public List<Funcionario> listar();
    
}
