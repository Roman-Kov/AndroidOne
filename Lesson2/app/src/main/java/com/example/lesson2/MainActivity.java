package com.example.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements Constants{

    private ImageView cityEmblemView;
    private Spinner citySpinner;
    private Button showWeatherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        onSelectSpinnersItem();
        onShowWeatherBtnClick();
    }

    void initViews(){
        cityEmblemView = findViewById(R.id.cityEmblem);
        citySpinner = findViewById(R.id.citySpinner);
        showWeatherButton = findViewById(R.id.showWeatherButton);
    }

    void onSelectSpinnersItem(){
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getSelectedItem().toString();
                cityEmblemView.setImageResource(CityValues.getInstance().getEmblemByCity(selectedCity));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        citySpinner.setOnItemSelectedListener(itemSelectedListener);
    }

    void onShowWeatherBtnClick(){
        showWeatherButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                intent.putExtra(CITY_NAME, citySpinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }
}
