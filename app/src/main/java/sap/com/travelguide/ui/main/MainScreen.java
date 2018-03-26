package sap.com.travelguide.ui.main;

import android.graphics.Bitmap;

import java.util.List;

import sap.com.travelguide.ui.ListItem;
import sap.com.travelguide.ui.Screen;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public interface MainScreen extends Screen {
    void downloadImage(int positon, String url);
    void imageDownloaded(int positon, Bitmap image);
    void showCities(List<ListItem> listItems, List<String> regions, List<RecyclerViewCityModel> models);
    void navigateToCity(String cityName);
}
