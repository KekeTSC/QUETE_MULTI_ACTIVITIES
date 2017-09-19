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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final Calendar myCalendar = Calendar.getInstance();
        Button searchButton = (Button) findViewById(R.id.search_button);
        final EditText dateText = (EditText) findViewById(R.id.editTextSearchDate);

        Intent intent = getIntent();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText departureText = (EditText) findViewById(R.id.editTextSearhDeparture);
                EditText destinationText = (EditText) findViewById(R.id.editTextSearchDestination);

                String departure = departureText.getText().toString();
                String destination = destinationText.getText().toString();

                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);


                if (departure.isEmpty() && destination.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_text_1, Toast.LENGTH_LONG);
                    toast.show();
                }
                else if (departure.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_text_2, Toast.LENGTH_LONG);
                    toast.show();
                }
                else if (destination.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_text_3, Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), ViewSearchItineraryResultsListActivity.class);
                    SearchRequestModel searchRequest = new SearchRequestModel(departure, destination, myCalendar.getTime());
                    intent.putExtra("searchRequest", searchRequest);
                    startActivity(intent);
                }
            }
        });

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
                dateText.setText(sdf.format(myCalendar.getTime()));
                //updateLabel();
            }
        };

        dateText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(SearchItineraryActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    /*private void updateLabel() {
        final EditText dateText = (EditText) findViewById(R.id.editTextSearchDate);
        final Calendar myCalendar = Calendar.getInstance();
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
        dateText.setText(sdf.format(myCalendar.getTime()));
    }
    */
}
