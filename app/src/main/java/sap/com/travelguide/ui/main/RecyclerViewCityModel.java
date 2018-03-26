package sap.com.travelguide.ui.main;

import android.graphics.Bitmap;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class RecyclerViewCityModel {

    private String cityName;
    private String countryName;
    private String imageUrl;
    private Bitmap image;

    public RecyclerViewCityModel(String cityName, String countryName, String imageUrl) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.imageUrl = imageUrl;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
