package com.exampleandroiddemottest.miscontantos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.exampleandroiddemottest.miscontantos.pojo.Contacto;

import java.util.ArrayList;

public class BaseDatos  extends SQLiteOpenHelper {

    private  Context context;

//crea la base de datos o si existe se abre
    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS+"("+
                                            ConstantesBaseDatos.TABLE_CONTACTS_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                            ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE +" TEXT,"+
                                            ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO+" TEXT,"+
                                            ConstantesBaseDatos.TABLE_CONTACTS_EMAIL+" TEXT,"+
                                            ConstantesBaseDatos.TABLE_CONTACTS_FOTO+" INTEGER"+
                                            ")";


            String  queryCrearTableLikeContanto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +" ("+
                                                    ConstantesBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                                    ConstantesBaseDatos.TABLE_LIKES_ID_CONTACTO+ " INTEGER,"+
                                                    ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES+ " INTEGER,"+
                                                    "FOREIGN KEY ("+ConstantesBaseDatos.TABLE_LIKES_ID_CONTACTO +" ) "+
                                                    "REFERENCES "+ ConstantesBaseDatos.TABLE_CONTACTS +"("+ConstantesBaseDatos.TABLE_CONTACTS_ID+" )"+
                                                    ")";


//no va atraer valor de respuesta
          sqLiteDatabase.execSQL(queryCrearTablaContacto);
          sqLiteDatabase.execSQL(queryCrearTableLikeContanto);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_CONTACTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_CONTACT);
        //call the method
        onCreate(sqLiteDatabase);

    }

    public ArrayList<Contacto> obtenerTodosContactos(){

        ArrayList<Contacto> contactos  = new ArrayList<>();

        String query = "SELECT * FROM " +ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        //va a traer un valor de respuesta
        Cursor registros= db.rawQuery(query,null);

        while (registros.moveToNext()){
          Contacto contactoActual  = new Contacto();
          contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES+") as likes "+
                                " FROM "+ ConstantesBaseDatos.TABLE_LIKES_CONTACT+
                                " WHERE " +  ConstantesBaseDatos.TABLE_LIKES_ID_CONTACTO +"="+ contactoActual.getId();


            Cursor registrosLikes= db.rawQuery(queryLikes,null);
            if (registrosLikes.moveToNext()){
               contactoActual.setLikes(registrosLikes.getInt(0));
            }else {
                contactoActual.setLikes(0);
            }
             contactos.add(contactoActual);

        }
        db.close();
        return contactos;

    }


    public void insertarContacto(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS,null,contentValues);
        db.close();

    }

        public void insertarLikeContacto(ContentValues contentValues){

            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT,null,contentValues);
            db.close();


        }

        public int obtenerLikesContacto(Contacto contacto){

               int likes = 0;

               String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_NUMERO_LIKES+")"+
                                " FROM "+ ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                                " WHERE " +ConstantesBaseDatos.TABLE_LIKES_ID_CONTACTO + "="+contacto.getId();
               SQLiteDatabase db = this.getWritableDatabase();
               Cursor registros = db.rawQuery(query,null);
               if (registros.moveToNext()){
                   likes = registros.getInt(0);
               }
               db.close();
               return likes;
        }


}
