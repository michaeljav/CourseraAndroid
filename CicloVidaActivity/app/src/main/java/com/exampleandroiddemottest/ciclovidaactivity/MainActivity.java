package com.exampleandroiddemottest.ciclovidaactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, getResources().getString(R.string.oncreate),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, getResources().getString(R.string.onstart),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getResources().getString(R.string.onresume),Toast.LENGTH_LONG).show();
    }
    //hasta aqui ya esta corriendo la actividad

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, getResources().getString(R.string.onrestart), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, getResources().getString(R.string.onpause),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, getResources().getString(R.string.onstop),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, getResources().getString(R.string.ondestroy),Toast.LENGTH_LONG).show();
    }

}
