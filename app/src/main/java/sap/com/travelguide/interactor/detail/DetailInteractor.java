package sap.com.travelguide.interactor.detail;


import android.graphics.BitmapFactory;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;
import sap.com.travelguide.interactor.detail.event.WeatherEvent;
import sap.com.travelguide.interactor.ImageEvent;
import sap.com.travelguide.interactor.detail.event.WeatherImageEvent;
import sap.com.travelguide.model.weather.ActualWeatherModel;
import sap.com.travelguide.network.WeatherApi;

import static sap.com.travelguide.TravelGuideApplication.injector;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class DetailInteractor {

    @Inject
    WeatherApi weatherApi;

    @Inject
    EventBus bus;

    public DetailInteractor() {
        injector.inject(this);
    }

    public void getWeatherForCity(String cityName) {

        Call<ActualWeatherModel> weatherModelCall = weatherApi.getWeather(cityName,"df648f90d5bcabe91a89c6eb6ae57d2e", "metric");

        WeatherEvent event = new WeatherEvent();

        try {

            Response<ActualWeatherModel> response = weatherModelCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setWeatherModel(response.body());

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    public void downloadWeatherImage(String icon) {

        WeatherImageEvent event= new WeatherImageEvent();

        try {
            event.setImage(BitmapFactory.decodeStream(new java.net.URL(String.format("http://openweathermap.org/img/w/%s.png",icon)).openStream()));
        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

}
