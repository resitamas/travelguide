package sap.com.travelguide.interactor;

import android.graphics.Bitmap;

import sap.com.travelguide.interactor.Event;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public abstract class ImageEvent extends Event {

    private Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
