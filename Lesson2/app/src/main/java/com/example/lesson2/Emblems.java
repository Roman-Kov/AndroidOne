package com.example.lesson2;

import android.widget.ImageView;

import java.util.HashMap;

public class Emblems {
    private final HashMap<String, Integer> cityEmblemMap = new HashMap<>();

    Emblems(){
        cityEmblemMap.put("Москва", R.drawable.moscow);
        cityEmblemMap.put("Санкт-Петербург", R.drawable.spb);
        cityEmblemMap.put("Мурманск", R.drawable.murmansk);
        cityEmblemMap.put("Краснодар", R.drawable.krasnodar);
    }


    public void setEmblemByCity(ImageView imageView, String city) {
        try {
            imageView.setImageResource(cityEmblemMap.get(city));
        }catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
