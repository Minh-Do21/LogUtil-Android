package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class Province {
    @SerializedName("id")
    public final int id;

    @SerializedName("name")
    public final String name;

    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
