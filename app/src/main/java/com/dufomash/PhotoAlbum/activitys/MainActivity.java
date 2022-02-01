package com.dufomash.PhotoAlbum.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.dufomash.PhotoAlbum.R;
import com.dufomash.PhotoAlbum.adapters.ListAdapter;
import com.dufomash.PhotoAlbum.api.JsonPlaceHolderApi;
import com.dufomash.PhotoAlbum.api.RetrofitClient;
import com.dufomash.PhotoAlbum.model.ListElement;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.show();

            getPhotos();
    }

    public void getPhotos() {

        JsonPlaceHolderApi jsonPlaceHolderApi = RetrofitClient.getRetrofitInstance().create(JsonPlaceHolderApi.class);
        Call<List<ListElement>> call = jsonPlaceHolderApi.getPhotos();

        call.enqueue(new Callback<List<ListElement>>() {
            @Override
            public void onResponse(Call<List<ListElement>> call, Response<List<ListElement>> response) {

                progressDialog.dismiss();

                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, getString(R.string.faildata), Toast.LENGTH_SHORT).show();
                    return;
                }
                init(response.body());

            }

            @Override
            public void onFailure(Call<List<ListElement>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, getString(R.string.failconnection), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void init(List<ListElement> photoList) {

        ListAdapter listAdapter = new ListAdapter(photoList, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView =findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    //New Activity Description
    public void moveToDescription(ListElement item){
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListElement", item);
        startActivity(intent);
    }
}