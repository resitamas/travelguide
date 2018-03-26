package sap.com.travelguide.ui.detail.map;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ResourceCursorAdapter;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;

import javax.inject.Inject;

import sap.com.travelguide.R;
import sap.com.travelguide.TravelGuideApplication;
import sap.com.travelguide.ui.Presenter;
import sap.com.travelguide.ui.detail.weather.WeatherFragment;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public class MapFragment extends Fragment implements MapScreen, OnMapReadyCallback {

    @Inject
    MapPresenter mapPresenter;

    private GoogleMap mMap;

    public static MapFragment getInstance() {

        return new MapFragment();
    }

    public MapFragment() {
        TravelGuideApplication.injector.inject(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mapPresenter.setCityModel(getActivity().getIntent().getSerializableExtra("city"));

    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        //artist = getActivity().getIntent().getStringExtra(MainActivity.KEY_ARTIST);
        mapPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        mapPresenter.detachScreen();
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_map,container,false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        return root;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng city = new LatLng(mapPresenter.getCityModel().getLatitude(), mapPresenter.getCityModel().getLongitude());

        mMap.addMarker(new MarkerOptions().position(city).title("Marker in " + mapPresenter.getCityModel().getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(city));

    }
}
