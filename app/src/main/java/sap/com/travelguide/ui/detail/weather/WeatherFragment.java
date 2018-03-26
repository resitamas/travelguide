package sap.com.travelguide.ui.detail.weather;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sap.com.travelguide.R;
import sap.com.travelguide.TravelGuideApplication;
import sap.com.travelguide.ui.Presenter;
import sap.com.travelguide.ui.main.MainActivity;


public class WeatherFragment extends Fragment implements WeatherScreen{

    @Inject
    WeatherPresenter weatherPresenter;

    @BindView(R.id.humidity)
    TextView humidity;

    @BindView(R.id.pressure)
    TextView pressure;

    @BindView(R.id.temp)
    TextView temperature;

    @BindView(R.id.sky)
    TextView sky;

    @BindView(R.id.weatherImage)
    ImageView weatherImage;

    @BindView(R.id.indeterminateBar)
    ProgressBar progressBar;

    @BindView(R.id.humidityText)
    TextView humidityText;

    @BindView(R.id.pressureText)
    TextView pressureText;

    private Unbinder unbinder;

    public static WeatherFragment getInstance() {

        return new WeatherFragment();
    }

    public WeatherFragment() {
        TravelGuideApplication.injector.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        weatherPresenter.setCityModel(getActivity().getIntent().getSerializableExtra("city"));
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        //artist = getActivity().getIntent().getStringExtra(MainActivity.KEY_ARTIST);
        weatherPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        weatherPresenter.detachScreen();
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_weather,container,false);

        unbinder = ButterKnife.bind(this, root);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();

    }

    @Override
    public void onResume() {
        super.onResume();

        weatherPresenter.getWeather();

    }

    @Override
    public void showProgressBar(boolean show) {
        if (show) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void updateSkyImage(Bitmap skyImage) {
        weatherImage.setImageBitmap(skyImage);
    }

    @Override
    public void update(double temp, String sky, int humidity, int pressure) {
        temperature.setText(Double.toString(temp) + " \u2103");
        this.sky.setText(sky);
        this.humidity.setText(Integer.toString(humidity) + " %");
        this.pressure.setText(Integer.toString(pressure) + " hPa");
    }

    @Override
    public void setCityName(String cityName) {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
    }
}
