package com.example.sebastien.zirconia.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sebastien.zirconia.R;
import com.example.sebastien.zirconia.model.CompteBancaire;
import com.example.sebastien.zirconia.model.Joueur;

import java.util.ArrayList;
import java.util.List;

import static com.example.sebastien.zirconia.activity.MenuPrincipal.partieActive;

public class ListeJoueurs extends AppCompatActivity
{
    ArrayAdapter<Joueur> adapteur;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_liste_joueurs);

        adapteur = new ListeJoueurs.AdapteurArrayListeJoueurs(this, 0, partieActive.getJoueurs());

        final ListView listeAjoutClientsBanque = (ListView) findViewById(R.id.listeJoueurs);
        listeAjoutClientsBanque.setAdapter(adapteur);

        listeAjoutClientsBanque.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(partieActive.getJoueurs().get(position).getCompteBancaire().getEtat() == CompteBancaire.Etat.Inexistant)
                    partieActive.getJoueurs().get(position).setCompteBancaire(new CompteBancaire(partieActive.getJoueurs().get(position)));
                else
                    partieActive.getJoueurs().get(position).getCompteBancaire().setEtat(CompteBancaire.Etat.Ouvert);

                adapteur.notifyDataSetChanged();
                BanqueZirconienne.actualisationCompte();
                finish();
            }
        });
    }
    //custom ArrayAdapter
    class AdapteurArrayListeJoueurs extends ArrayAdapter<Joueur>
    {

        private Context context;
        private List<Joueur> joueurs;

        public AdapteurArrayListeJoueurs(Context context, int resource, ArrayList<Joueur> objects)
        {
            super(context, resource, objects);

            this.context = context;
            this.joueurs = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            Joueur joueur = joueurs.get(position);

            //View d'un joueur
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_bouton_joueur_nouv_compte_bancaire, null);

            TextView prenomJoueur = (TextView) view.findViewById(R.id.prenomJoueur);
            TextView nomJoueur = (TextView) view.findViewById(R.id.nomJoueur);
            TextView fiabiliteClient = (TextView) view.findViewById(R.id.fiabiliteClient);
            TextView zirconsJoueur = (TextView) view.findViewById(R.id.zirconsJoueur);
            TextView factionJoueur = (TextView) view.findViewById(R.id.factionJoueur);
            TextView raceJoueur = (TextView) view.findViewById(R.id.raceJoueur);
            TextView classeJoueur = (TextView) view.findViewById(R.id.classeJoueur);
            TextView ageJoueur = (TextView) view.findViewById(R.id.ageJoueur);
            TextView genreJoueur = (TextView) view.findViewById(R.id.genreJoueur);

            prenomJoueur.setText(joueur.getPrenom());
            nomJoueur.setText(joueur.getNom());
            if(joueur.getCompteBancaire().getEtat() == com.example.sebastien.zirconia.model.CompteBancaire.Etat.Inexistant)
                fiabiliteClient.setText(R.string.fiabiliteInconnue);
            else
                fiabiliteClient.setText(getString(R.string.fiabiliteClient, joueur.getCompteBancaire().getFiabilite()));            zirconsJoueur.setText(getString(R.string.zirconsJoueur, joueur.getZircons()));
            factionJoueur.setText(getString(R.string.factionJoueur, joueur.getFaction()));
            raceJoueur.setText(getString(R.string.raceJoueur, joueur.getRace()));
            classeJoueur.setText(getString(R.string.classeJoueur, joueur.getClasse()));
            ageJoueur.setText(getString(R.string.ageJoueur, joueur.getAge()));
            genreJoueur.setText(getString(R.string.genreJoueur, joueur.getGenre()));


            view.setBackgroundColor(Color.WHITE);
            view.setClickable(false);

            if(joueur.getCompteBancaire().getEtat() == CompteBancaire.Etat.Ouvert)
            {
                view = inflater.inflate(R.layout.layout_compte_existant, null);
                view.setBackgroundColor(Color.GRAY);
                view.setClickable(true);
            }

            return view;
        }

        //Méthodes
    }
}
