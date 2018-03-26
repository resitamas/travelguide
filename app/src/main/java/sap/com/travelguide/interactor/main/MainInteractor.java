package sap.com.travelguide.interactor.main;

import android.graphics.BitmapFactory;

import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.inject.Inject;

import sap.com.travelguide.interactor.BaseInteractor;
import sap.com.travelguide.interactor.main.event.CitiesEvent;
import sap.com.travelguide.interactor.ImageEvent;
import sap.com.travelguide.interactor.main.event.CityImageEvent;
import sap.com.travelguide.model.city.RegionsModel;
import sap.com.travelguide.utils.GsonHelper;

import static sap.com.travelguide.TravelGuideApplication.injector;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class MainInteractor extends BaseInteractor{

    @Inject
    EventBus bus;

    public MainInteractor() {
        injector.inject(this);
    }

    public void downloadImage(int position, String imageUrl) {

        CityImageEvent event= new CityImageEvent();

        try {
            event.setImage(BitmapFactory.decodeStream(new java.net.URL(imageUrl).openStream()));
            event.setPosition(position);
        } catch (Exception e) {
           event.setThrowable(e);
        }

        bus.post(event);

    }

    public void readCitiesFromResourceJSON(InputStream stream) {

        Writer writer = new StringWriter();

        BufferedReader reader = null;

        CitiesEvent event = new CitiesEvent();

        try {
            reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));

            StringBuilder builder = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            String vvv = builder.toString();

            RegionsModel regions = GsonHelper.objectFromString(builder.toString(), new TypeToken<RegionsModel>(){}.getType());

            event.setRegions(regions);

        } catch (Exception e) {
            event.setThrowable(e);
        }
        finally {

            try {
                reader.close();
                writer.close();
            } catch (Exception e) {
                event.setThrowable(e);
            }
        }

        bus.post(event);
    }

}
