package com.example.sebastien.zirconia;

/**
 * Created by sebastien on 18-02-02.
 */

public class Placement
{
    //Variables
    enum Type{Libre, Régulier, SMEER} Type type;
    float tauxInterets;
    int pourcPertesCriseEco;
    double montant;

    //État du placement
    Boolean placementActif;

    //Constructeurs
    Placement()
    {
        this.placementActif = false;
    }
    Placement(Type type, float tauxInterets)
    {
        this.type = type;
        this.tauxInterets = tauxInterets;
        this.placementActif = false;
    }
    Placement(Type type, float tauxInterets, int pourcPertesCriseEco, double montant)
    {
        this.type = type;
        this.tauxInterets = tauxInterets;
        this.pourcPertesCriseEco = pourcPertesCriseEco;
        this.montant = montant;
        this.placementActif = true;
    }

    //Getteurs & setteurs
    public Type getType()
    {
        return type;
    }
    public float getTauxInterets()
    {
        return tauxInterets;
    }
    public int getPourcPertesCriseEco()
    {
        return pourcPertesCriseEco;
    }
    public double getMontant()
    {
        return montant;
    }
    public Boolean getPlacementActif()
    {
        return placementActif;
    }

    public void setType(Type type)
    {
        this.type = type;
    }
    public void setTauxInterets(float tauxInterets)
    {
        this.tauxInterets = tauxInterets;
    }
    public void setPourcPertesCriseEco(int pourcPertesCriseEco)
    {
        this.pourcPertesCriseEco = pourcPertesCriseEco;
    }
    public void setMontant(double montant)
    {
        this.montant = montant;
    }
    public void setPlacementActif(Boolean placementActif)
    {
        this.placementActif = placementActif;
    }
    //Méthodes
}
