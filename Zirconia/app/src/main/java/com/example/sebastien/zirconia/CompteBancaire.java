package com.example.sebastien.zirconia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.sebastien.zirconia.MenuPrincipal.numPartie;
import static com.example.sebastien.zirconia.MenuPrincipal.parties;

/**
 * Created by sebastien on 18-01-31.
 */

public class CompteBancaire  extends AppCompatActivity
{
    //Variables
    String prenomClient, nomClient, raceClient, classeClient;
    int ageClient, fiabilité;

    ArrayList<Placement> placements;

    //État du compte
    boolean compteActif;

    //Constructeurs
    CompteBancaire()
    {
        this.compteActif = false;
    }
    CompteBancaire(Joueur joueur)//Constructeur lorsque le compte bancaire du joueur est créé
    {
        this.prenomClient = joueur.getPrenom();
        this.nomClient = joueur.getNom();
        this.raceClient = joueur.getRace();
        this.classeClient = joueur.getClasse();
        this.ageClient = joueur.getAge();
        this.fiabilité = joueur.getFiabilite();
        //this.placements = placements;

        this.compteActif = true;
    }

    //Getteurs & setteurs
    public String getPrenomClient()
    {
        return prenomClient;
    }
    public String getNomClient()
    {
        return nomClient;
    }
    public String getRaceClient()
    {
        return raceClient;
    }
    public String getClasseClient()
    {
        return classeClient;
    }
    public int getAgeClient()
    {
        return ageClient;
    }
    public int getFiabilité()
    {
        return fiabilité;
    }
    public ArrayList<Placement> getPlacements()
    {
        return placements;
    }
    public boolean getCompteActif()
    {
        return compteActif;
    }

    public void setCompteActif(boolean compteActif)
    {
        this.compteActif = compteActif;
    }

    //Méthodes
    public void startActivity(int position, Context context)
    {
        Intent intent = new Intent(context, this.getClass());
        intent.putExtra("position", position);
        context.startActivity(intent);
    }

    //Overrides
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte_bancaire);

        int position = getIntent().getIntExtra("position", 0);
        Joueur joueur = parties.get(numPartie).getJoueurs().get(position);

        TextView prenomClient = findViewById(R.id.prenomClient);
        TextView nomClient = findViewById(R.id.nomClient);

        prenomClient.setText(joueur.getPrenom());
        nomClient.setText(joueur.getNom());
    }

}
