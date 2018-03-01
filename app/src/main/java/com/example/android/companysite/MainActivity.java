package com.example.android.companysite;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView TV_Localization;
    TextView TV_About;
    ImageView IV_Map;
    ImageView IV_Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();     //method where I put variables needing initialization

        LogoListener();
        LocalizationListener();
    }


    public void initialize() {      //method where I put variables needing initialization

        TV_Localization = findViewById(R.id.localization);
        TV_About = findViewById(R.id.about_description);
        IV_Map = findViewById(R.id.map);
        IV_Logo = findViewById(R.id.logo);

    }

    private void LogoListener() {
        IV_Logo.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        IV_Logo.setImageResource(R.drawable.zapiekanki_logo_3);
                        break;
                    case MotionEvent.ACTION_UP:
                        String url = "https://www.youtube.com/watch?v=z3bEL-l_qys";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        Uri u = Uri.parse(url);
                        i.setData(u);
                        try {
                            // Start the activity
                            startActivity(i);
                        } catch (ActivityNotFoundException e) {
                            // Raise on activity not found
                            Context context = v.getContext();
                            Toast toast = Toast.makeText(context, "Browser not found.", Toast.LENGTH_SHORT);
                        }
                        break;
                }


                return true;
            }
        });
    }

    private void LocalizationListener() {
        IV_Map.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "https://goo.gl/maps/8CbUdmsxed42";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setPackage("com.google.android.apps.maps");

                Uri u = Uri.parse(url);
                i.setData(u);
                try {
                    // Start the activity
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    // Raise on activity not found
                    Context context = v.getContext();
                    Toast toast = Toast.makeText(context, "Error, couldn't open map.", Toast.LENGTH_SHORT);
                }
            }


        });
        TV_Localization.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = "https://goo.gl/maps/8CbUdmsxed42";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setPackage("com.google.android.apps.maps");

                Uri u = Uri.parse(url);
                i.setData(u);
                try {
                    // Start the activity
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    // Raise on activity not found
                    Context context = v.getContext();
                    Toast toast = Toast.makeText(context, "Error, couldn't open map.", Toast.LENGTH_SHORT);
                }
            }


        });
    }


}
