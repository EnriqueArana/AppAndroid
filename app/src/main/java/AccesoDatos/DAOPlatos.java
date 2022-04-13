package AccesoDatos;

import java.io.Serializable;
import java.util.ArrayList;

import Modelo.Plato;

public class DAOPlatos implements Serializable {
    ArrayList<Plato> oPlatos;

    public DAOPlatos() {
        this.oPlatos = new ArrayList<>();
    }
    public void agregar(Plato oP){
        oPlatos.add(oP);
    }
    public int getContar(){
        return oPlatos.size();
    }
    public Plato getPlato(int i){
        return oPlatos.get(i);
    }
    public ArrayList<String> listar(){
        ArrayList<String> tempo = new ArrayList<>();
        for (Plato op : oPlatos){
            tempo.add(op.mostrarObjeto());
        }
        return tempo;
    }
}
