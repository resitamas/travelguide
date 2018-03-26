package sap.com.travelguide.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<T> listItems;

    public BaseAdapter(List<T> listItems) {
        this.listItems = listItems;
    }

    @Override
    public abstract RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public void swap(List<T> newListItems) {
        listItems.clear();
        listItems.addAll(newListItems);
        notifyDataSetChanged();
    }
}
