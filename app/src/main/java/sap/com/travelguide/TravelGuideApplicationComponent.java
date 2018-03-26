package sap.com.travelguide;

import javax.inject.Singleton;

import dagger.Component;
import sap.com.travelguide.interactor.InteractorModule;
import sap.com.travelguide.interactor.detail.DetailInteractor;
import sap.com.travelguide.interactor.main.MainInteractor;
import sap.com.travelguide.network.NetworkModule;
import sap.com.travelguide.network.WeatherApi;
import sap.com.travelguide.ui.UIModule;
import sap.com.travelguide.ui.detail.DetailActivity;
import sap.com.travelguide.ui.detail.DetailViewPagerAdapter;
import sap.com.travelguide.ui.detail.info.InfoFragment;
import sap.com.travelguide.ui.detail.info.InfoPresenter;
import sap.com.travelguide.ui.detail.info.InfoScreen;
import sap.com.travelguide.ui.detail.map.MapFragment;
import sap.com.travelguide.ui.detail.map.MapPresenter;
import sap.com.travelguide.ui.detail.weather.WeatherFragment;
import sap.com.travelguide.ui.detail.weather.WeatherPresenter;
import sap.com.travelguide.ui.main.MainActivity;
import sap.com.travelguide.ui.main.MainPresenter;

/**
 * Created by I344065 on 2018. 01. 18..
 */

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, NetworkModule.class})
public interface TravelGuideApplicationComponent {
    void inject(TravelGuideApplication travelGuideApplication);
    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);
    void inject(WeatherFragment weatherFragment);
    void inject(InfoFragment infoFragment);
    void inject(MapFragment mapFragment);
    void inject(MainPresenter mainPresenter);
    void inject(WeatherPresenter weatherPresenter);
    void inject(DetailViewPagerAdapter detailViewPagerAdapter);
    void inject(InfoPresenter infoPresenter);
    void inject(MapPresenter mapPresenter);
    void inject(MainInteractor mainInteractor);
    void inject(DetailInteractor detailInteractor);
}
