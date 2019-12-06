package com.adisteinfeld.Moneyz;

import androidx.room.Dao;
import androidx.room.Query;

@Dao
public interface DbQueries {

    @Query("SELECT country FROM countries")
    String[] loadAllCountries();

    @Query("SELECT currency, rate FROM countries WHERE country = :currentCountry")
    double getCurrencyAndRateFromCountry(String currentCountry);
}
