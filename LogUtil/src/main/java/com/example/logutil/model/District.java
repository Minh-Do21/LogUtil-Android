package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class District {
    @SerializedName("id")
    public final int id;

    @SerializedName("name")
    public final String name;

    @SerializedName("slug")
    public final String slug;

    public District(int id, String name, String slug) {
        this.id = id;
        this.name = name;
        this.slug = slug;
    }
}
