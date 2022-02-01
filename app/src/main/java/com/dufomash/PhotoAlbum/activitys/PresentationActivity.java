package com.dufomash.PhotoAlbum.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.dufomash.PhotoAlbum.R;

public class PresentationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_presentation);

        getSupportActionBar().hide();

        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);

        TextView byTextView = findViewById(R.id.developTextView);

        byTextView.setAnimation(animacion);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PresentationActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}