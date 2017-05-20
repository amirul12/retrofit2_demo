/*
 * Copyright (c) 2017. I am Amirul Islam. All @copyRight Reserved
 */

package com.edupointbd.amirul.retrofitdemo2.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edupointbd.amirul.retrofitdemo2.R;
import com.edupointbd.amirul.retrofitdemo2.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amirul on 20-May-17.
 * www.edupointbd.com
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    private final FlowerOnClickListner mListener;
    private List<Flower> mFlower;


    public FlowerAdapter( FlowerOnClickListner flowerOnClickListner) {
        mFlower = new ArrayList<>();
        mListener= flowerOnClickListner;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);

        return new Holder(row) ;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Flower flower = mFlower.get(position);

        holder.name.setText(flower.getName());
        holder.price.setText(Double.toString(flower.getPrice()));

        Picasso.with(holder.itemView.getContext()).load("http://services.hanselandpetal.com/photos/"+flower.getPhoto()).into(holder.img);


    }

    @Override
    public int getItemCount() {
        return mFlower.size();
    }

    public void addFlower(Flower flower) {
        mFlower.add(flower);
        notifyDataSetChanged();

    }

    public Flower getFlower(int position) {

        return  mFlower.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private ImageView img;
        private TextView name, price;

        public Holder(View itemView) {
            super(itemView);

            img = (ImageView)itemView.findViewById(R.id.imgFlowe);
            name = (TextView)itemView.findViewById(R.id.tvFlowerName);
            price = (TextView)itemView.findViewById(R.id.tvprizeName);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getLayoutPosition());

        }
    }

    public interface FlowerOnClickListner{

        void onClick(int position);
    }
}
