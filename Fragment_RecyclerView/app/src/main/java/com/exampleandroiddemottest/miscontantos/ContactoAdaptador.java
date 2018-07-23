//<editor-fold desc="Description">
package com.exampleandroiddemottest.miscontantos;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactoAdaptador  extends  RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{
    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos,Activity activity){
        this.contactos = contactos;
        this.activity= activity;
    }



   //Inflar el layout y lo pasara al viewholder para el obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar o dar vida a nuestro layout cardview
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_contacto,parent,false);


        return new ContactoViewHolder(v);//Le pasamos el view  card  a nuestra clase   y devuelve ese objeto ContactoViewHolder
    }

////Asocia cada elemnto de  la lista con cada view
    ////
    //Este metodo se va invocando cada vez que se va recorriendo la lista de contactos, uno a uno items.
    //y va obteniendo la position of each element
    //asi va extrayendo los elementos de cada lista
    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {

        final Contacto contacto = contactos.get(position);

        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra(activity.getResources().getString(R.string.pNombre),contacto.getNombre());
                intent.putExtra(activity.getResources().getString(R.string.pTelefono),contacto.getTelefono());
                intent.putExtra(activity.getResources().getString(R.string.pEmail),contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Diste like a "+ contacto.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {//cantiada de elementos que contien mi lista
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private  TextView tvTelefonoCV;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = itemView.findViewById(R.id.tvTelefonoCV);
           btnLike = itemView.findViewById(R.id.btnLike);

        }


    }
}
//</editor-fold>
