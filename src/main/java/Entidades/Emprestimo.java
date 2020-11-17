package Entidades;
import java.io.Serializable;
import java.util.Date;

public class Emprestimo implements Serializable{
    
    private String EmprestimoID;
    private Date Data;
    private Date Prazo;

    public String getID() {
        return EmprestimoID;
    }

    public Date getData() {
        return Data;
    }

    public Date getPrazo() {
        return Prazo;
    }

    public void setID(String EmprestimoID) {
        this.EmprestimoID = EmprestimoID;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public void setPrazo(Date Prazo) {
        this.Prazo = Prazo;
    }
    
}
