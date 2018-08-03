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
import com.exampleandroiddemottest.miscontantos.presentador.IRecyclerViewFragmentPresenter;
import com.exampleandroiddemottest.miscontantos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IReclyclerViewFragmentView {


    ArrayList<Contacto> contactos;
    private RecyclerView RecyclerViewlistaCOntactos;
    private IRecyclerViewFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
                View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

                RecyclerViewlistaCOntactos = v.findViewById(R.id.rvContactos);

                //llamar el presentador
                presenter = new RecyclerViewFragmentPresenter(this,getContext());

            return  v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        //Forma en mostrar  el en el recycler;
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        RecyclerViewlistaCOntactos.setLayoutManager(llm);

    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        RecyclerViewlistaCOntactos.setAdapter(adaptador);
    }
}
