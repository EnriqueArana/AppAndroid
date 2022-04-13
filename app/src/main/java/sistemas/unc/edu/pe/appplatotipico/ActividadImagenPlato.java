package sistemas.unc.edu.pe.appplatotipico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ActividadImagenPlato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_actividad_imagen_plato);
        Bundle id = getIntent().getExtras();
        TextView tvTitulo = findViewById(R.id.tvTituloImagenPlato);
        tvTitulo.setText(id.getString("vTitulo"));
        ImageView imgPlato = findViewById(R.id.imgPlatoSolo);
        imgPlato.setImageResource(id.getInt("imagen"));
    }
}