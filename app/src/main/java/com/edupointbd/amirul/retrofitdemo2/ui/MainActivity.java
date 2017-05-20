/*
 * Copyright (c) 2017. I am Amirul Islam. All @copyRight Reserved
 */

package com.edupointbd.amirul.retrofitdemo2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.edupointbd.amirul.retrofitdemo2.R;
import com.edupointbd.amirul.retrofitdemo2.controller.RestManeger;
import com.edupointbd.amirul.retrofitdemo2.model.Flower;
import com.edupointbd.amirul.retrofitdemo2.model.adapter.FlowerAdapter;
import com.edupointbd.amirul.retrofitdemo2.model.helper.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FlowerAdapter.FlowerOnClickListner {

    private RecyclerView recyclerView;

    private RestManeger mRestManeger;
    private FlowerAdapter mflowerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewConfig();

        mRestManeger = new RestManeger();
        Call<List<Flower>> listCall = mRestManeger.getFlowerService().getAllFlower();
        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if(response.isSuccessful()){

                    List<Flower> flowerLsit = response.body();

                    for(int i  = 0; i < flowerLsit.size(); i++){

                        Flower flower = flowerLsit.get(i);

                        mflowerAdapter.addFlower(flower);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });

    }

    private void viewConfig() {

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.getScrollState();

        mflowerAdapter = new FlowerAdapter(this);
        recyclerView.setAdapter(mflowerAdapter);
    }

    @Override
    public void onClick(int position) {

        Flower selectedFlower = mflowerAdapter.getFlower(position);

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra(Constants.REFERENCE.FLOWER,selectedFlower);
        startActivity(intent);

    }
}
