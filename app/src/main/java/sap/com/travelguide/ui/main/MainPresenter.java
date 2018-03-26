package sap.com.travelguide.ui.main;

import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import sap.com.travelguide.interactor.Event;
import sap.com.travelguide.interactor.main.MainInteractor;
import sap.com.travelguide.interactor.main.event.CitiesEvent;
import sap.com.travelguide.interactor.ImageEvent;
import sap.com.travelguide.interactor.main.event.CityImageEvent;
import sap.com.travelguide.model.city.CityModel;
import sap.com.travelguide.model.city.RegionModel;
import sap.com.travelguide.model.city.RegionsModel;
import sap.com.travelguide.ui.ListItem;
import sap.com.travelguide.ui.Presenter;
import sap.com.travelguide.utils.GsonHelper;

import static sap.com.travelguide.TravelGuideApplication.injector;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class MainPresenter extends Presenter<MainScreen> {

    RegionsModel regions;

    @Inject
    Executor executor;

    @Inject
    MainInteractor interactor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(MainScreen screen) {
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


    public void getCities(final String str) {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                //interactor.readCitiesFromResourceJSON(stream);

                CitiesEvent event = new CitiesEvent();

                try {
                    regions =  GsonHelper.objectFromString(str, new TypeToken<RegionsModel>(){}.getType());
                    event.setRegions(regions);
                } catch (Exception e) {
                    event.setThrowable(e);
                }

                bus.post(event);

            }
        });

    }

    public void downloadImage(final int position, final String imageUrl) {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                interactor.downloadImage(position,imageUrl);

            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final CitiesEvent event) {
        if (checkEvent(event)) {
            swap(event.getRegions());
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread1(final CityImageEvent event) {
        if (checkEvent(event)) {
            screen.imageDownloaded(event.getPosition(),event.getImage());
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

    private void swap(RegionsModel regionsModel) {

        List<ListItem> listItems = new ArrayList<>();
        List<String> headers = new ArrayList<>();
        List<RecyclerViewCityModel> contents = new ArrayList<>();

        for (RegionModel model: regionsModel.getRegions()) {

            listItems.add(new ListItem(headers.size(),0));
            headers.add(model.getName());

            for (CityModel city: model.getCities()) {

                listItems.add(new ListItem(contents.size(),1));
                contents.add(new RecyclerViewCityModel(city.getName(),city.getCountry(),city.getImage()));
            }
        }

        screen.showCities(listItems,headers,contents);
    }

    public Serializable findCityByName(String cityName) {

        for (RegionModel region: regions.getRegions()) {

            for (CityModel city: region.getCities()) {
                if (city.getName().equals(cityName)) {
                    return city;
                }
            }
        }
        return null;
    }
}
