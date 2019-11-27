package com.example.lesson2;

import android.widget.TextView;

import java.util.HashMap;

public class Temperatures {
    private final HashMap<String, String> cityTemperatureMap = new HashMap<>();

    Temperatures(){
        cityTemperatureMap.put("Москва", "-2");
        cityTemperatureMap.put("Санкт-Петербург", "-5");
        cityTemperatureMap.put("Мурманск", "-15");
        cityTemperatureMap.put("Краснодар", "14");
    }

    public void setTemperatureByCity(TextView textView, String city) {
        textView.setText(cityTemperatureMap.get(city));
    }
}
