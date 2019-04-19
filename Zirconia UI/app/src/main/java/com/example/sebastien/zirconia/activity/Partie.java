package com.example.sebastien.zirconia.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.sebastien.zirconia.R;
import com.example.sebastien.zirconia.model.CompteBancaire;
import com.example.sebastien.zirconia.model.Joueur;

import java.util.ArrayList;

public class Partie extends AppCompatActivity
{
    //Variables
    ArrayList<Joueur> joueurs = new ArrayList<>();

    //Constructeurs
    Partie()
    {
        //Temporaire
        joueurs.add(new Joueur("Ciniseb", "Galor", "Homme", "Sylphigle", "Cartomancien", 122, "Blanc", "chatain", "curvy", "chatain", "nullepart", "bleu", 0, 0, 0, 0, 0, 0, null, null, "Gabrya Winchester", "Aucune", 2, 69, new CompteBancaire()));
        joueurs.add(new Joueur("Gabrya", "Winchester", "Femme", "Zygöge", "Archer Élémentaire", 68, "Blanc", "brun", "droits", "bruns", "nullepart", "bleu", 0, 0, 0, 0, 0, 0, null, null, "Ciniseb Galor", "Aucune", 1, 54, new CompteBancaire()));
    }

    //Getteurs & Setteurs
    public ArrayList<Joueur> getJoueurs()
    {
        return joueurs;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs)
    {
        this.joueurs = joueurs;
    }

    //Overrides
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_partie);

        Toolbar toolBarTitre = (Toolbar) findViewById(R.id.toolBarTitre);
        setSupportActionBar(toolBarTitre);

        Toolbar toolBarMenu = (Toolbar) findViewById(R.id.toolBarMenu);
        toolBarMenu.inflateMenu(R.menu.menu_partie_inf);

        toolBarMenu.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem arg0)
            {
                switch(arg0.getItemId())
                {
                    case R.id.banque_z:
                        startActivity(new Intent(Partie.this, BanqueZirconienne.class));
                        break;
                    case R.id.des:
                        startActivity(new Intent(Partie.this, Des.class));
                        break;
                    case R.id.jeux_taverne:
                        break;
                    case R.id.generateur_evenements:
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_partie_sup, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.guide_mj:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    //Méthodes
    public void startActivity(int position, Context context)
    {
        Intent intent = new Intent(context, this.getClass());
        intent.putExtra("position", position);
        context.startActivity(intent);
    }
}
