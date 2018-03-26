package sap.com.travelguide.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sap.com.travelguide.R;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class CityCardViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cityImage)
    public ImageView cityImage;

    @BindView(R.id.cityName)
    public TextView city;

    @BindView(R.id.countryName)
    public TextView country;

    @BindView(R.id.progress)
    public ProgressBar progressBar;

    private View itemView;

    public CityCardViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.itemView = itemView;

        //itemView.setTag(getAdapterPosition());
    }

    public View getItemView() {
        return itemView;
    }

    public void setTag(int tag) {
        itemView.setTag(tag);
    }
}
