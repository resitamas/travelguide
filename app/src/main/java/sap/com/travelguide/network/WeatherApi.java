package sap.com.travelguide.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sap.com.travelguide.model.weather.ActualWeatherModel;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public interface WeatherApi {

    @GET("weather")
    Call<ActualWeatherModel> getWeather(@Query("q") String city, @Query("appid") String apiKey, @Query("units") String units);

}
