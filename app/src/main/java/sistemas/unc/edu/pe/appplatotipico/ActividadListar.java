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
        Bundle id = getIntent().getExtras();
        DAOPlatos oListaPlatos = (DAOPlatos) id.getSerializable("vLista");
        ListView lvLista = findViewById(R.id.listaPlatos);
        lvLista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,oListaPlatos.listar()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menucontextual,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemListaCancelar:
                finish();
                break;
            case R.id.itemListaEliminar:
        }
        return super.onOptionsItemSelected(item);
    }
}