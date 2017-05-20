/*
 * Copyright (c) 2017. I am Amirul Islam. All @copyRight Reserved
 */

package com.edupointbd.amirul.retrofitdemo2.controller;

import com.edupointbd.amirul.retrofitdemo2.model.callback.FlowerService;
import com.edupointbd.amirul.retrofitdemo2.model.helper.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amirul on 20-May-17.
 * www.edupointbd.com
 */

public class RestManeger {

    private FlowerService mFlowerService;

    public FlowerService getFlowerService(){

        if(mFlowerService == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASAE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            mFlowerService = retrofit.create(FlowerService.class);
        }

        return mFlowerService;
    }
}
