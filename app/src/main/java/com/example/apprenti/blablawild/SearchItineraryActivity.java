package com.example.apprenti.blablawild;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class SearchItineraryActivity extends AppCompatActivity{

    EditText departure;
    EditText destination;
    Button searchButton;
    Context context;
    Calendar myCalendar = Calendar.getInstance();
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        departure = (EditText) findViewById(R.id.editTextSearhDeparture);
        destination = (EditText) findViewById(R.id.editTextSearchDestination);
        searchButton = (Button) findViewById(R.id.search_button);
        edittext = (EditText) findViewById(R.id.editTextSearchDate);

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
                    intent.putExtra("date", edittext.getText().toString());
                    startActivity(intent);
                }
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchItineraryActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }

        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }
}
