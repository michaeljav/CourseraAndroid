package com.exampleandroiddemottest.miscontantos.db;

import android.content.Context;

import com.exampleandroiddemottest.miscontantos.R;
import com.exampleandroiddemottest.miscontantos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private Context context;
    public ConstructorContactos(Context context) {

        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){

            ArrayList<Contacto>    contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.uno,"Joelina Amador","8298588745","joel@gmail.com", 2));
        contactos.add(new Contacto(R.drawable.dos,"Manuel ferroa","2222222222","Manuel@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.tres,"Jose ramiez","5555555555","josee@gmail.com", 4));
        contactos.add(new Contacto(R.drawable.cuatro,"Samuel dominguez","3333333333","samuel@gmail.com", 6));
        return contactos;
    }


}
