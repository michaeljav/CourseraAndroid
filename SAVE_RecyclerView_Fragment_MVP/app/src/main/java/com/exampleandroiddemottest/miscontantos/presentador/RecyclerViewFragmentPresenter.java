package com.exampleandroiddemottest.miscontantos.presentador;

import android.content.Context;

import com.exampleandroiddemottest.miscontantos.db.ConstructorContactos;
import com.exampleandroiddemottest.miscontantos.fragment.IReclyclerViewFragmentView;
import com.exampleandroiddemottest.miscontantos.pojo.Contacto;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements  IRecyclerViewFragmentPresenter {

    private  IReclyclerViewFragmentView iReclyclerViewFragmentView;
    private  Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IReclyclerViewFragmentView iReclyclerViewFragmentView, Context context) {

        this.iReclyclerViewFragmentView = iReclyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {

        constructorContactos = new ConstructorContactos(context);
        //obtengo un
      contactos =   constructorContactos.obtenerDatos();
      mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
       iReclyclerViewFragmentView.inicializarAdaptadorRV(iReclyclerViewFragmentView.crearAdaptador(contactos));
       iReclyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
