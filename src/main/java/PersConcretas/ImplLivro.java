package PersConcretas;

import Entidades.Livro;
import Persitencia.ILivro;
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

public class ImplLivro implements ILivro {

    private final String filename = "Livro.dat";
    private List<Livro> livros = new ArrayList<Livro>();
    
    private void salvarArq(){
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(filename));
            OOS.writeObject(livros);
            OOS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplLivro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArq(){
        try {
            ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(filename));
            livros = (List<Livro>) OIS.readObject();
            OIS.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImplLivro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImplLivro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ImplLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void inserir(Livro livro) {
        lerArq();
        boolean F = false;
        for (Livro L : livros) {
            if (L.getID().equals(livro.getID())){
                F = true;
                break;
            }
        }
        if(F){
            System.out.println("Livro já cadastrado.");
        }else{
            livros.add(livro);
            salvarArq();
            System.out.println("Cadastro do livro concluído.");
        }
    }

    @Override
    public boolean editar(Livro livro) {
        lerArq();
        
        for (int i = 0; i < livros.size(); i++) {
            Livro a = livros.get(i);
            if (a.getID().equals(livro.getID())) {
                livros.set(i, livro);
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
        
        for (int i = 0; i < livros.size(); i++) {
            Livro a = livros.get(i);
            if (a.getID().equals(id)) {
                livros.remove(i);
                salvarArq();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Livro procuraID(String id) {
        lerArq();
        
        for (Livro a : livros) {
            if(a.getID().equals(id)){
                return a;
            }
        }
        
        return null;
    }

    @Override
    public List<Livro> listar() {
        lerArq();
        return livros;
    }
    
}
