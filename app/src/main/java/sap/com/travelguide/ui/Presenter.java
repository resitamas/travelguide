package sap.com.travelguide.ui;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public abstract class Presenter<S> {

    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
