package com.exampleandroiddemottest.miscontantos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Joelina Amador","8298588745","joel@gmail.com"));
        contactos.add(new Contacto("Manuel ferroa","2222222222","Manuel@gmail.com"));
        contactos.add(new Contacto("Jose ramiez","5555555555","josee@gmail.com"));
        contactos.add(new Contacto("Samuel dominguez","3333333333","samuel@gmail.com"));

        ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contacto item: contactos) {

            nombreContacto.add(item.getNombre());
        }
        ListView lstContactos= findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);

                intent.putExtra(getResources().getString(R.string.pNombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.pTelefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEmail),contactos.get(i).getEmail());

                startActivity(intent);
                //Elimino esta actividad
                finish();
            }
        });

    }
}
