package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Office {
    @SerializedName("id")
    public final int id;

    @SerializedName("name")
    public final String name;

    @SerializedName("photos")
    public final List<Photo> photos;

    @SerializedName("space_meta")
    public final SpaceMeta spaceMeta;

    @SerializedName("review")
    public final String review;

    @SerializedName("is_favorite")
    public final boolean isFavorite;

    @SerializedName("area")
    public final int area;

    @SerializedName("capacity")
    public final int capacity;

    @SerializedName("checkin")
    public final int checkIn;

    @SerializedName("space_service_type_meta")
    public final SpaceServiceTypeMeta spaceServiceTypeMeta;

    @SerializedName("price_avg")
    public final int priceAvg;

    @SerializedName("promotion_first")
    public final PromotionFirst promotionFirst;

    @SerializedName("real_price")
    public final int realPrice;

    @SerializedName("slug")
    public final String slug;

    public Office(int id, String name, List<Photo> photos, SpaceMeta spaceMeta, String review,
                  boolean isFavorite, int area, int capacity, int checkIn, SpaceServiceTypeMeta spaceServiceTypeMeta,
                  int priceAvg, PromotionFirst promotionFirst, int realPrice, String slug) {
        this.id = id;
        this.name = name;
        this.photos = photos;
        this.spaceMeta = spaceMeta;
        this.review = review;
        this.isFavorite = isFavorite;
        this.area = area;
        this.capacity = capacity;
        this.checkIn = checkIn;
        this.spaceServiceTypeMeta = spaceServiceTypeMeta;
        this.priceAvg = priceAvg;
        this.promotionFirst = promotionFirst;
        this.realPrice = realPrice;
        this.slug = slug;
    }
}
