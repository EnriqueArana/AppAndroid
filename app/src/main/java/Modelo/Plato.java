package Modelo;

import android.net.Uri;

import java.io.Serializable;

public class Plato implements Serializable {
    String nombre;
    String origen;
    String descripcion;
    double precio;
    int preferencia;
    Uri imagen;

    public Plato(String nombre, String origen, String descripcion, double precio, int preferencia, Uri imagen) {
        this.nombre = nombre;
        this.origen = origen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.preferencia = preferencia;
        this.imagen = imagen;
    }

    public Plato(String nombre, String origen, double precio) {
        this.nombre = nombre;
        this.origen = origen;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getPreferencia() {
        return preferencia;
    }

    public Uri getImagen() {
        return imagen;
    }
    public String mostrarObjeto(){
        return "Plato: "+nombre+", Origen: "+origen+" ,precio"+precio;
    }
}
