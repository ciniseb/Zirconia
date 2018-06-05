package com.example.sebastien.zirconia;

/**
 * Created by sebastien on 18-02-02.
 */

public class Placement
{
    //Variables
    enum Type{Libre, Régulier, SMEER} Type type;
    int tauxInterets;
    int pourcPertesCriseEco;
    double montant;



    //Constructeurs
    Placement()
    {

    }

    //Getteurs & setteurs
    public Type getType()
    {
        return type;
    }
    public int getTauxInterets()
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

    public void setType(Type type)
    {
        this.type = type;
    }
    public void setTauxInterets(int tauxInterets)
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

    //Méthodes
}
