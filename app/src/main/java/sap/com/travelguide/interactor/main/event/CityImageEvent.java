package sap.com.travelguide.interactor.main.event;

import sap.com.travelguide.interactor.ImageEvent;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public class CityImageEvent extends ImageEvent {

    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
