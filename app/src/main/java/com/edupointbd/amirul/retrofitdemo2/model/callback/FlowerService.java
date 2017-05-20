/*
 * Copyright (c) 2017. I am Amirul Islam. All @copyRight Reserved
 */

package com.edupointbd.amirul.retrofitdemo2.model.callback;

import com.edupointbd.amirul.retrofitdemo2.model.Flower;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by amirul on 20-May-17.
 * www.edupointbd.com
 */

public interface FlowerService {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> getAllFlower();
}
