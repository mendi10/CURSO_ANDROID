package com.example.a62.ligth_app;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = MainActivity.class.getSimpleName();
    private Camera camera;
    private boolean isFlash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isFlash = getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);


        if(!isFlash){ //si la cmara no tiene flash, muestra un mensaje y cierra la app
            Log.e(TAG,"NO HAY FLASH");
            AlertDialog.Builder builder = new  AlertDialog.Builder(this)
                .setTitle("Alerta")
                .setCancelable(false)  //impide que se use el boton de atras
                .setMessage("su Dispositivo no posee flash")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    finish(); // cierra la app
                    }
                });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }

        ToggleButton toggleButton = (ToggleButton)findViewById(R.id.toggleButton);

        //se crea el listener para el boton
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) turnOnFlash();
                else turnOffFlash();
            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        getCamera();
        
    }

    private void getCamera() {
    }

    private void turnOffFlash() {
        
        
    }

    private void turnOnFlash() {
    }

}
