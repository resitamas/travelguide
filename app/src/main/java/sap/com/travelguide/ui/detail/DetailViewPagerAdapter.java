package sap.com.travelguide.ui.detail;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.io.Serializable;

import javax.inject.Inject;

import sap.com.travelguide.R;
import sap.com.travelguide.ui.detail.info.InfoFragment;
import sap.com.travelguide.ui.detail.map.MapFragment;
import sap.com.travelguide.ui.detail.weather.WeatherFragment;

import static sap.com.travelguide.TravelGuideApplication.injector;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public class DetailViewPagerAdapter extends FragmentStatePagerAdapter {

    Serializable city;
    Context ctx;

    @Inject
    WeatherFragment weatherFragment;

    @Inject
    InfoFragment infoFragment;

    @Inject
    MapFragment mapFragment;

    public DetailViewPagerAdapter(Context ctx, FragmentManager fm, Serializable city) {
        super(fm);
        injector.inject(this);
        this.city = city;
        this.ctx = ctx;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return weatherFragment;
            case 1:
                return infoFragment;
            default:
                return mapFragment;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ctx.getString(R.string.weatherTab);
            case 1:
                return ctx.getString(R.string.infomrationTab);
            default:
                return ctx.getString(R.string.mapTab);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
