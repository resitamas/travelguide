package sap.com.travelguide.ui;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import sap.com.travelguide.ui.detail.info.InfoFragment;
import sap.com.travelguide.ui.detail.info.InfoPresenter;
import sap.com.travelguide.ui.detail.map.MapFragment;
import sap.com.travelguide.ui.detail.map.MapPresenter;
import sap.com.travelguide.ui.detail.weather.WeatherFragment;
import sap.com.travelguide.ui.detail.weather.WeatherPresenter;
import sap.com.travelguide.ui.main.MainPresenter;

/**
 * Created by I344065 on 2018. 01. 18..
 */

@Module
public class UIModule {

    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public WeatherPresenter provideWeatherPresenter() {
        return new WeatherPresenter();
    }

    @Provides
    @Singleton
    public InfoPresenter provideInfoPresenter() {
        return new InfoPresenter();
    }

    @Provides
    @Singleton
    public MapPresenter provideMapPresenter() {
        return new MapPresenter();
    }

    @Provides
    @Singleton
    public WeatherFragment provideWeatherFragment() {
        return WeatherFragment.getInstance();
    }

    @Provides
    @Singleton
    public InfoFragment provideInfoFragment() {
        return InfoFragment.getInstance();
    }

    @Provides
    @Singleton
    public MapFragment provideMapFragment() {
        return MapFragment.getInstance();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
