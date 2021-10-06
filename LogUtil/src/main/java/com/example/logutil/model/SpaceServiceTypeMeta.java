package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class SpaceServiceTypeMeta {
    @SerializedName("id")
    public final int id;

    @SerializedName("name")
    public final String name;

    @SerializedName("service_type")
    public final int serviceType;

    @SerializedName("feature_image")
    public final String featureImage;

    public SpaceServiceTypeMeta(int id, String name, int serviceType, String featureImage) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.featureImage = featureImage;
    }
}
