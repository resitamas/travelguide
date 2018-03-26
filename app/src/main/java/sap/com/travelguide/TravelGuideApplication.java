package sap.com.travelguide;

import android.app.Application;

import sap.com.travelguide.ui.UIModule;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class TravelGuideApplication extends Application {

    public static TravelGuideApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerTravelGuideApplicationComponent.builder().uIModule(new UIModule(this)).build();

        injector.inject(this);

    }

    public void setInjector(TravelGuideApplicationComponent appComponent) {

        injector = appComponent;
        injector.inject(this);

    }

}
