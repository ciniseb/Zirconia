package com.example.sebastien.zirconia;

/**
 * Created by sebastien on 18-01-26.
 */

public class Joueur
{
    //Caractéristiques générales
    String prenom, nom, genre, race, classe;
    int age;

    //Caractéristiques physique
    String couleurPeau, couleurCheveux, formeCheveux, couleurPoils, emplacementDesPoils, couleurYeux;
    int longueurCheveux, beauteVisage;
    int grosseur, grandeur, musculature, beauteCorps;

    //Caractéristiques psychologique
    String[] qualites, defauts;

    //AUTRES
     String enCoupleAvec, faction;
     int ressuzins, zircons;

    //CompteBancaire
    CompteBancaire compteBancaire;
    Boolean compteBancaireExiste;
    int fiabilite;

    //Constructeur sans genre
    Joueur(String prenom, String nom, String genre, String race, String classe, int age, String couleurPeau, String couleurCheveux, String formeCheveux, String couleurPoils, String emplacementDesPoils, String couleurYeux, int longueurCheveux, int beauteVisage, int grosseur, int grandeur, int musculature, int beauteCorps, String[] qualites, String[] defauts, String enCoupleAvec, String faction, int ressuzins, int zircons,CompteBancaire compteBancaire, Boolean compteBancaireExiste, int fiabilite)
    {
        this.prenom = prenom;
        this.nom = nom;
        this.genre = genre;
        this.race = race;
        this.classe = classe;
        this.age = age;
        this.couleurPeau = couleurPeau;
        this.couleurCheveux = couleurCheveux;
        this.formeCheveux = formeCheveux;
        this.couleurPoils = couleurPoils;
        this.emplacementDesPoils = emplacementDesPoils;
        this.couleurYeux = couleurYeux;
        this.longueurCheveux = longueurCheveux;
        this.beauteVisage = beauteVisage;
        this.grosseur = grosseur;
        this.grandeur = grandeur;
        this.musculature = musculature;
        this.beauteCorps = beauteCorps;
        this.qualites = qualites;
        this.defauts = defauts;

        this.enCoupleAvec = enCoupleAvec;
        this.faction = faction;
        this.ressuzins = ressuzins;
        this.zircons = zircons;

        this.compteBancaire =compteBancaire;
        this.compteBancaireExiste = compteBancaireExiste;
        this.fiabilite = fiabilite;
    }

    //Méthodes


    //Getteurs & Setteurs
    public String getPrenom()
    {
        return prenom;
    }
    public String getNom()
    {
        return nom;
    }
    public String getGenre()
    {
        return genre;
    }
    public String getRace()
    {
        return race;
    }
    public String getClasse()
    {
        return classe;
    }
    public int getAge()
    {
        return age;
    }
    public String getCouleurPeau()
    {
        return couleurPeau;
    }
    public String getCouleurCheveux()
    {
        return couleurCheveux;
    }
    public String getFormeCheveux()
    {
        return formeCheveux;
    }
    public String getCouleurPoils()
    {
        return couleurPoils;
    }
    public String getEmplacementDesPoils()
    {
        return emplacementDesPoils;
    }
    public String getCouleurYeux()
    {
        return couleurYeux;
    }
    public int getLongueurCheveux()
    {
        return longueurCheveux;
    }
    public int getBeauteVisage()
    {
        return beauteVisage;
    }
    public int getGrosseur()
    {
        return grosseur;
    }
    public int getGrandeur()
    {
        return grandeur;
    }
    public int getMusculature()
    {
        return musculature;
    }
    public int getBeauteCorps()
    {
        return beauteCorps;
    }
    public String[] getQualites()
    {
        return qualites;
    }
    public String[] getDefauts()
    {
        return defauts;
    }
    public String getEnCoupleAvec()
    {
        return enCoupleAvec;
    }
    public String getFaction()
    {
        return faction;
    }
    public int getRessuzins()
    {
        return ressuzins;
    }
    public int getZircons()
    {
        return zircons;
    }
    public CompteBancaire getCompteBancaire()
    {
        return compteBancaire;
    }

    public Boolean getCompteBancaireExiste()
    {
        return compteBancaireExiste;
    }
    public int getFiabilite()
    {
        return fiabilite;
    }

    public void setCompteBancaire(Joueur joueur)
    {
        this.compteBancaire = new CompteBancaire(joueur);
    }
    public void setCompteBancaire(CompteBancaire compteBancaire )
    {
        this.compteBancaire = compteBancaire;
    }
    public void setCompteBancaireExiste(Boolean compteBancaireExiste)
    {
        this.compteBancaireExiste = compteBancaireExiste;
    }
}
