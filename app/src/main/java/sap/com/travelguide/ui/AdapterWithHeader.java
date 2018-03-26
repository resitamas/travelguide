package sap.com.travelguide.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public abstract class AdapterWithHeader<H,C> extends BaseAdapter<ListItem> {

    protected List<H> headers;
    protected List<C> contents;

    public AdapterWithHeader() {
        super(new ArrayList<ListItem>());

        headers = new ArrayList<>();
        contents = new ArrayList<>();
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemViewType(int position) {
        return listItems.get(position).getType();
    }

    public void swap(List<ListItem> newListItems, List<H> headers, List<C> contents) {
        this.headers = headers;
        this.contents = contents;
        super.swap(newListItems);
    }
}
