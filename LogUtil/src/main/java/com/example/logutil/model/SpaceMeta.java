package com.example.logutil.model;

import com.google.gson.annotations.SerializedName;

public class SpaceMeta {
    @SerializedName("id")
    public final int id;

    @SerializedName("name")
    public final String name;

    @SerializedName("logo")
    public final String logo;

    @SerializedName("province")
    public  final Province province;

    @SerializedName("district")
    public  final District district;

    @SerializedName("address")
    public final String address;

    @SerializedName("shorten_address")
    public final String shortenAddress;

    @SerializedName("latitude")
    public final  double latitude;

    @SerializedName("longitude")
    public final  double longitude;

    @SerializedName("phone_number")
    public final String phoneNumber;

    @SerializedName("email")
    public final String email;

    @SerializedName("website")
    public final String website;

    @SerializedName("total_floors")
    public final  int totalFloors;

    @SerializedName("floor_area")
    public final  int floorArea;

    @SerializedName("ceiling_height")
    public final  double ceilingHeight;

    @SerializedName("elevator")
    public final String elevator;

    @SerializedName("air_conditioning")
    public final String airConditioning;

    @SerializedName("internet")
    public final String internet;

    @SerializedName("backup_power")
    public final String backupPower;

    @SerializedName("security")
    public final String security;

    @SerializedName("parking")
    public final String parking;

    public SpaceMeta(int id, String name, String logo, Province province, District district,
                     String address, String shortenAddress, double latitude, double longitude,
                     String phoneNumber, String email, String website, int totalFloors, int floorArea,
                     double ceilingHeight, String elevator, String airConditioning, String internet,
                     String backupPower, String security, String parking) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.province = province;
        this.district = district;
        this.address = address;
        this.shortenAddress = shortenAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
        this.totalFloors = totalFloors;
        this.floorArea = floorArea;
        this.ceilingHeight = ceilingHeight;
        this.elevator = elevator;
        this.airConditioning = airConditioning;
        this.internet = internet;
        this.backupPower = backupPower;
        this.security = security;
        this.parking = parking;
    }
}
