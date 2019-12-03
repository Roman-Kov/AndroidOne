package com.example.lesson2;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Vector;

public class CityValues {
    private final HashMap<String, HashMap<String, Object>> cityValuesMap = new HashMap<>();
    private final String TEMPERATURE = "TEMPERATURE", EMBLEM = "EMBLEM", WIKI_URL = "WIKI_URL",
    YANDEX_WEATHER_URL = "YANDEX_WEATHER_URL";
    private static CityValues instance;

    private CityValues(){
        cityValuesMap.put("Москва", new HashMap<String, Object>());
        cityValuesMap.put("Санкт-Петербург", new HashMap<String, Object>());
        cityValuesMap.put("Мурманск", new HashMap<String, Object>());
        cityValuesMap.put("Краснодар", new HashMap<String, Object>());
        //записываем температуры
        cityValuesMap.get("Москва").put(TEMPERATURE, "-2");
        cityValuesMap.get("Санкт-Петербург").put(TEMPERATURE, "-5");
        cityValuesMap.get("Мурманск").put(TEMPERATURE, "-15");
        cityValuesMap.get("Краснодар").put(TEMPERATURE, "14");
        //записываем гербы
        cityValuesMap.get("Москва").put(EMBLEM, R.drawable.moscow);
        cityValuesMap.get("Санкт-Петербург").put(EMBLEM, R.drawable.spb);
        cityValuesMap.get("Мурманск").put(EMBLEM, R.drawable.murmansk);
        cityValuesMap.get("Краснодар").put(EMBLEM, R.drawable.krasnodar);
        //записываем URLS Яндекс погоды
        cityValuesMap.get("Москва").put(YANDEX_WEATHER_URL, "https://yandex.ru/pogoda/moscow?from=serp_title");
        cityValuesMap.get("Санкт-Петербург").put(YANDEX_WEATHER_URL, "https://yandex.ru/pogoda/saint-petersburg?from=serp_title");
        cityValuesMap.get("Мурманск").put(YANDEX_WEATHER_URL, "https://yandex.ru/pogoda/murmansk?from=serp_title");
        cityValuesMap.get("Краснодар").put(YANDEX_WEATHER_URL, "https://yandex.ru/pogoda/krasnodar?from=serp_title");
        //записываем URLS Wiki
        cityValuesMap.get("Москва").put(WIKI_URL, "https://ru.wikipedia.org/wiki/Москва");
        cityValuesMap.get("Санкт-Петербург").put(WIKI_URL, "https://ru.wikipedia.org/wiki/Санкт-Петербург");
        cityValuesMap.get("Мурманск").put(WIKI_URL, "https://ru.wikipedia.org/wiki/Мурманск");
        cityValuesMap.get("Краснодар").put(WIKI_URL, "https://ru.wikipedia.org/wiki/Краснодар");
    }

    public static CityValues getInstance(){
        if(instance == null){
            instance = new CityValues();
        }
        return instance;
    }

    public String getWikiUrlByCity(String city) {

        return cityValuesMap.get(city).get(WIKI_URL).toString();
    }

    public String getYandewWeatherUrlByCity(String city) {

        return cityValuesMap.get(city).get(YANDEX_WEATHER_URL).toString();
    }

    public String getTemperatureByCity(String city) {

        return cityValuesMap.get(city).get(TEMPERATURE).toString();
    }

    public Integer getEmblemByCity(String city) {

        return (Integer)cityValuesMap.get(city).get(EMBLEM);
    }

}
