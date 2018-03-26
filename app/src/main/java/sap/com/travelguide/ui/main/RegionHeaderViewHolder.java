package sap.com.travelguide.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sap.com.travelguide.R;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class RegionHeaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.regionHeader)
    public TextView regionHeader;

    public RegionHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
