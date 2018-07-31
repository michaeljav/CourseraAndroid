package com.exampleandroiddemottest.miscontantos.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;

import com.exampleandroiddemottest.miscontantos.R;
import com.exampleandroiddemottest.miscontantos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorContactos(Context context) {

        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){

//            ArrayList<Contacto>    contactos = new ArrayList<Contacto>();
//
//        contactos.add(new Contacto(R.drawable.uno,"Joelina Amador","8298588745","joel@gmail.com", 2));
//        contactos.add(new Contacto(R.drawable.dos,"Manuel ferroa","2222222222","Manuel@gmail.com", 3));
//        contactos.add(new Contacto(R.drawable.tres,"Jose ramiez","5555555555","josee@gmail.com", 4));
//        contactos.add(new Contacto(R.drawable.cuatro,"Samuel dominguez","3333333333","samuel@gmail.com", 6));
//        return contactos;

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosContactos();
    }

    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Joelina Amador");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,"829-858-8745");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL,"joel@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.uno);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Manuel ferroa");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,"2222222222");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL,"Manuel@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.dos);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Jose ramiez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,"5555555555");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL,"josee@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.tres);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Samuel dominguez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,"3333333333");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL,"samuel@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.cuatro);

        db.insertarContacto(contentValues);

    }

    public void darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_CONTACTO,contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES,LIKE);
        db.insertarLikeContacto(contentValues);



    }

    public  int obtenerLikesContactos(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return  db.obtenerLikesContacto(contacto);
    }


}
