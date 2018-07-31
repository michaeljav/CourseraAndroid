package com.exampleandroiddemottest.file_io;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.CorrectionInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void generarArchivo(View v){
        try {

            EditText editNombre = findViewById(R.id.editNombre);
            String nombre = editNombre.getText().toString();
            FileOutputStream outputStream = null;
            outputStream = openFileOutput("MyFile.txt", Context.MODE_PRIVATE);
            outputStream.write(nombre.getBytes());
            outputStream.close();

            Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.getStackTrace();
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
        }

    }

    public void GuardarPreferences(View view) {
        SharedPreferences myPreferencesCompartidas =
                getSharedPreferences("MisDatosPersonales",Context.MODE_PRIVATE);

        SharedPreferences.Editor  editor = myPreferencesCompartidas.edit();
        EditText editCorreo = findViewById(R.id.editCorreo);
        EditText editNombre = findViewById(R.id.editNombre);

        String nombre = editNombre.getText().toString();
        String correo = editCorreo.getText().toString();

        editor.putString("nombre",nombre);
        editor.putString("correo",correo);

        editor.commit();
        Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();

         editCorreo.setText("");
         editNombre.setText("");

    }

    public void MostrarPreferences(View view) {
//Si no existe la crea de nuevo
        SharedPreferences myPreferencesCompartidas =
                getSharedPreferences("MisDatosPersonales",Context.MODE_PRIVATE);

        String nombre = myPreferencesCompartidas.getString("nombre","no existe esa variable");
        String correo = myPreferencesCompartidas.getString("correo","no existe esa variable");

        TextView tvResultado = findViewById(R.id.tvResultado);
        String prefren= "\nNombre: "+nombre +"\nCorreo: "+ correo;
        tvResultado.setText(prefren);
    }
}
