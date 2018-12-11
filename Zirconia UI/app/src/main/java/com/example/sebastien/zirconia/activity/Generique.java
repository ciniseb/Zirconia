package com.example.sebastien.zirconia.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.example.sebastien.zirconia.R;

public class Generique extends AppCompatActivity
{
    //Variables
    private RelativeLayout generique;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_generique);

        generique = (RelativeLayout) findViewById(R.id.generique);
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translation_generique);
        animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                finish();
            }
        });

        generique.startAnimation(animation);
    }
    @Override
    public void onBackPressed()
    {
        //super.onBackPressed();
    }
}
