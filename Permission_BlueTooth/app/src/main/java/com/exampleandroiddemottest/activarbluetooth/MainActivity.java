package com.exampleandroiddemottest.activarbluetooth;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int CODIGO_SOLICITUD_PERMISO = 1 ;
    private static final int CODIGO_SOLICITUD_HABILITAR_BLUETOOTH = 0;
    private Context mContext;
        private Activity mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mActivity = this;
    }

    public void habilitarBluetooth(View view){

        solicitarPermiso();

        //verificar si en nuestro dispositivo existe un bluetooth
        BluetoothAdapter bluetoothAdapter =  BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null){
            Toast.makeText(MainActivity.this,"Tu dispositivo no tiene bluetooth",Toast.LENGTH_SHORT).show();
        }

        //si no esta abilitado el  bluetooth lo habilito
        if (!bluetoothAdapter.isEnabled()){
            Intent habilitarBletoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(habilitarBletoothIntent,CODIGO_SOLICITUD_HABILITAR_BLUETOOTH);
        }


    }
    //saber si el permiso ya se puso en el archivo manifiest.
    public boolean checarStatusPermiso(){
      //va a verificar si el permiso ya fue otorgado o no
        int resultado = ContextCompat.checkSelfPermission(mContext, Manifest.permission.BLUETOOTH);

        if (resultado == PackageManager.PERMISSION_GRANTED){

         return  true;
        }else {
            return  false;
        }
    }

//method to solictud the permission
    public void solicitarPermiso(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(mActivity,Manifest.permission.BLUETOOTH)){
            Toast.makeText(MainActivity.this,"El permiso ya fue otorgado ",Toast.LENGTH_SHORT).show();
        }
        else {
            ActivityCompat.requestPermissions(mActivity,new String[] {Manifest.permission.BLUETOOTH},CODIGO_SOLICITUD_PERMISO );
        }
    }


    //una vez que se haya deado de alta el permiso entonces se ejecuta.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      //  super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case CODIGO_SOLICITUD_PERMISO:
                //verificar que el permiso se haya realmente otorgado
                if (checarStatusPermiso()){
                    Toast.makeText(MainActivity.this,"Ya esta activo el permiso para Bluetooth ",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"NO esta activo el permiso para Bluetooth ",Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }
}
