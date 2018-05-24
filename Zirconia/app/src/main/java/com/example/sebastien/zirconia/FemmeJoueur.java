package com.example.sebastien.zirconia;

/**
 * Created by sebastien on 18-02-06.
 */

public class FemmeJoueur extends Joueur
{
    //FEMME
    int grosseurPoitrine, beautePoitrine, grosseurCul, beauteCul;

    //Constructeurs
    FemmeJoueur(String prenom, String nom, String genre, String race, String classe, int age, String couleurPeau, String couleurCheveux, String formeCheveux, String couleurPoils, String emplacementDesPoils, String couleurYeux, int longueurCheveux, int beauteVisage, int grosseur, int grandeur, int musculature, int beauteCorps, String[] qualites, String[] defauts, String enCoupleAvec, String faction, int ressuzins, int zircons, CompteBancaire compteBancaire, Boolean compteBancaireExiste, int fiabilite, int grosseurPoitrine, int beautePoitrine, int grosseurCul, int beauteCul)
    {
        super(prenom, nom, genre, race, classe, age, couleurPeau, couleurCheveux, formeCheveux, couleurPoils, emplacementDesPoils, couleurYeux, longueurCheveux, beauteVisage, grosseur, grandeur, musculature, beauteCorps, qualites, defauts, enCoupleAvec, faction, ressuzins, zircons, compteBancaire, compteBancaireExiste, fiabilite);

        this.grosseurPoitrine = grosseurPoitrine;
        this.beautePoitrine = beautePoitrine;
        this.grosseurCul = grosseurCul;
        this.beauteCul = beauteCul;
    }
}
