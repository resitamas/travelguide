package sap.com.travelguide.model.weather;

import java.util.List;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class ActualWeatherModel {

    private List<WeatherModel> weather;
    private MainWeather main;

    public List<WeatherModel> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherModel> weather) {
        this.weather = weather;
    }

    public MainWeather getMain() {
        return main;
    }

    public void setMain(MainWeather main) {
        this.main = main;
    }
}
