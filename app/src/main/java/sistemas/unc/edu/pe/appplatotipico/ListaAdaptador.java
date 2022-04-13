package sistemas.unc.edu.pe.appplatotipico;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import AccesoDatos.DAOPlatos;
import Modelo.Plato;

public class ListaAdaptador extends BaseAdapter {
    /*Se crea una clase de tipo ListaAdaptador porque
  en la lista se almacenan objetos y no solo cadenas*/
    Context contexto;
    DAOPlatos datos;
    //String[][] datos;
    //int[] imagenes;
    private static LayoutInflater inflater = null;
    /*LayoutInflater es para relacionar con lo que se va a cargar en tiempo de ejecución*/

    public ListaAdaptador(Context contexto, DAOPlatos datos) {
        this.contexto = contexto;
        this.datos = datos;
        //this.imagenes = imagenes;
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.getContar();
        /*Colocar el número de registros que tenemos
          Depende de getCount() va a recorrer el método getView()*/
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        /*Este es el elemento principal, carga cada uno de los elementos
        Aquí se va a cargar el LayoutInflater*/
        View vista = inflater.inflate(R.layout.ly_elemento_plato, null);
        TextView tvTitulo = vista.findViewById(R.id.tvTituloPlato);
        TextView tvOrigen = vista.findViewById(R.id.tvOrigenPlato);
        TextView tvPrecio = vista.findViewById(R.id.tvPrecio);
        ImageView imgPlato = vista.findViewById(R.id.imgPlato);
        RatingBar rbPreferencia = vista.findViewById(R.id.rbPreferencia);

        //Asignar los valores a los objetos de tipo view
        Plato oPlato = datos.getPlato(i);
        tvTitulo.setText(oPlato.getNombre());
        tvOrigen.setText(oPlato.getOrigen());
        tvPrecio.setText("S/." + oPlato.getPrecio());
        //imgPlato.setImageURI(oPlato.getImagen());
        imgPlato.setImageBitmap(oPlato.getImagen());
        rbPreferencia.setProgress(oPlato.getPreferencia());
        return vista;
    }

}
