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
    boolean compteVide;

    //Constructeurs
    CompteBancaire(){}
    CompteBancaire(boolean compteVide)
    {
        this.compteVide = compteVide;
    }
    CompteBancaire(String prenomClient, String nomClient, String raceClient, String classeClient, int ageClient, int fiabilité/*, ArrayList<Placement> placements*/)
    {
        this.prenomClient = prenomClient;
        this.nomClient = nomClient;
        this.raceClient = raceClient;
        this.classeClient = classeClient;
        this.ageClient = ageClient;
        this.fiabilité = fiabilité;
        //this.placements = placements;
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
    public boolean getCompteVide()
    {
        return compteVide;
    }

    public void setCompteVide(boolean compteVide)
    {
        this.compteVide = compteVide;
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
