package com.exampleandroiddemottest.miscontantos.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exampleandroiddemottest.miscontantos.R;
import com.exampleandroiddemottest.miscontantos.adapter.ContactoAdaptador;
import com.exampleandroiddemottest.miscontantos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {


    ArrayList<Contacto> contactos;
    private RecyclerView listaCOntactos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

                listaCOntactos = v.findViewById(R.id.rvContactos);

        //Forma en mostrar  el en el recycler;
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaCOntactos.setLayoutManager(llm);


        inicializarListadeContactos();
        inicializarAdactador();

        return  v;
    }
    public void inicializarAdactador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,getActivity());
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
