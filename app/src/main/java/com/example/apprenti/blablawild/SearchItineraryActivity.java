package com.example.apprenti.blablawild;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {

    EditText departure;
    EditText destination;
    EditText date;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        departure = (EditText) findViewById(R.id.editTextSearhDeparture);
        destination = (EditText) findViewById(R.id.editTextSearchDestination);
        date = (EditText) findViewById(R.id.editTextSearchDate);
        searchButton = (Button) findViewById(R.id.search_button);
        Intent intent = getIntent();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                if (departure.getText().toString().isEmpty() || destination.getText().toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_text, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Intent intent = new Intent(SearchItineraryActivity.this, ViewSearchItineraryResultsListActivity.class);
                    intent.putExtra("departure", departure.getText().toString());
                    intent.putExtra("destination", destination.getText().toString());
                    intent.putExtra("date", date.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}