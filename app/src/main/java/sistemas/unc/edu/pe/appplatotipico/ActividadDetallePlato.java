package sistemas.unc.edu.pe.appplatotipico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActividadDetallePlato extends AppCompatActivity {
    int indice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_actividad_detalle_plato);

        Bundle id = getIntent().getExtras();

        TextView tvTitulo = findViewById(R.id.tvTituloDetallePlato);
        TextView tvDescripcion = findViewById(R.id.tvDescripcionPlato);

        tvTitulo.setText(id.getString("vTitulo"));
        tvDescripcion.setText(id.getString("vDescripcion"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contextual, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent oIntento;

        switch (item.getItemId()) {
            /*
            case R.id.modificarItem:
                oIntento = new Intent(this, ActividadModificar.class);

                oIntento.putExtra("vTitulo", MainActivity.datos.objetoPlato(indice).getNombre());
                oIntento.putExtra("vOrigen", MainActivity.datos.objetoPlato(indice).getOrigen());
                oIntento.putExtra("vPrecio", MainActivity.datos.objetoPlato(indice).getPrecio().toString());
                oIntento.putExtra("vDescripcion", MainActivity.datos.objetoPlato(indice).getDescripcion());
                oIntento.putExtra("vPreferencia", MainActivity.datos.objetoPlato(indice).getPreferencia());
                oIntento.putExtra("vImagen", MainActivity.datos.objetoPlato(indice).getImagen().toString());
                oIntento.putExtra("vIndice", indice);
                startActivity(oIntento);
                this.finish();
                break;
             */

            case R.id.itemEliminar:
                AlertDialog.Builder alerta = new AlertDialog.Builder(this);
                alerta.setTitle("Alerta");
                alerta.setMessage("¿Está seguro de eliminar este plato?");
                alerta.setCancelable(false);

                alerta.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.datos.Eliminar(indice);
                        finish();
                    }
                });

                alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

                alerta.show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}