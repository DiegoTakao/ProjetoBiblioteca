package PersConcretas;
import Entidades.Funcionario;
import Persitencia.IFuncionario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplFuncionario implements IFuncionario {

    private final String filename = "Funcionario.dat";
    private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    private void salvarArq(){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(filename));
            OOS.writeObject(funcionarios);
            OOS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArq(){
        try {
            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename));
            funcionarios = (List<Funcionario>) OIS.readObject();
            OIS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void inserir(Funcionario funcionario) {
        lerArq();
        boolean F = false;
        for (Funcionario L : funcionarios) {
            if (L.getID().equals(funcionario.getID())){
                F = true;
                break;
            }
        }
        if(F){
            System.out.println("Funcionario já cadastrado.");
        }else{
            funcionarios.add(funcionario);
            salvarArq();
            System.out.println("Cadastro do funcionário concluído.");
        }
    }

    @Override
    public boolean editar(Funcionario funcionario) {
        lerArq();
        
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario a = funcionarios.get(i);
            if (a.getID().equals(funcionario.getID())) {
                funcionarios.set(i, funcionario);
                salvarArq();
                return true;
            }
        }
        
        System.out.println("ID não encontrado.");
        return false;
    }

    @Override
    public boolean remover(String id) {
        lerArq();
        
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario a = funcionarios.get(i);
            if (a.getID().equals(id)) {
                funcionarios.remove(i);
                salvarArq();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Funcionario procuraID(String id) {
        lerArq();
        
        for (Funcionario a : funcionarios) {
            if(a.getID().equals(id)){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Funcionario> listar() {
        lerArq();
        return funcionarios;
    }
    
}
