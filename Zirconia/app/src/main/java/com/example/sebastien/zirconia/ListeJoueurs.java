package com.example.sebastien.zirconia;

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

import java.util.ArrayList;
import java.util.List;

public class ListeJoueurs extends AppCompatActivity
{
    ArrayAdapter<Joueur> adapteur;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_liste_joueurs);

        //create our new array adapter
        adapteur = new ListeJoueurs.AdapteurArrayListeJoueurs(this, 0, Partie.joueurs);

        //Find list view and bind it with the custom adapter
        final ListView listeAjoutComptesBancaires = (ListView) findViewById(R.id.listeJoueurs);
        listeAjoutComptesBancaires.setAdapter(adapteur);

        listeAjoutComptesBancaires.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                BanqueZirconienne.comptesBancaires.set(position, new CompteBancaire(Partie.joueurs.get(position).getPrenom(), Partie.joueurs.get(position).getNom(), Partie.joueurs.get(position).getRace(), Partie.joueurs.get(position).getClasse(), Partie.joueurs.get(position).getAge(), Partie.joueurs.get(position).getFiabilite()));
                //BanqueZirconienne.comptesBancaires.add(position, new CompteBancaire(Partie.joueurs.get(position).getPrenom(),Partie.joueurs.get(position).getNom(),Partie.joueurs.get(position).getRace(),Partie.joueurs.get(position).getClasse(),Partie.joueurs.get(position).getAge(),Partie.joueurs.get(position).getFiabilite()));
                //BanqueZirconienne.comptesBancaires.add(new CompteBancaire(Partie.joueurs.get(position).getPrenom(),Partie.joueurs.get(position).getNom(),Partie.joueurs.get(position).getRace(),Partie.joueurs.get(position).getClasse(),Partie.joueurs.get(position).getAge(),Partie.joueurs.get(position).getFiabilite()));
                Partie.joueurs.get(position).setCompteBancaireExiste(true);
                BanqueZirconienne.adapteur.notifyDataSetChanged();
                adapteur.notifyDataSetChanged();
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
            View view = inflater.inflate(R.layout.layout_bouton_joueur, null);

            TextView prenomJoueur = (TextView) view.findViewById(R.id.prenomJoueur);
            TextView nomJoueur = (TextView) view.findViewById(R.id.nomJoueur);
            TextView coupleJoueur = (TextView) view.findViewById(R.id.coupleJoueur);
            TextView factionJoueur = (TextView) view.findViewById(R.id.factionJoueur);
            TextView ressuzinsJoueur = (TextView) view.findViewById(R.id.ressuzinsJoueur);
            TextView zirconsJoueur = (TextView) view.findViewById(R.id.zirconsJoueur);
            TextView raceJoueur = (TextView) view.findViewById(R.id.raceJoueur);
            TextView classeJoueur = (TextView) view.findViewById(R.id.classeJoueur);
            TextView ageJoueur = (TextView) view.findViewById(R.id.ageJoueur);
            TextView genreJoueur = (TextView) view.findViewById(R.id.genreJoueur);

            prenomJoueur.setText(joueur.getPrenom());
            nomJoueur.setText(joueur.getNom());
            coupleJoueur.setText(getString(R.string.coupleJoueur, joueur.getEnCoupleAvec()));
            factionJoueur.setText(getString(R.string.factionJoueur, joueur.getFaction()));
            ressuzinsJoueur.setText(getString(R.string.ressuzinsJoueur, joueur.getRessuzins()));
            zirconsJoueur.setText(getString(R.string.zirconsJoueur, joueur.getZircons()));
            raceJoueur.setText(getString(R.string.raceJoueur, joueur.getRace()));
            classeJoueur.setText(getString(R.string.classeJoueur, joueur.getClasse()));
            ageJoueur.setText(getString(R.string.ageJoueur, joueur.getAge()));
            genreJoueur.setText(getString(R.string.genreJoueur, joueur.getGenre()));


            view.setBackgroundColor(Color.WHITE);
            view.setClickable(false);


            if(joueur.getCompteBancaireExiste())
            {
                view = inflater.inflate(R.layout.layout_compte_existant, null);
                view.setBackgroundColor(Color.GRAY);
                view.setClickable(true);
            }


            /*if(joueur.getCompteBancaireExiste())
                return emptyView;
            else
                return view;*/

            /*if(joueur.getCompteBancaireExiste())
                view.setVisibility(View.GONE);
            else
                view.setVisibility(View.VISIBLE);
            return view;*/

            /*if(joueur.getCompteBancaireExiste())
            {
                view.setClickable(true);
                view.setBackgroundColor(Color.GRAY);
            }
            else if(!joueur.getCompteBancaireExiste())
            {
                view.setClickable(false);
                view.setBackgroundColor(Color.WHITE);
            }*/
            return view;
        }

        //Méthodes
    }
}
