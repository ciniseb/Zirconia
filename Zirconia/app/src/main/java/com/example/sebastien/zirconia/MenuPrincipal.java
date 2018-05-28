package com.example.sebastien.zirconia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;

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
        Toolbar mToolbar = (Toolbar) findViewById(R.id.titre_zirconia);
        setSupportActionBar(mToolbar);
        setTitle(null);

        if(parties.isEmpty())
            parties.add(new Partie());

        startActivity(new Intent(MenuPrincipal.this, Partie.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_plus, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.credits:
                startActivity(new Intent(MenuPrincipal.this, Generique.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
