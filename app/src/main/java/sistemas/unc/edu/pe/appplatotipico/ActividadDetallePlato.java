package sistemas.unc.edu.pe.appplatotipico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActividadDetallePlato extends AppCompatActivity {

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
}