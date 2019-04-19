package com.example.sebastien.zirconia.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sebastien.zirconia.R;
import com.example.sebastien.zirconia.model.Placement;
import com.example.sebastien.zirconia.model.Joueur;
import com.example.sebastien.zirconia.model.PlacementSMEER;

import static com.example.sebastien.zirconia.activity.MenuPrincipal.partieActive;

/**
 * Created by sebastien on 18-01-31.
 */

public class CompteBancaire extends AppCompatActivity
{
    //Variables

    //Pour layout TEMPORAIRE
    ArrayAdapter<Placement> adapteurPlacements;
    ArrayAdapter<PlacementSMEER> adapteurPlacementsSMEER;

    //Constructeurs

    //Getteurs & setteurs


    //Méthodes
    public void startActivity(int position, Context context)
    {
        Intent intent = new Intent(context, this.getClass());
        intent.putExtra("position", position);
        context.startActivity(intent);
    }

    //Overrides
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_compte_bancaire);

        int position = getIntent().getIntExtra("position", 0);
        Joueur client = partieActive.getJoueurs().get(position);

        TextView prenomClient = findViewById(R.id.prenomClient);
        TextView nomClient = findViewById(R.id.nomClient);

        prenomClient.setText(client.getPrenom());
        nomClient.setText(client.getNom());

        Button nouvPlacement, suppUnPlacement;
        nouvPlacement = (Button) findViewById(R.id.nouvPlacement);
        suppUnPlacement = (Button) findViewById(R.id.suppUnPlacement);

        nouvPlacement.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(CompteBancaire.this, ListePlacements.class));
            }
        });
        suppUnPlacement.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //TODO
            }
        });

        Placement[] placements = new Placement[2];
        PlacementSMEER[] placementsSMEER = new PlacementSMEER[5];

        for(int i = 0; i < client.getCompteBancaire().getPlacements().length ; i++)
        {
            placements[i] = client.getCompteBancaire().getPlacements()[i];
        }
        for(int i = 0; i < client.getCompteBancaire().getPlacementsSMEER().length ; i++)
        {
            placementsSMEER[i] = client.getCompteBancaire().getPlacementsSMEER()[i];
        }
        //placements[0] = new Placement(Placement.Type.Libre, 0f, 5,0);
        //placements[1] = new Placement(Placement.Type.Régulier, 1.5f, 10,0);
        //placementsSMEER[0] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, 20,0, PlacementSMEER.Interet.Sécuritaire, 10);
        //placementsSMEER[1] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, 30,0, PlacementSMEER.Interet.Modéré, 20);
        //placementsSMEER[2] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, 40,0, PlacementSMEER.Interet.Équilibré, 30);
        //placementsSMEER[3] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, 60,0, PlacementSMEER.Interet.Expérimenté, 40);
        //placementsSMEER[4] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, 80,0, PlacementSMEER.Interet.Risqué, 50);

        adapteurPlacements = new AdapteurArrayListePlacements(this, 0, placements);
        adapteurPlacementsSMEER = new AdapteurArrayListePlacementsSMEER(this, 0, placementsSMEER);

        final ListView listePlacements = (ListView) findViewById(R.id.listePlacements);
        final ListView listePlacementsSMEER = (ListView) findViewById(R.id.listePlacementsSMEER);

        listePlacements.setAdapter(adapteurPlacements);
        listePlacementsSMEER.setAdapter(adapteurPlacementsSMEER);

        listePlacements.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //TODO
            }
        });
        listePlacementsSMEER.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //TODO
            }
        });

    }

    //custom ArrayAdapters
    class AdapteurArrayListePlacements extends ArrayAdapter<Placement>
    {

        private Context context;
        private Placement[] placements;

        public AdapteurArrayListePlacements(Context context, int resource, Placement[] objects)
        {
            super(context, resource, objects);

            this.context = context;
            this.placements = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            Placement placement = placements[position];

            //View d'un placement
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_placement, null);

            /*TextView typePlacement = (TextView) view.findViewById(R.id.typePlacement);
            TextView tauxInteret = (TextView) view.findViewById(R.id.tauxInteret);

            typePlacement.setText(placement.getType().toString());
            tauxInteret.setText(getString(R.string.tauxInteret, Float.toString(placement.getTauxInterets()) + "%"));*/

            view.setClickable(false);


            if(!placement.getPlacementActif())
            {
                view = inflater.inflate(R.layout.layout_placement_vide, null);
                view.setClickable(true);
            }

            return view;
        }

        //Méthodes
    }
    class AdapteurArrayListePlacementsSMEER extends ArrayAdapter<PlacementSMEER>
    {

        private Context context;
        private PlacementSMEER[] placements;

        public AdapteurArrayListePlacementsSMEER(Context context, int resource, PlacementSMEER[] objects)
        {
            super(context, resource, objects);

            this.context = context;
            this.placements = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            PlacementSMEER placement = placements[position];

            //View d'un placement SMEER
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_placement, null);

            /*TextView interet = (TextView) view.findViewById(R.id.interet);
            TextView variation = (TextView) view.findViewById(R.id.variation);

            interet.setText(placement.getInteret().toString());
            variation.setText(getString(R.string.variationsInteret, Integer.toString(placement.getVariation()) + "%"));*/

            view.setClickable(false);


            if(!placement.getPlacementActif())
            {
                view = inflater.inflate(R.layout.layout_placement_vide, null);
                view.setClickable(true);
            }

            return view;
        }

        //Méthodes
    }
}
