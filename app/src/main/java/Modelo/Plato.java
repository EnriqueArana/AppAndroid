package Modelo;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.Serializable;

public class Plato implements Serializable {
    String nombre;
    String origen;
    String descripcion;
    double precio;
    int preferencia;
    // Uri imagen;
    Bitmap imagen;

    public Plato(String nombre, String origen, String descripcion, double precio, int preferencia, Bitmap imagen) {
        this.nombre = nombre;
        this.origen = origen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.preferencia = preferencia;
        this.imagen = imagen;
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

    public Bitmap getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPreferencia(int preferencia) {
        this.preferencia = preferencia;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
    }

    public String mostrarObjeto() {
        return "Plato: " + nombre + " Origen: " + origen + ", precio:" + precio;
    }
}
