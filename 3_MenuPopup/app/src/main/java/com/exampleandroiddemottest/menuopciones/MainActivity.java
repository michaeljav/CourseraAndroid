package com.exampleandroiddemottest.menuopciones;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tvNombre);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {

            case R.id.mAbout:
                Intent abou= new Intent(this, activity_About.class);
                startActivity(abou);
                break;

            case R.id.mSettings:
                Intent sett= new Intent(this, activity_setting.class);
                startActivity(sett);
                break;
        }

        return  true;
    }

    //recando menu de contexto
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //MenuInflater menuin = new MenuInflater(this);
        getMenuInflater().inflate(R.menu.menu_contexto,menu);


    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mcEdit:
                Toast.makeText(this,"Editing",Toast.LENGTH_SHORT).show();
                break;

            case R.id.mcDelete:
                Toast.makeText(this,"Deleting",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void ElevarPopup(View view) {
        ImageView imageView = findViewById(R.id.imgsun);
        PopupMenu popupMenu = new PopupMenu(this,imageView);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.mpopImagenView:
                        Toast.makeText(getApplicationContext(),"Imagen view",Toast.LENGTH_SHORT).show();
                        break;
                    case  R.id.mpopImagenDetails:
                        Toast.makeText(getApplicationContext(),"Imagen Details",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
