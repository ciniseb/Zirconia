package com.example.sebastien.zirconia.model;

/**
 * Created by sebastien on 18-06-04.
 */

public class PlacementSMEER extends Placement
{
    //Variables
    public enum Interet{Sécuritaire, Modéré, Équilibré, Expérimenté, Risqué} Interet interet;
    int variation;


    //Constructeurs
    public PlacementSMEER()
    {
        super();
    }
    PlacementSMEER(Type type, float tauxInterets, int pourcPertesCriseEco, double montant, Interet interet, int variation)
    {
        super(type, tauxInterets, pourcPertesCriseEco, montant);

        this.interet = interet;
        this.variation = variation;
        this.placementActif = true;
    }
    public PlacementSMEER(Type type, float tauxInterets, Interet interet, int variation)
    {
        super(type, tauxInterets);

        this.interet = interet;
        this.variation = variation;
    }

    //Getteurs & setteurs
    public Interet getInteret()
    {
        return interet;
    }
    public int getVariation()
    {
        return variation;
    }

    public void setInteret(Interet interet)
    {
        this.interet = interet;
    }
    public void setVariation(int variation)
    {
        this.variation = variation;
    }

    //Méthodes
}
