package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("photo")
    public final String photo;

    @SerializedName("thumbnail")
    public final String thumbnail;

    public Photo(String photo, String thumbnail) {
        this.photo = photo;
        this.thumbnail = thumbnail;
    }
}
