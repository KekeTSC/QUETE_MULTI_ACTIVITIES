package com.example.apprenti.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String destination = bundle.getString("destination");
        String departure = bundle.getString("departure");
        String date = bundle.getString("date");
        if (date.isEmpty()) {
            String title = departure + " >> " + destination;
            setTitle(title);
        }
        else{
            String title = departure + " >> " + destination + " le " + date;
            setTitle(title);
        }
    }
}

