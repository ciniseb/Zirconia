package com.example.sebastien.zirconia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal extends AppCompatActivity
{
    //Créer
    static ArrayList<Partie> parties = new ArrayList<>();
    static Partie partieActive = new Partie();
    Button nouvPartie, quitter;
    static AdapteurArrayPartie adapteur;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu_principal);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.titre_zirconia);
        setSupportActionBar(mToolbar);
        setTitle(null);

        parties.add(new Partie());


        adapteur = new AdapteurArrayPartie(this, 0, parties);
        final ListView listView = (ListView) findViewById(R.id.listeParties);
        listView.setAdapter(adapteur);

        //Attribuer
        nouvPartie = (Button) findViewById(R.id.nouvPartie);
        quitter = (Button) findViewById(R.id.quitter);

        nouvPartie.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                parties.add(new Partie());
                adapteur.notifyDataSetChanged();
            }
        });
        quitter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                partieActive = parties.get(position);
                partieActive.startActivity(position, getApplicationContext());
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_plus, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.credits:
                startActivity(new Intent(MenuPrincipal.this, Generique.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    //custom ArrayAdapter
    class AdapteurArrayPartie extends ArrayAdapter<Partie>
    {
        private Context context;
        private int layout;
        private List<Partie> parties;

        public AdapteurArrayPartie(Context context, int resource, ArrayList<Partie> objects)
        {
            super(context, resource, objects);

            this.context = context;
            this.layout = resource;
            this.parties = objects;
        }

        public View getView(final int position, View convertView, ViewGroup parent)
        {
            final Partie partie = parties.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.layout_bouton_partie, null);

            return view;
        }
    }
}
