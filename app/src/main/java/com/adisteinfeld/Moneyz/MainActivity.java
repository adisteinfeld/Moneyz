package com.adisteinfeld.Moneyz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import java.io.IOException;
import java.util.Optional;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.adisteinfeld.Moneys.MESSAGE";
    public static String currentCountry;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationUtil.requestLocationPermissionIfNecessary(this);
        AppDB.createCountriesDB(getApplicationContext());
    }


    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showCountry(View view) throws IOException {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Optional<String> country = LocationUtil.getCountryName(this);
        if (country.isPresent()) {
            intent.putExtra(EXTRA_MESSAGE, country.get());
            currentCountry = country.get();
        }
        startActivity(intent);
    }
}
