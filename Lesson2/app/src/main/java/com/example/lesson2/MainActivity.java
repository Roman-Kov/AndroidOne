package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
//123
    private ImageView cityEmblemView;
    private TextView cityTemperatureView;
    private Spinner citySpinner;
    private TextView dateTextView;
    private Emblems cityEmblems = new Emblems();
    private Temperatures cityTemperatures = new Temperatures();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        onSelectSpinnersItem();
    }

    void initViews(){
        cityEmblemView = findViewById(R.id.cityEmblem);
        cityTemperatureView = findViewById(R.id.cityTemperature);
        citySpinner = findViewById(R.id.citySpinner);
        dateTextView = findViewById(R.id.date);
        cityEmblems = new Emblems();
        cityTemperatures = new Temperatures();
    }

    void onSelectSpinnersItem(){
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getSelectedItem().toString();
                cityEmblems.setEmblemByCity(cityEmblemView, selectedCity);
                cityTemperatures.setTemperatureByCity(cityTemperatureView, selectedCity);
                String today = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
                dateTextView.setText(today);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        citySpinner.setOnItemSelectedListener(itemSelectedListener);
    }
}
