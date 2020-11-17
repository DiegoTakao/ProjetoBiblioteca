package PersConcretas;
import Entidades.Cadastro;
import Persitencia.ICadastro;
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

public class ImplCadastro implements ICadastro {

    private final String filename = "Cadastro.dat";
    private List<Cadastro> cadastros = new ArrayList<Cadastro>();
    
    private void salvarArq(){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(filename));
            OOS.writeObject(cadastros);
            OOS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArq(){
        try {
            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename));
            cadastros = (List<Cadastro>) OIS.readObject();
            OIS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void inserir(Cadastro cadastro) {
        lerArq();
        boolean F = false;
        for (Cadastro L : cadastros) {
            if (L.getID().equals(cadastro.getID())){
                F = true;
                break;
            }
        }
        if(F){
            System.out.println("Cadastro já existente.");
        }else{
            cadastros.add(cadastro);
            salvarArq();
            System.out.println("Cadastro concluído.");
        }
    }

    @Override
    public boolean editar(Cadastro cadastro) {
        lerArq();
        
        for (int i = 0; i < cadastros.size(); i++) {
            Cadastro a = cadastros.get(i);
            if (a.getID().equals(cadastro.getID())) {
                cadastros.set(i, cadastro);
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
        
        for (int i = 0; i < cadastros.size(); i++) {
            Cadastro a = cadastros.get(i);
            if (a.getID().equals(id)) {
                cadastros.remove(i);
                salvarArq();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Cadastro procuraID(String id) {
        lerArq();
        
        for (Cadastro a : cadastros) {
            if(a.getID().equals(id)){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Cadastro> listar() {
        lerArq();
        return cadastros;
    }
    
}
