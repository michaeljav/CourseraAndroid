package com.exampleandroiddemottest.file_io;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
}
