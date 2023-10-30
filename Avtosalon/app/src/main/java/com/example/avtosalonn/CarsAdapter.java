package com.example.avtosalonn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarsAdapter extends ArrayAdapter<Cars>{
    private LayoutInflater inflater;
    private int layout;
    private List<Cars> states;


    public CarsAdapter(Context context, int resource, List<Cars> states) {
        super(context, resource, states);
        this.states = states;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        View view=inflater.inflate(this.layout, parent, false);

        ImageView flagView = view.findViewById(R.id.flag);
        TextView nameView = view.findViewById(R.id.name);
        TextView capitalView = view.findViewById(R.id.capital);

        Cars cars = states.get(position);

        flagView.setImageResource(cars.getKartinka());
        nameView.setText(cars.getName());
        capitalView.setText(cars.getOpisanie());

        return view;
    }
}
