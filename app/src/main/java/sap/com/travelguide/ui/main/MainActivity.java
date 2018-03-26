package sap.com.travelguide.ui.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import sap.com.travelguide.R;
import sap.com.travelguide.TravelGuideApplication;
import sap.com.travelguide.model.city.RegionModel;
import sap.com.travelguide.ui.ListItem;
import sap.com.travelguide.ui.detail.DetailActivity;
import sap.com.travelguide.utils.GsonHelper;

public class MainActivity extends AppCompatActivity implements MainScreen {

    MainAdapter mainAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TravelGuideApplication.injector.inject(this);

        ButterKnife.bind(this);

        initActivity();
    }

    public void initActivity() {

        mainAdapter = new MainAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        mainAdapter = new MainAdapter(this);
        recyclerView.setAdapter(mainAdapter);
        //mainAdapter.removeAllItems();

        try {
            mainPresenter.attachScreen(this);
            mainPresenter.getCities(getFromJSON());
        } catch (IOException e) {
            e.printStackTrace();
            showMessage(e.getMessage());
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        mainPresenter.detachScreen();
    }

    private String getFromJSON() throws IOException {

        Writer writer = new StringWriter();

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.citiesoftheworld), "UTF-8"));

            StringBuilder builder = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            return builder.toString();

        } finally {
            reader.close();
            writer.close();
        }
    }

    @Override
    public void downloadImage(int positon, String url) {
        mainPresenter.downloadImage(positon,url);
    }

    @Override
    public void imageDownloaded(int positon, Bitmap image) {
        mainAdapter.addImage(positon,image);
    }

    @Override
    public void showCities(List<ListItem> listItems, List<String> regions, List<RecyclerViewCityModel> models) {

        mainAdapter.swap(listItems, regions, models);
    }

    @Override
    public void navigateToCity(String cityName) {

        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("city", mainPresenter.findCityByName(cityName));
        i.putExtra("cityName", cityName);
        startActivity(i);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
