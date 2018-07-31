package com.exampleandroiddemottest.miscontantos.fragment;

import com.exampleandroiddemottest.miscontantos.adapter.ContactoAdaptador;
import com.exampleandroiddemottest.miscontantos.pojo.Contacto;

import java.util.ArrayList;

public interface IReclyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
