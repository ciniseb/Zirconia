package com.example.sebastien.zirconia.model;

import android.widget.ArrayAdapter;

public class CompteBancaire
{
    //Variables
    public enum Etat{Ferme, Ouvert, Inexistant} private Etat etat;
    private int fiabilite;

    private Placement[] placements = new Placement[2];
    private PlacementSMEER[] placementsSMEER = new PlacementSMEER[5];

    //Constructeurs
    public CompteBancaire()
    {
        this.etat = Etat.Inexistant;
    }
    public CompteBancaire(Joueur joueur)
    {
        this.etat = Etat.Ouvert;
        this.fiabilite = 100;
        this.placements = new Placement[2];
        for(int i = 0 ; i < placements.length ; i++)
            placements[i] = new Placement();
        this.placementsSMEER = new PlacementSMEER[5];
        for(int i = 0 ; i < placementsSMEER.length ; i++)
            placementsSMEER[i] = new PlacementSMEER();
    }

    //Getteurs & setteurs
    public Etat getEtat()
    {
        return etat;
    }
    public int getFiabilite()
    {
        return fiabilite;
    }
    public Placement[] getPlacements()
    {
        return placements;
    }
    public PlacementSMEER[] getPlacementsSMEER()
    {
        return placementsSMEER;
    }

    public void setEtat(Etat etat)
    {
        this.etat = etat;
    }
}
