package com.example.sebastien.zirconia.model;

import com.example.sebastien.zirconia.CompteBancaire;

/**
 * Created by sebastien on 18-02-06.
 */

public class HommeJoueur extends Joueur
{
    //HOMME
    int longueurP, grosseurP;

    //Constructeurs
    HommeJoueur(String prenom, String nom, String genre, String race, String classe, int age, String couleurPeau, String couleurCheveux, String formeCheveux, String couleurPoils, String emplacementDesPoils, String couleurYeux, int longueurCheveux, int beauteVisage, int grosseur, int grandeur, int musculature, int beauteCorps, String[] qualites, String[] defauts, String enCoupleAvec, String faction, int ressuzins, int zircons, CompteBancaire compteBancaire, Boolean compteBancaireExiste, int fiabilite, int longueurP, int grosseurP)
    {
        super(prenom, nom, genre, race, classe, age, couleurPeau, couleurCheveux, formeCheveux, couleurPoils, emplacementDesPoils, couleurYeux, longueurCheveux, beauteVisage, grosseur, grandeur, musculature, beauteCorps, qualites, defauts, enCoupleAvec, faction, ressuzins, zircons, compteBancaire, compteBancaireExiste, fiabilite);

        this.longueurP = longueurP;
        this.grosseurP = grosseurP;
    }
}