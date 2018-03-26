package sap.com.travelguide.ui.detail.weather;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import sap.com.travelguide.interactor.Event;
import sap.com.travelguide.interactor.detail.DetailInteractor;
import sap.com.travelguide.interactor.detail.event.WeatherEvent;
import sap.com.travelguide.interactor.ImageEvent;
import sap.com.travelguide.interactor.detail.event.WeatherImageEvent;
import sap.com.travelguide.model.weather.ActualWeatherModel;
import sap.com.travelguide.ui.detail.DetailPresenter;

import static sap.com.travelguide.TravelGuideApplication.injector;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public class WeatherPresenter extends DetailPresenter<WeatherScreen> {

    @Inject
    Executor executor;

    @Inject
    DetailInteractor detailInteractor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(WeatherScreen screen) {
        super.attachScreen(screen);

        injector.inject(this);

        if (!bus.isRegistered(this)) {
            bus.register(this);
        }

    }

    @Override
    public void detachScreen() {

        bus.unregister(this);

        super.detachScreen();

    }

    @Override
    public void setCityModel(Serializable cityModel) {
        super.setCityModel(cityModel);
        screen.setCityName(getCityModel().getName());
    }

    public void getWeather() {

        screen.showProgressBar(true);

        executor.execute(new Runnable() {
            @Override
            public void run() {

                detailInteractor.getWeatherForCity(getCityModel().getName());
            }
        });

    }

    public void getWeatherImage(final String icon) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                detailInteractor.downloadWeatherImage(icon);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final WeatherEvent event) {
        if (checkEvent(event)) {

            ActualWeatherModel actualWeatherModel = event.getWeatherModel();

            getWeatherImage(actualWeatherModel.getWeather().get(0).getIcon());

            screen.update( (double) Math.round(actualWeatherModel.getMain().getTemp() * 10) / 10, actualWeatherModel.getWeather().get(0).getDescription(), actualWeatherModel.getMain().getHumidity(), actualWeatherModel.getMain().getPressure());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final WeatherImageEvent event) {
        if (checkEvent(event)) {
            screen.updateSkyImage(event.getImage());
            screen.showProgressBar(false);
        }
    }

    private boolean checkEvent(final Event event) {

        if (event.getThrowable() != null) {

            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getThrowable().getMessage());
            }
            return false;
        } else {
            return screen != null;
        }
    }

}
