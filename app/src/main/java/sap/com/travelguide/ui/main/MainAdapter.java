package sap.com.travelguide.ui.main;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sap.com.travelguide.R;
import sap.com.travelguide.ui.AdapterWithHeader;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class MainAdapter extends AdapterWithHeader<String, RecyclerViewCityModel> implements View.OnClickListener {

    MainScreen mainScreen;

    public MainAdapter(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {
            return new RegionHeaderViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.regionheader,parent, false));
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent, false);
            v.setOnClickListener(this);
            return new CityCardViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {
            case 0:

                RegionHeaderViewHolder vh0 = (RegionHeaderViewHolder) holder;

                vh0.regionHeader.setText(headers.get(listItems.get(position).getIndex()));

                break;
            case 1:

                CityCardViewHolder vh1 = (CityCardViewHolder) holder;

                RecyclerViewCityModel model = contents.get(listItems.get(position).getIndex());

                vh1.city.setText(model.getCityName());
                vh1.country.setText(model.getCountryName());

                vh1.setTag(position);

                if (model.getImage() != null) {
                    vh1.cityImage.setImageBitmap(model.getImage());
                    vh1.progressBar.setVisibility(View.GONE);
                } else {
                    mainScreen.downloadImage(position,model.getImageUrl());
                }

                break;
            default:

                break;
        }

    }

    public void addImage(int position, Bitmap image) {
        contents.get(listItems.get(position).getIndex()).setImage(image);
        notifyItemChanged(position);
    }

    public void removeAllItems() {
        listItems = new ArrayList<>();
        contents = new ArrayList<>();
        headers = new ArrayList<>();
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        mainScreen.navigateToCity(contents.get(listItems.get((int)view.getTag()).getIndex()).getCityName());
    }
}
