package com.example.apprenti.blablawild;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TripResultAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TripResultModel> tripResultModels;


    public TripResultAdapter(Context context, ArrayList<TripResultModel> tripResultModels) {
        this.context = context;
        this.tripResultModels = tripResultModels;
    }
    @Override
    public int getCount(){
        return tripResultModels.size();
    }

    @Override
    public Object getItem(int position){
        return tripResultModels.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.trip_item, parent, false);
        }

        TripResultModel currentItem = (TripResultModel) getItem(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.firstName);
        TextView dateText = (TextView) convertView.findViewById(R.id.departureTime);
        TextView priceText = (TextView) convertView.findViewById(R.id.price);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");

        nameText.setText(currentItem.getName());
        dateText.setText(sdf.format(currentItem.getDate()));
        priceText.setText(String.valueOf(currentItem.getPrix()) + "€");



        return convertView;
    }
}
