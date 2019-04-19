package com.example.sebastien.zirconia.activity;

import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sebastien.zirconia.R;
import com.example.sebastien.zirconia.model.De;

public class Des extends AppCompatActivity
{
    //Variables
    ImageView de[];
    ImageView imagedDeChoisi;
    Button brasser;
    TextView resultat;
    int couleurDes;
    int couleur[];

    De deChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.layout_des_portrait);
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.layout_des_paysage);
        }

        //Attributions
        de = new ImageView[6];
        de[0] = (ImageView) findViewById(R.id.d4);
        de[1] = (ImageView) findViewById(R.id.d6);
        de[2] = (ImageView) findViewById(R.id.d8);
        de[3] = (ImageView) findViewById(R.id.d10);
        de[4] = (ImageView) findViewById(R.id.d12);
        de[5] = (ImageView) findViewById(R.id.d20);
        imagedDeChoisi = (ImageView) findViewById(R.id.dChoisi);
        brasser = (Button) findViewById(R.id.brasser);
        resultat = (TextView) findViewById(R.id.resultat);

        //Attribution de la couleur par défault des dés
        couleurDes = getResources().getColor(R.color.deBeige);
        for(ImageView aDe : de) aDe.setColorFilter(couleurDes, PorterDuff.Mode.MULTIPLY);
        imagedDeChoisi.setColorFilter(couleurDes, PorterDuff.Mode.MULTIPLY);

        //Comportements
        for(int noDe = 0 ; noDe < de.length ; noDe++)
        {
            final int finalNoDe = noDe;
            de[noDe].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    imagedDeChoisi.setImageDrawable(de[finalNoDe].getDrawable());
                    resultat.setText("0");
                    float scale = getResources().getDisplayMetrics().density;
                    int dpAsPixels = (int) (20*scale + 0.5f);
                    for (ImageView aDe : de)
                        aDe.setPadding(dpAsPixels,dpAsPixels,dpAsPixels,dpAsPixels);
                    dpAsPixels = (int) (10*scale + 0.5f);
                    view.setPadding(dpAsPixels,dpAsPixels,dpAsPixels,dpAsPixels);

                    deChoisi = new De();
                    switch(finalNoDe)
                    {
                        case 0:
                            deChoisi.setNbFaces(4);
                            break;
                        case 1:
                            deChoisi.setNbFaces(6);
                            break;
                        case 2:
                            deChoisi.setNbFaces(8);
                            break;
                        case 3:
                            deChoisi.setNbFaces(10);
                            break;
                        case 4:
                            deChoisi.setNbFaces(12);
                            break;
                        case 5:
                            deChoisi.setNbFaces(20);
                            break;
                        default:
                            break;
                    }
                }
            });
        }
        brasser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(deChoisi != null)
                {
                    String txt = "" + deChoisi.lancer();
                    resultat.setText(txt);
                    //TODO Fonction qui brasse le dé 3-5 fois avant le resultat
                }
                else
                {
                    Toast message = Toast.makeText(getApplicationContext(),"Choisis un dé", Toast.LENGTH_SHORT);
                    message.setGravity(Gravity.CENTER, 0, 0);
                    message.show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_des, menu);

        couleur = new int[22];
        couleur[0] = getResources().getColor(R.color.deBeige);//TODO
        couleur[1] = getResources().getColor(R.color.deBrun);//TODO
        couleur[2] = getResources().getColor(R.color.deBleuPale);//TODO
        couleur[3] = getResources().getColor(R.color.deBleu);//TODO
        couleur[4] = getResources().getColor(R.color.deBleuFonce);//TODO
        couleur[5] = getResources().getColor(R.color.deRouge);//TODO
        couleur[6] = getResources().getColor(R.color.deBourgogne);//TODO
        couleur[7] = getResources().getColor(R.color.deJaune);//TODO
        couleur[8] = getResources().getColor(R.color.deOr);//TODO
        couleur[9] = getResources().getColor(R.color.deMauve);//TODO
        couleur[10] = getResources().getColor(R.color.deVert);//TODO
        couleur[11] = getResources().getColor(R.color.deVertForet);//TODO
        couleur[12] = getResources().getColor(R.color.deBlanc);//TODO
        couleur[13] = getResources().getColor(R.color.deNoir);//TODO
        couleur[14] = getResources().getColor(R.color.rougeZ);//TODO
        couleur[15] = getResources().getColor(R.color.orangeI);//TODO
        couleur[16] = getResources().getColor(R.color.jauneR);//TODO
        couleur[17] = getResources().getColor(R.color.roseC);//TODO
        couleur[18] = getResources().getColor(R.color.mauveO);//TODO
        couleur[19] = getResources().getColor(R.color.bleuN);//TODO
        couleur[20] = getResources().getColor(R.color.turquoiseI);//TODO
        couleur[21] = getResources().getColor(R.color.vertA);//TODO

        Drawable drawableCouleur[] = new Drawable[22];
        drawableCouleur[0] = menu.findItem(R.id.couleurBeige).getIcon();
        drawableCouleur[1] = menu.findItem(R.id.couleurBrun).getIcon();
        drawableCouleur[2] = menu.findItem(R.id.couleurBleuPale).getIcon();
        drawableCouleur[3] = menu.findItem(R.id.couleurBleu).getIcon();
        drawableCouleur[4] = menu.findItem(R.id.couleurBleuFonce).getIcon();
        drawableCouleur[5] = menu.findItem(R.id.couleurRouge).getIcon();
        drawableCouleur[6] = menu.findItem(R.id.couleurBourgogne).getIcon();
        drawableCouleur[7] = menu.findItem(R.id.couleurJaune).getIcon();
        drawableCouleur[8] = menu.findItem(R.id.couleurOr).getIcon();
        drawableCouleur[9] = menu.findItem(R.id.couleurMauve).getIcon();
        drawableCouleur[10] = menu.findItem(R.id.couleurVert).getIcon();
        drawableCouleur[11] = menu.findItem(R.id.couleurVertForet).getIcon();
        drawableCouleur[12] = menu.findItem(R.id.couleurBlanc).getIcon();
        drawableCouleur[13] = menu.findItem(R.id.couleurNoir).getIcon();
        drawableCouleur[14] = menu.findItem(R.id.couleurRougeZ).getIcon();
        drawableCouleur[15] = menu.findItem(R.id.couleurOrangeZ).getIcon();
        drawableCouleur[16] = menu.findItem(R.id.couleurJauneZ).getIcon();
        drawableCouleur[17] = menu.findItem(R.id.couleurRoseZ).getIcon();
        drawableCouleur[18] = menu.findItem(R.id.couleurMauveZ).getIcon();
        drawableCouleur[19] = menu.findItem(R.id.couleurBleuZ).getIcon();
        drawableCouleur[20] = menu.findItem(R.id.couleurTurquoiseZ).getIcon();
        drawableCouleur[21] = menu.findItem(R.id.couleurVertZ).getIcon();

        for(int noCouleur = 0 ; noCouleur < drawableCouleur.length ; noCouleur++)
        {
            drawableCouleur[noCouleur] = DrawableCompat.wrap(drawableCouleur[noCouleur]);
            drawableCouleur[noCouleur].setColorFilter(couleur[noCouleur], PorterDuff.Mode.MULTIPLY);
        }

        menu.findItem(R.id.couleurBeige).setIcon(drawableCouleur[0]);
        menu.findItem(R.id.couleurBrun).setIcon(drawableCouleur[1]);
        menu.findItem(R.id.couleurBleuPale).setIcon(drawableCouleur[2]);
        menu.findItem(R.id.couleurBleu).setIcon(drawableCouleur[3]);
        menu.findItem(R.id.couleurBleuFonce).setIcon(drawableCouleur[4]);
        menu.findItem(R.id.couleurRouge).setIcon(drawableCouleur[5]);
        menu.findItem(R.id.couleurBourgogne).setIcon(drawableCouleur[6]);
        menu.findItem(R.id.couleurJaune).setIcon(drawableCouleur[7]);
        menu.findItem(R.id.couleurOr).setIcon(drawableCouleur[8]);
        menu.findItem(R.id.couleurMauve).setIcon(drawableCouleur[9]);
        menu.findItem(R.id.couleurVert).setIcon(drawableCouleur[10]);
        menu.findItem(R.id.couleurVertForet).setIcon(drawableCouleur[11]);
        menu.findItem(R.id.couleurBlanc).setIcon(drawableCouleur[12]);
        menu.findItem(R.id.couleurNoir).setIcon(drawableCouleur[13]);
        menu.findItem(R.id.couleurRougeZ).setIcon(drawableCouleur[14]);
        menu.findItem(R.id.couleurOrangeZ).setIcon(drawableCouleur[15]);
        menu.findItem(R.id.couleurJauneZ).setIcon(drawableCouleur[16]);
        menu.findItem(R.id.couleurRoseZ).setIcon(drawableCouleur[17]);
        menu.findItem(R.id.couleurMauveZ).setIcon(drawableCouleur[18]);
        menu.findItem(R.id.couleurBleuZ).setIcon(drawableCouleur[19]);
        menu.findItem(R.id.couleurTurquoiseZ).setIcon(drawableCouleur[20]);
        menu.findItem(R.id.couleurVertZ).setIcon(drawableCouleur[21]);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.couleurBeige:
                couleurDes = couleur[0];
                break;
            case R.id.couleurBrun:
                couleurDes = couleur[1];
                break;
            case R.id.couleurBleuPale:
                couleurDes = couleur[2];
                break;
            case R.id.couleurBleu:
                couleurDes = couleur[3];
                break;
            case R.id.couleurBleuFonce:
                couleurDes = couleur[4];
                break;
            case R.id.couleurRouge:
                couleurDes = couleur[5];
                break;
            case R.id.couleurBourgogne:
                couleurDes = couleur[6];
                break;
            case R.id.couleurJaune:
                couleurDes = couleur[7];
                break;
            case R.id.couleurOr:
                couleurDes = couleur[8];
                break;
            case R.id.couleurMauve:
                couleurDes = couleur[9];
                break;
            case R.id.couleurVert:
                couleurDes = couleur[10];
                break;
            case R.id.couleurVertForet:
                couleurDes = couleur[11];
                break;
            case R.id.couleurBlanc:
                couleurDes = couleur[12];
                break;
            case R.id.couleurNoir:
                couleurDes = couleur[13];
                break;
            case R.id.couleurRougeZ:
                couleurDes = couleur[14];
                break;
            case R.id.couleurOrangeZ:
                couleurDes = couleur[15];
                break;
            case R.id.couleurJauneZ:
                couleurDes = couleur[16];
                break;
            case R.id.couleurRoseZ:
                couleurDes = couleur[17];
                break;
            case R.id.couleurMauveZ:
                couleurDes = couleur[18];
                break;
            case R.id.couleurBleuZ:
                couleurDes = couleur[19];
                break;
            case R.id.couleurTurquoiseZ:
                couleurDes = couleur[20];
                break;
            case R.id.couleurVertZ:
                couleurDes = couleur[21];
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        for(ImageView aDe : de) aDe.setColorFilter(couleurDes, PorterDuff.Mode.MULTIPLY);
        imagedDeChoisi.setColorFilter(couleurDes, PorterDuff.Mode.MULTIPLY);
        return true;
    }
}