package com.example.sebastien.zirconia.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sebastien.zirconia.model.Placement;
import com.example.sebastien.zirconia.model.PlacementSMEER;
import com.example.sebastien.zirconia.R;

public class ListePlacements extends AppCompatActivity
{
    Placement[] placements = new Placement[2];
    PlacementSMEER[] placementsSMEER = new PlacementSMEER[5];
    ArrayAdapter<Placement> adapteurPlacements;
    ArrayAdapter<PlacementSMEER> adapteurPlacementsSMEER;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_liste_placements);

        placements[0] = new Placement(Placement.Type.Libre, 0f);
        placements[1] = new Placement(Placement.Type.Régulier, 1.5f);
        placementsSMEER[0] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, PlacementSMEER.Interet.Sécuritaire, 10);
        placementsSMEER[1] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, PlacementSMEER.Interet.Modéré, 20);
        placementsSMEER[2] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, PlacementSMEER.Interet.Équilibré, 30);
        placementsSMEER[3] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, PlacementSMEER.Interet.Expérimenté, 40);
        placementsSMEER[4] = new PlacementSMEER(Placement.Type.SMEER, 3.75f, PlacementSMEER.Interet.Risqué, 50);

        adapteurPlacements = new AdapteurArrayListePlacements(this, 0, placements);
        adapteurPlacementsSMEER = new AdapteurArrayListePlacementsSMEER(this, 0, placementsSMEER);

        final ListView listeAjoutPlacements = (ListView) findViewById(R.id.listePlacements);
        final ListView listeAjoutPlacementsSMEER = (ListView) findViewById(R.id.listePlacementsSMEER);

        listeAjoutPlacements.setAdapter(adapteurPlacements);
        listeAjoutPlacementsSMEER.setAdapter(adapteurPlacementsSMEER);

        listeAjoutPlacements.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //TODO
                /*partieActive.getJoueurs().get(position).setCompteBancaire2(partieActive.getJoueurs().get(position));
                adapteur.notifyDataSetChanged();
                BanqueZirconienne.actualisationComptesBancaires();
                finish();*/
            }
        });
        listeAjoutPlacementsSMEER.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
            View view = inflater.inflate(R.layout.layout_bouton_placement, null);

            TextView typePlacement = (TextView) view.findViewById(R.id.typePlacement);
            TextView tauxInteret = (TextView) view.findViewById(R.id.tauxInteret);

            typePlacement.setText(placement.getType().toString());
            tauxInteret.setText(getString(R.string.tauxInteret, Float.toString(placement.getTauxInterets()) + "%"));

            view.setBackgroundColor(Color.WHITE);
            view.setClickable(false);

            if(placement.getPlacementActif())
            {
                view = inflater.inflate(R.layout.layout_placement_existant, null);
                view.setBackgroundColor(Color.GRAY);
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
            View view = inflater.inflate(R.layout.layout_bouton_placement_smeer, null);

            TextView interet = (TextView) view.findViewById(R.id.interet);
            TextView variation = (TextView) view.findViewById(R.id.variation);

            interet.setText(placement.getInteret().toString());
            variation.setText(getString(R.string.variationsInteret, Integer.toString(placement.getVariation()) + "%"));

            view.setBackgroundColor(Color.WHITE);
            view.setClickable(false);

            if(placement.getPlacementActif())
            {
                view = inflater.inflate(R.layout.layout_placement_existant, null);
                view.setBackgroundColor(Color.GRAY);
                view.setClickable(true);
            }

            return view;
        }

        //Méthodes
    }
}
