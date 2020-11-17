package PersConcretas;
import Entidades.Autor;
import Persitencia.IAutor;
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

public class ImplAutor implements IAutor {
    
    private final String filename = "Autor.dat";
    private List<Autor> autores = new ArrayList<Autor>();
    
    private void salvarArq(){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(filename));
            OOS.writeObject(autores);
            OOS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArq(){
        try {
            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename));
            autores = (List<Autor>) OIS.readObject();
            OIS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplAutor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void inserir(Autor autor) {
        
        if(autor.getID().equals("")){
            System.out.println("Insira o ID para realizar o cadastro.");
        }else{
            lerArq();
            boolean F = false;
            for (Autor L : autores) {
                if (L.getID().equals(autor.getID())){
                    F = true;
                    break;
                }
            }
            if(F){
                System.out.println("Autor já cadastrado.");
            }else{
                autores.add(autor);
                salvarArq();
                System.out.println("Cadastro do autor concluído.");
            }
        }
    }

    @Override
    public boolean editar(Autor autor) {
        lerArq();
        
        for (int i = 0; i < autores.size(); i++) {
            Autor a = autores.get(i);
            if (a.getID().equals(autor.getID())) {
                autores.set(i, autor);
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
        
        for (int i = 0; i < autores.size(); i++) {
            Autor a = autores.get(i);
            if (a.getID().equals(id)) {
                autores.remove(i);
                salvarArq();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Autor procuraID(String id) {
        lerArq();
        
        for (Autor a : autores) {
            if(a.getID().equals(id)){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Autor> listar() {
        lerArq();
        return autores;
    }
    
}
