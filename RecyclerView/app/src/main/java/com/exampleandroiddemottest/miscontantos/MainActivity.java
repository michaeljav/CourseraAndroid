package com.exampleandroiddemottest.miscontantos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaCOntactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaCOntactos = findViewById(R.id.rvContactos);

        //Forma en mostrar  el en el recycler;
        LinearLayoutManager  llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaCOntactos.setLayoutManager(llm);

//        GridLayoutManager glm = new GridLayoutManager(this,2);
//        listaCOntactos.setLayoutManager(glm);


        inicializarListadeContactos();
        inicializarAdactador();




//        ArrayList<String> nombreContacto = new ArrayList<>();
//        for (Contacto item: contactos) {
//
//            nombreContacto.add(item.getNombre());
//        }


//        ListView lstContactos= null;
//         //ListView lstContactos= findViewById(R.id.lstContactos);
//        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombreContacto));
//
//        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);
//
//                intent.putExtra(getResources().getString(R.string.pNombre),contactos.get(i).getNombre());
//                intent.putExtra(getResources().getString(R.string.pTelefono),contactos.get(i).getTelefono());
//                intent.putExtra(getResources().getString(R.string.pEmail),contactos.get(i).getEmail());
//
//                startActivity(intent);
//                //Elimino esta actividad
//                finish();
//            }
//        });

    }

    public void inicializarAdactador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,this);
                listaCOntactos.setAdapter(adaptador);
    }

    public void inicializarListadeContactos(){


        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.uno,"Joelina Amador","8298588745","joel@gmail.com"));
        contactos.add(new Contacto(R.drawable.dos,"Manuel ferroa","2222222222","Manuel@gmail.com"));
        contactos.add(new Contacto(R.drawable.tres,"Jose ramiez","5555555555","josee@gmail.com"));
        contactos.add(new Contacto(R.drawable.cuatro,"Samuel dominguez","3333333333","samuel@gmail.com"));
    }
}
