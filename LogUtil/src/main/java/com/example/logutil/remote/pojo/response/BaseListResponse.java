package com.example.logutil.remote.pojo.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseListResponse<T> {
    @SerializedName("count")
    public final int count;

    @SerializedName("next")
    public final String next;

    @SerializedName("previous")
    public final String previous;

    @SerializedName("results")
    public final List<T> results;

    public BaseListResponse(int count, String next, String previous, List<T> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }
}
