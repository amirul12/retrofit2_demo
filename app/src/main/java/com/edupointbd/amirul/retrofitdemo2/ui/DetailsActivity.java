/*
 * Copyright (c) 2017. I am Amirul Islam. All @copyRight Reserved
 */

package com.edupointbd.amirul.retrofitdemo2.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.edupointbd.amirul.retrofitdemo2.R;
import com.edupointbd.amirul.retrofitdemo2.model.Flower;
import com.edupointbd.amirul.retrofitdemo2.model.helper.Constants;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    private TextView cate, price, instruction, name, productid;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        viewConfig();

        Intent intent = getIntent();
        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);

        cate.setText(flower.getCategory());
        price.setText(Double.toString(flower.getPrice()));
        instruction.setText(flower.getInstructions());
        name.setText(flower.getName());
        productid.setText("" + flower.getProductId());

        Picasso.with(getApplicationContext()).load("http://services.hanselandpetal.com/photos/"+flower.getPhoto()).into(img);
    }

    private void viewConfig() {
        cate = (TextView)findViewById(R.id.category);
        price = (TextView)findViewById(R.id.price);
        instruction = (TextView)findViewById(R.id.instructions);
        name = (TextView)findViewById(R.id.name);
        productid = (TextView)findViewById(R.id.productId);
        img = (ImageView) findViewById(R.id.imgDetails );
    }
}
