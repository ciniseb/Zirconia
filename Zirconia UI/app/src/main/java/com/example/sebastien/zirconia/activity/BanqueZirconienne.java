package com.example.sebastien.zirconia.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sebastien.zirconia.CompteBancaire;
import com.example.sebastien.zirconia.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.sebastien.zirconia.activity.MenuPrincipal.partieActive;

public class BanqueZirconienne extends AppCompatActivity
{
    //Créer
    Button nouvCompte, suppUnCompte;
    static AdapteurArrayCompteBancaire adapteur;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_banque_zirconienne);

        //suppClique = false;
        final ArrayList<CompteBancaire> comptesBancaires = new ArrayList<>();
        for(int i = 0 ; i < partieActive.getJoueurs().size() ; i++)
        {
            comptesBancaires.add(partieActive.getJoueurs().get(i).getCompteBancaire());
        }
        adapteur = new AdapteurArrayCompteBancaire(this, 0, comptesBancaires);
        ListView listView = (ListView) findViewById(R.id.listeComptesBancaires);
        listView.setAdapter(adapteur);

        //Attribuer
        nouvCompte = (Button) findViewById(R.id.nouvCompte);
        suppUnCompte = (Button) findViewById(R.id.suppUnCompte);

        //Ajout des comptes bancaires manuellement
        //comptesBancaires.add(new CompteBancaire("Ciniseb","Galor","Sylphigle","Cartomancien",122,85));
        //comptesBancaires.add(new CompteBancaire("Léamsi","Galor","Zygöre","Druide",63,100));
        //comptesBancaires.add(new CompteBancaire("Gabrya","Winchester","Zygöre","Archer Élémentaire",56,90));

        nouvCompte.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(BanqueZirconienne.this, ListeJoueurs.class));
                //finish();
            }
        });
        suppUnCompte.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(suppUnCompte.getText() == "Annuler\nla suppression")
                {
                    suppUnCompte.setText("Supprimer\nun compte");
                    suppUnCompte.setSelected(false);
                    adapteur.setAfficheBoutonSupp(false);
                }
                else
                {
                    suppUnCompte.setText("Annuler\nla suppression");
                    suppUnCompte.setSelected(true);
                    adapteur.setAfficheBoutonSupp(true);
                }
                adapteur.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.wtf("Compte bancaire", comptesBancaires.get(position).getPrenomClient());
                comptesBancaires.get(position).startActivity(position, getApplicationContext());
            }
        });

    }
    //Méthodes
    static public void actualisationComptesBancaires()
    {
        ArrayList<CompteBancaire> comptesBancaires = new ArrayList<>();
        for(int i = 0 ; i < partieActive.getJoueurs().size() ; i++)
        {
            comptesBancaires.add(partieActive.getJoueurs().get(i).getCompteBancaire());
        }
        adapteur.clear();

        for (Object object : comptesBancaires)
        {

            adapteur.insert(comptesBancaires.get(adapteur.getCount()), adapteur.getCount());
        }
        adapteur.notifyDataSetChanged();
    }

    //custom ArrayAdapter
    class AdapteurArrayCompteBancaire extends ArrayAdapter<CompteBancaire>
    {
        private Context context;
        private int layout;
        private List<CompteBancaire> comptesBancaires;
        Boolean afficheBoutonSupp = null;

        public AdapteurArrayCompteBancaire(Context context, int resource, ArrayList<CompteBancaire> objects)
        {
            super(context, resource, objects);

            this.context = context;
            this.layout = resource;
            this.comptesBancaires = objects;
            afficheBoutonSupp = false;
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            final CompteBancaire compteBancaire = comptesBancaires.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_bouton_compte_bancaire, null);

            TextView prenomClient = (TextView) view.findViewById(R.id.prenomClient);
            TextView nomClient = (TextView) view.findViewById(R.id.nomClient);
            TextView fiabiliteClient = (TextView) view.findViewById(R.id.fiabiliteClient);
            ImageButton supp = (ImageButton) view.findViewById(R.id.supp);
            supp.setBackgroundResource(R.drawable.bouton_supp);

            prenomClient.setText(compteBancaire.getPrenomClient());
            nomClient.setText(compteBancaire.getNomClient());
            fiabiliteClient.setText(getString(R.string.fiabiliteClient, compteBancaire.getFiabilité()));

            supp.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    comptesBancaires.set(position, new CompteBancaire());
                    partieActive.getJoueurs().get(position).setCompteBancaire(new CompteBancaire());
                    notifyDataSetChanged();
                }
            });


            view.setClickable(false);


            if(!compteBancaire.getCompteActif())
            {
                view = inflater.inflate(R.layout.layout_compte_vide, null);
                view.setClickable(true);
            }
            else if(afficheBoutonSupp)
            {
                supp.setTranslationX(-330f);
            }
            else if(!afficheBoutonSupp)
            {
                supp.setTranslationX(330f);
            }

            return view;
        }

        public void setAfficheBoutonSupp(Boolean afficheBoutonSupp)
        {
            this.afficheBoutonSupp = afficheBoutonSupp;
        }
    }
}
