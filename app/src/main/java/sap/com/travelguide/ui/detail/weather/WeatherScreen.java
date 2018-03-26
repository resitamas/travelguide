package sap.com.travelguide.ui.detail.weather;

import android.graphics.Bitmap;

import sap.com.travelguide.ui.Screen;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public interface WeatherScreen extends Screen {
    void showProgressBar(boolean show);
    void updateSkyImage(Bitmap skyImage);
    void update(double temp, String sky, int humidity, int pressure);
    void setCityName(String cityName);
}
