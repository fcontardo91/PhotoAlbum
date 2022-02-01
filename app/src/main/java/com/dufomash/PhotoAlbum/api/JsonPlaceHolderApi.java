package com.dufomash.PhotoAlbum.api;

import com.dufomash.PhotoAlbum.model.ListElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("photos")
    Call<List<ListElement>> getPhotos();
}
