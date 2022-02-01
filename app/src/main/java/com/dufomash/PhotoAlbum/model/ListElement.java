package com.dufomash.PhotoAlbum.model;

import java.io.Serializable;

public class ListElement implements Serializable {

    private String title, url, thumbnailUrl, id, albumId;

    public ListElement(String title, String url, String thumbnailUrl, String id, String albumId) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.id = id;
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getId() {
        return id;
    }

    public String getAlbumId() {
        return albumId;
    }

}