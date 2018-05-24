package com.example.sebastien.zirconia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

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

    //Overrides
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte_bancaire);
    }

}
