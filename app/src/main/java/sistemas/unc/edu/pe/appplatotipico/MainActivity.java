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

    public static DAOPlatos datos;
    ListView lvListaPlatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new DAOPlatos();

        lvListaPlatos = findViewById(R.id.lvListaPlatos);
        lvListaPlatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent oIntento = new Intent(adapterView.getContext(), ActividadDetallePlato.class);
                oIntento.putExtra("vTitulo", datos.getPlato(i).getNombre());
                oIntento.putExtra("vDescripcion", datos.getPlato(i).getNombre());
                startActivity(oIntento);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
        switch (item.getItemId()) {
            case R.id.itemAgregar:
                oIntento = new Intent(this, ActividadAgregar.class);
                startActivity(oIntento);
                break;
            case R.id.itemListar:
                oIntento = new Intent(this, ActividadListar.class);
                startActivity(oIntento);
                break;
            case R.id.itemSalir:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}