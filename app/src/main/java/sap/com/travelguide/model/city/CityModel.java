package sap.com.travelguide.model.city;

import java.io.Serializable;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class CityModel implements Serializable{

    private String city;
    private String country;
    private double latitude;
    private double longitude;
    private String image;
    private String info;

    public String getName() {
        return city;
    }

    public void setName(String name) {
        this.city = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
