package com.example.a62.fragment_application;

import android.content.DialogInterface;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFrament(new MainFragment());


    }

    public void replaceFrament(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentInteraction(String msg) {

        AlertDialog.Builder builder= new  AlertDialog.Builder(this)
                .setTitle("Mensaje")
                .setMessage(msg + "\nDesea regresar al fragmento anterior")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        replaceFrament(new MainFragment());
                    }
                })
                .setNegativeButton("no",null);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
