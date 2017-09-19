package com.example.apprenti.blablawild;

import android.content.ClipData;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    ListView ListViewResults;
    TripResultAdapter ResultsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        Intent intent = getIntent();
        SearchRequestModel request = intent.getExtras().getParcelable("searchRequest");
        String departure = request.getDepartureCity();
        String destination = request.getDestinationCity();
        Date date = request.getDateOfDepature();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Toast.makeText(getApplicationContext(), String.format("%1$tb %1$te, %1$tY",calendar), Toast.LENGTH_SHORT).show();

        setTitle(departure + " >> " + destination);


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

