package com.guy.class22a_and_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_Summary extends AppCompatActivity {

    public static final String NAME = "NAME";
    public static final String GENDER = "GENDER";
    public static final String LOCATION = "LOCATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        String name = getIntent().getStringExtra(NAME);
        String gender = getIntent().getStringExtra(GENDER);
        String location = getIntent().getStringExtra(LOCATION);

    }
}