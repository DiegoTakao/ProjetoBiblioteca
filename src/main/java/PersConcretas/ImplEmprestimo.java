package PersConcretas;
import Entidades.Emprestimo;
import Persitencia.IEmprestimo;
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

public class ImplEmprestimo implements IEmprestimo {

    private final String filename = "Emprestimo.dat";
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    
    private void salvarArq(){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(filename));
            OOS.writeObject(emprestimos);
            OOS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArq(){
        try {
            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename));
            emprestimos = (List<Emprestimo>) OIS.readObject();
            OIS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void inserir(Emprestimo emprestimo) {
        lerArq();
        boolean F = false;
        for (Emprestimo L : emprestimos) {
            if (L.getID().equals(emprestimo.getID())){
                F = true;
                break;
            }
        }
        if(F){
            System.out.println("Empréstimo já cadastrado.");
        }else{
            emprestimos.add(emprestimo);
            salvarArq();
            System.out.println("Cadastro do empréstimo concluído.");
        }
    }

    @Override
    public boolean editar(Emprestimo emprestimo) {
        lerArq();
        
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo a = emprestimos.get(i);
            if (a.getID().equals(emprestimo.getID())) {
                emprestimos.set(i, emprestimo);
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
        
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo a = emprestimos.get(i);
            if (a.getID().equals(id)) {
                emprestimos.remove(i);
                salvarArq();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Emprestimo procuraID(String id) {
        lerArq();
        
        for (Emprestimo a : emprestimos) {
            if(a.getID().equals(id)){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Emprestimo> listar() {
        lerArq();
        return emprestimos;
    }
    
}
