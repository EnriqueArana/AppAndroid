package AccesoDatos;

import android.net.Uri;

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
    public void modificarPlato(int i, String nombreN, String origen, double precio, String descripcion, int estrellas, Uri imagen){
        oPlatos.get(i).setNombre(nombreN);
        oPlatos.get(i).setOrigen(origen);
        oPlatos.get(i).setPrecio(precio);
        oPlatos.get(i).setDescripcion(descripcion);
        oPlatos.get(i).setPreferencia(estrellas);
        oPlatos.get(i).setImagen(imagen);
    }
}
