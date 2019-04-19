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

import com.example.sebastien.zirconia.R;
import com.example.sebastien.zirconia.model.Joueur;

import java.util.ArrayList;
import java.util.List;

import static com.example.sebastien.zirconia.activity.MenuPrincipal.partieActive;

public class BanqueZirconienne extends AppCompatActivity
{
    //Créer
    Button nouvCompte, suppUnCompte;
    static AdapteurArrayCompte adapteurCompte;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_banque_zirconienne);

        //suppClique = false;
        final ArrayList<Joueur> clients = new ArrayList<>(partieActive.getJoueurs());

        adapteurCompte = new AdapteurArrayCompte(this, 0, clients);
        ListView listeComptesBancaires = (ListView) findViewById(R.id.listeComptesBancaires);
        listeComptesBancaires.setAdapter(adapteurCompte);

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
                    adapteurCompte.setAfficheBoutonSupp(false);
                }
                else
                {
                    suppUnCompte.setText("Annuler\nla suppression");
                    suppUnCompte.setSelected(true);
                    adapteurCompte.setAfficheBoutonSupp(true);
                }
                adapteurCompte.notifyDataSetChanged();
            }
        });

        listeComptesBancaires.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Log.wtf("Compte bancaire", clients.get(position).getPrenom());
                CompteBancaire compteBancaire = new CompteBancaire();
                compteBancaire.startActivity(position, getApplicationContext());
            }
        });

    }
    //Méthodes
    static public void actualisationCompte()
    {
        ArrayList<Joueur> clients = new ArrayList<>(partieActive.getJoueurs());

        adapteurCompte.clear();

        for (Object object : clients)
        {
            adapteurCompte.insert(clients.get(adapteurCompte.getCount()), adapteurCompte.getCount());
        }
        adapteurCompte.notifyDataSetChanged();
    }

    //custom ArrayAdapter
    class AdapteurArrayCompte extends ArrayAdapter<Joueur>
    {
        private Context context;
        private int layout;
        private List<Joueur> clients;
        Boolean afficheBoutonSupp = null;

        public AdapteurArrayCompte(Context context, int resource, ArrayList<Joueur> objects)
        {
            super(context, resource, objects);

            this.context = context;
            this.layout = resource;
            this.clients = objects;
            afficheBoutonSupp = false;
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            final Joueur client = clients.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_bouton_compte_bancaire, null);

            TextView prenomClient = (TextView) view.findViewById(R.id.prenomClient);
            TextView nomClient = (TextView) view.findViewById(R.id.nomClient);
            TextView fiabiliteClient = (TextView) view.findViewById(R.id.fiabiliteClient);
            ImageButton supp = (ImageButton) view.findViewById(R.id.supp);
            supp.setBackgroundResource(R.drawable.bouton_supp);

            prenomClient.setText(client.getPrenom());
            nomClient.setText(client.getNom());
            fiabiliteClient.setText(getString(R.string.fiabiliteClient, client.getCompteBancaire().getFiabilite()));

            supp.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    clients.get(position).getCompteBancaire().setEtat(com.example.sebastien.zirconia.model.CompteBancaire.Etat.Ferme);
                    partieActive.getJoueurs().get(position).getCompteBancaire().setEtat(com.example.sebastien.zirconia.model.CompteBancaire.Etat.Ferme);
                    notifyDataSetChanged();
                }
            });


            view.setClickable(false);


            if(client.getCompteBancaire().getEtat() == com.example.sebastien.zirconia.model.CompteBancaire.Etat.Ferme || client.getCompteBancaire().getEtat() == com.example.sebastien.zirconia.model.CompteBancaire.Etat.Inexistant)
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
