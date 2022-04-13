package sistemas.unc.edu.pe.appplatotipico;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;

import Modelo.Plato;

import AccesoDatos.DAOPlatos;

public class MainActivity extends AppCompatActivity {
    /*String[][] datos = {{"Frito Cajamarquino","Cajamarca","4","S/.40","El frito cajamarquino es una de las comidas más tradicionales y emblemáticas que se disfrutan popularmente durante la época de carnavales. Este plato consiste en trozos fritos de menudencia de cerdo apanada con azafrán, acompañadas de papa cocida y deshecha, de una textura similar a la de un puré. A esta mezcla se le puede añadir, como es común, una porción jugosa y picante de ceviche de pescado. Sin duda, una exquisitez."},
            {"Puchero o sancochado","Bambamarca","3","S/.25","Al igual que el frito, el puchero cajamarquino es un plato típico que se prepara con frecuencia durante el carnaval. También conocido como sancochado, este caldo se prepara con papa, repollo y tres tipos de carne: cerdo, res y carnero; y se acompaña con camote o yuca. Si eres amante del picante, no te preocupes, este plato también se sirve con ají de huacatay. De veras, imperdible."},
            {"Cuy frito con picante de papa","Chota","5","S/.55","Si bien el cuy frito se prepara en distintas regiones del país, el que se cocina en Cajamarca ofrece un sabor especial. La crocante y generosa presa se sirve con un guiso de papa aderezado con ají panca, maní, pimienta y sal. Lo que no puede faltar es la salsa criolla de cebolla y rocoto. Además de rico, nutritivo."}}; //Almacenar tres registros {}
    int[] imagenes={R.drawable.fritocaja,R.drawable.puchero,R.drawable.cuyfrito};*/
    public static DAOPlatos datos;
    ListView lvListaPlatos;
    public static DAOPlatos datosListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = new DAOPlatos();
        datosListar = new DAOPlatos();
        lvListaPlatos = findViewById(R.id.lvListaPlatos);
        lvListaPlatos.setAdapter(new ListaAdaptador(this, datos));
        lvListaPlatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent oIntento = new Intent(adapterView.getContext(),ActividadDetallePlato.class);
                oIntento.putExtra("vTitulo",datos.getPlato(i).getNombre());
                oIntento.putExtra("vDescripcion",datos.getPlato(i).getDescripcion());
                startActivity(oIntento);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        lvListaPlatos.setAdapter(new ListaAdaptador(this, datos));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent oIntento;
        switch (item.getItemId()){
            case R.id.itemAgregar:
                oIntento = new Intent(this, ActividadAgregar.class);
                startActivity(oIntento);
                break;
            case R.id.itemListar:
                oIntento = new Intent(this, ActividadListar.class);

                oIntento.putExtra("vLista", datosListar);
                startActivity(oIntento);
                break;
            case R.id.itemModificar:
            case R.id.itemSalir:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}