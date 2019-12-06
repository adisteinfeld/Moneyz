package com.adisteinfeld.Moneyz;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Countries")
public class Country {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "country")
    public String country;

    @NonNull
    @ColumnInfo(name = "currency")
    public String currency;
    @ColumnInfo(name = "rate")
    public double rate;
}
