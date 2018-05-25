package com.example.sebastien.zirconia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class Partie extends AppCompatActivity
{
    //Variables
    ArrayList<Joueur> joueurs = new ArrayList<>();

    //Constructeurs
    Partie()
    {
        //Temporaire
        joueurs.add(new Joueur("Ciniseb", "Galor", "Homme", "Sylphigle", "Cartomancien", 122, "Blanc", "chatain", "curvy", "chatain", "nullepart", "bleu", 0, 0, 0, 0, 0, 0, null, null, "Gabrya Winchester", "Aucune", 2, 69, new CompteBancaire(), false,85));
        joueurs.add(new Joueur("Gabrya", "Winchester", "Femme", "Zygöge", "Archer Élémentaire", 68, "Blanc", "brun", "droits", "bruns", "nullepart", "bleu", 0, 0, 0, 0, 0, 0, null, null, "Ciniseb Galor", "Aucune", 1, 54, new CompteBancaire(),false,85));
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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.banque_z:
                startActivity(new Intent(Partie.this, BanqueZirconienne.class));
                break;
            case R.id.des:

                break;
            case R.id.jeux_taverne:

                break;
            case R.id.guide_mj:

                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
