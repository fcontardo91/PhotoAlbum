package com.dufomash.PhotoAlbum.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.dufomash.PhotoAlbum.R;
import com.dufomash.PhotoAlbum.model.ListElement;
import com.squareup.picasso.Picasso;

public class DescriptionActivity extends AppCompatActivity {

    CardView cv1;
    ImageView imageDescriptionImageImageView;
    TextView titleDescriptionTextView,albumDescriptionTextView
            ,idDescriptionTextView, urlDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_description);

        getSupportActionBar().hide();

        cv1 = findViewById(R.id.cv1);

        ListElement element = (ListElement) getIntent().getSerializableExtra("ListElement");
        imageDescriptionImageImageView = findViewById(R.id.imageDescriptionImageView);
        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        albumDescriptionTextView = findViewById(R.id.albumDescriptionTextView);
        idDescriptionTextView = findViewById(R.id.idDescriptionTextView);
        urlDescriptionTextView = findViewById(R.id.urlDescriptionTextView);

        Picasso.get().load(element.getUrl()).into(imageDescriptionImageImageView);
        titleDescriptionTextView.setText(element.getTitle());
        albumDescriptionTextView.setText(element.getAlbumId());
        idDescriptionTextView.setText(element.getId());
        urlDescriptionTextView.setText(element.getUrl());
    }
}
