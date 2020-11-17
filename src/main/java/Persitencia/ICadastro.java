package Persitencia;
import Entidades.Cadastro;
import java.util.List;


public interface ICadastro {
    
    public void inserir(Cadastro cadastro);
    
    public boolean editar(Cadastro cadastro);
    
    public boolean remover(String id);
    
    public Cadastro procuraID(String id);
    
    public List<Cadastro> listar();
    
}