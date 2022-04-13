package sistemas.unc.edu.pe.appplatotipico;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.io.FileNotFoundException;
import java.io.InputStream;

import Modelo.Plato;

public class ActividadAgregar extends AppCompatActivity {
    EditText etNombre, etOrigen, etPrecio, etDescripcion;
    RatingBar rbPreferencia;
    ImageView imgPlato;
    // Uri imagenPlato;
    Bitmap imagenPlato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ly_actividad_agregar);
        etNombre = findViewById(R.id.etNombre);
        etOrigen = findViewById(R.id.etOrigen);
        etPrecio = findViewById(R.id.etPrecio);
        etDescripcion = findViewById(R.id.etDescripcion);
        rbPreferencia = findViewById(R.id.rbPreferenciaAgregar);
        imgPlato = findViewById(R.id.imgPlatoAgregar);

        imgPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarImagen();
            }
        });
        Button btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registarDatos();
            }
        });
    }

    private void registarDatos() {
        String nombre, origen, descripcion;
        double precio;
        int preferencia;
        nombre = etNombre.getText().toString();
        origen = etOrigen.getText().toString();
        descripcion = etDescripcion.getText().toString();
        precio = Double.valueOf(etPrecio.getText().toString());
        preferencia = rbPreferencia.getProgress();
        Plato oPlato = new Plato(nombre, origen, descripcion, precio, preferencia, imagenPlato);
        MainActivity.datos.agregar(oPlato);
        cuadroDialogo();
    }

    public void limpiarCuadros() {
        etNombre.setText("");
        etOrigen.setText("");
        etPrecio.setText("");
        etDescripcion.setText("");
        rbPreferencia.setProgress(0);
        imgPlato.setImageResource(R.drawable.seleccionar);
    }

    private void cuadroDialogo() {
        AlertDialog.Builder oDialogo = new AlertDialog.Builder(this);
        oDialogo.setTitle("Advertencia");
        oDialogo.setMessage("¿Desea seguir agregando platos?");
        oDialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                ActividadAgregar.this.finish();
            }
        });
        oDialogo.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                limpiarCuadros();
            }
        });
        oDialogo.create();
        oDialogo.show();
    }

    private void cargarImagen() {
        //Para tomar imágenes del dispositivo se tiene que tener permiso del dispositivo y se hace en Android Manifiest
        Intent oIntento = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        oIntento.setType("image/*");// El tipo de imagen que deseo cargar en la galería
        startActivityIfNeeded(Intent.createChooser(oIntento, "Seleccionar aplicación"), 10);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            /*imagenPlato = data.getData();
            imgPlato.setImageURI(imagenPlato);
            */

            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                imagenPlato = BitmapFactory.decodeStream(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            imgPlato.setImageBitmap(imagenPlato);
        }
    }
}