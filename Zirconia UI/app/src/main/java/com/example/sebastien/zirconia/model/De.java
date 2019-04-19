package com.example.sebastien.zirconia.model;

public class De
{
    //Variables
    int nbFaces;

    //Constructeurs
    public De()
    {

    }

    //Méthodes
    public void setNbFaces(int nbFaces)
    {
        this.nbFaces = nbFaces;
    }
    public int lancer()
    {
        return (1 + (int)(Math.random() * nbFaces));
    }
}

