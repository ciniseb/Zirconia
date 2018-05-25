package com.example.sebastien.zirconia;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MenuPrincipal extends AppCompatActivity
{
    //Créer
    static ArrayList<Partie> parties = new ArrayList<>();
    static int numPartie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_principal);
        if(parties.isEmpty())
            parties.add(new Partie());

        startActivity(new Intent(MenuPrincipal.this, Partie.class));
    }
}
