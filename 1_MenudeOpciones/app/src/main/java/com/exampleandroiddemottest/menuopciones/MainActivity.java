package com.exampleandroiddemottest.menuopciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
