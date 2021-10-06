package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class PromotionFirst {
    @SerializedName("discount_type")
    public final int discountType;

    @SerializedName("discount_value")
    public final int discountValue;

    @SerializedName("description")
    public final String description;

    public PromotionFirst(int discountType, int discountValue, String description) {
        this.discountType = discountType;
        this.discountValue = discountValue;
        this.description = description;
    }
}
