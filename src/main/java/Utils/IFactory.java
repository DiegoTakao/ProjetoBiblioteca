package Utils;

import PersConcretas.ImplAutor;
import PersConcretas.ImplCadastro;
import PersConcretas.ImplEditora;
import PersConcretas.ImplEmprestimo;
import PersConcretas.ImplFuncionario;
import PersConcretas.ImplLivro;
import Persitencia.IAutor;
import Persitencia.ICadastro;
import Persitencia.IEditora;
import Persitencia.IEmprestimo;
import Persitencia.IFuncionario;
import Persitencia.ILivro;

public class IFactory {
    
    public static IAutor createIAutor(){
        return new ImplAutor();
    }
    
    public static ICadastro createICadastro(){
        return new ImplCadastro();
    }
    
    public static IEditora createIEditora(){
        return new ImplEditora();
    }
    
    public static IEmprestimo createIEmprestimo(){
        return new ImplEmprestimo();
    }
    
    public static IFuncionario createIFuncionario(){
        return new ImplFuncionario();
    }
    
    public static ILivro createILivro(){
        return new ImplLivro();
    }
}
