package com.example.sebastien.zirconia.model;

public class De
{
    //Variables
    int nbCotes;

    //Constructeurs
    public De()
    {

    }

    //Méthodes
    public void setNbCotes(int nbCotes)
    {
        this.nbCotes = nbCotes;
    }
    public int brasser()
    {
        return (1 + (int)(Math.random() * nbCotes));
    }
}
