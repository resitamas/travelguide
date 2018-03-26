package sap.com.travelguide.model.city;

import java.util.List;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class RegionModel {

    private String name;
    private List<CityModel> cities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityModel> getCities() {
        return cities;
    }

    public void setCities(List<CityModel> cities) {
        this.cities = cities;
    }
}
