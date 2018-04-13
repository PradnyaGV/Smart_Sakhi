package com.example.shree.myapplication5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    TextView name;
    ImageView img;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        img=findViewById(R.id.img);
        name=findViewById(R.id.title);
        uptodown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup= AnimationUtils.loadAnimation(this,R.anim.downtoup);
        img.setAnimation(downtoup);
        name.setVisibility(View.VISIBLE);
        name.setAnimation(uptodown);
        new Thread() {
            public void run() {
                try {
                    sleep(2000);
                    startActivity(new Intent(Splash.this,MainActivity.class));
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }.start();




    }
}
