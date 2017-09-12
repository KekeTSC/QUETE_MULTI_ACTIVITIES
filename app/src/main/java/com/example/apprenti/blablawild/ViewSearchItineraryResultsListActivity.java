package com.example.apprenti.blablawild;

import android.content.ClipData;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.util.ArrayList;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    ListView ListViewResults;
    TripResultAdapter ResultsAdapter;
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


        ListViewResults = (ListView) findViewById(R.id.listViewSearchResults);
        ArrayList<TripResultModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        ResultsAdapter = new TripResultAdapter(this, results);

        ListViewResults.setAdapter(ResultsAdapter);

        // [...]
    }
}

