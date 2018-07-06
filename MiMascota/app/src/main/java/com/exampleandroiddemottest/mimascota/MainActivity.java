package com.exampleandroiddemottest.mimascota;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();
    }

    public void agregarFAB(){
        FloatingActionButton miFAB= findViewById(R.id.fabMiFAB);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,getResources().getString(R.string.mensaje),Snackbar.LENGTH_SHORT)
                        /*si deseo hacer click snackbar*/
                        .setAction(getResources().getString(R.string.mensaje), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR","Click en snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        /*si deseo hacer click snackbar*/
                        .show();
            }
        });

        Button miButo = findViewById(R.id.btnMiBoton);
        miButo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
