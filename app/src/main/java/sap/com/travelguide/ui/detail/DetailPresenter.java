package sap.com.travelguide.ui.detail;

import java.io.Serializable;

import sap.com.travelguide.model.city.CityModel;
import sap.com.travelguide.ui.Presenter;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public abstract class DetailPresenter<S> extends Presenter<S> {

    private CityModel cityModel;

    public CityModel getCityModel() {
        return cityModel;
    }

    public void setCityModel(Serializable cityModel) {
        this.cityModel = (CityModel) cityModel;
    }
}
