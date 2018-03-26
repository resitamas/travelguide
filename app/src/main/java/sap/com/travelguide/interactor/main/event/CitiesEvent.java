package sap.com.travelguide.interactor.main.event;

import java.util.List;

import sap.com.travelguide.interactor.Event;
import sap.com.travelguide.model.city.RegionModel;
import sap.com.travelguide.model.city.RegionsModel;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class CitiesEvent extends Event {

    private RegionsModel regions;

    public RegionsModel getRegions() {
        return regions;
    }

    public void setRegions(RegionsModel regions) {
        this.regions = regions;
    }
}
