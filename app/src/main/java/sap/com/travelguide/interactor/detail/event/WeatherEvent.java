package sap.com.travelguide.interactor.detail.event;

import sap.com.travelguide.interactor.Event;
import sap.com.travelguide.model.weather.ActualWeatherModel;
import sap.com.travelguide.model.weather.WeatherModel;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public class WeatherEvent extends Event {

    ActualWeatherModel weatherModel;

    public ActualWeatherModel getWeatherModel() {
        return weatherModel;
    }

    public void setWeatherModel(ActualWeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }
}
