package PersConcretas;
import Entidades.Editora;
import Persitencia.IEditora;
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

public class ImplEditora implements IEditora {

    private final String filename = "Editora.dat";
    private List<Editora> editoras = new ArrayList<Editora>();
    
    private void salvarArq(){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(filename));
            OOS.writeObject(editoras);
            OOS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplEditora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplEditora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArq(){
        try {
            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename));
            editoras = (List<Editora>) OIS.readObject();
            OIS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplEditora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplEditora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplEditora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void inserir(Editora editora) {
        lerArq();
        boolean F = false;
        for (Editora L : editoras) {
            if (L.getID().equals(editora.getID())){
                F = true;
                break;
            }
        }
        if(F){
            System.out.println("Editora já cadastrada.");
        }else{
            editoras.add(editora);
            salvarArq();
            System.out.println("Cadastro de editora concluído.");
        }
    }

    @Override
    public boolean editar(Editora editora) {
        lerArq();
        
        for (int i = 0; i < editoras.size(); i++) {
            Editora a = editoras.get(i);
            if (a.getID().equals(editora.getID())) {
                editoras.set(i, editora);
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
        
        for (int i = 0; i < editoras.size(); i++) {
            Editora a = editoras.get(i);
            if (a.getID().equals(id)) {
                editoras.remove(i);
                salvarArq();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Editora procuraID(String id) {
        lerArq();
        
        for (Editora a : editoras) {
            if(a.getID().equals(id)){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Editora> listar() {
        lerArq();
        return editoras;
    }
    
}
