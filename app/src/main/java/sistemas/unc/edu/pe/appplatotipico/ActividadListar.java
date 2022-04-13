package sistemas.unc.edu.pe.appplatotipico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import AccesoDatos.DAOPlatos;

public class ActividadListar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_actividad_listar);

        ListView lvLista = findViewById(R.id.listaPlatos);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MainActivity.datos.listar());
        lvLista.setAdapter(arrayAdapter);
    }
}