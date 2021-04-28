package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class ShopDetails extends AppCompatActivity {
private  String offerstr,shopnamestr,available_itemstr;
private Integer shopimage;
private TextView shopeNameTv,priceTv,OfferTv,AddressTv,DetailsTv,available_item;
private ImageView ShopImageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_details);
        initview();


        try {
            offerstr = getIntent().getExtras().getString("offer");
            available_itemstr = getIntent().getExtras().getString("available_item");
            shopnamestr = getIntent().getExtras().getString("shopname");
            shopimage = getIntent().getExtras().getInt("shopimage");
        }
        catch (Exception e)
        {

        }

        ShopImageview.setImageResource(shopimage);
        shopeNameTv.setText(shopnamestr);
        priceTv.setText(offerstr);
        OfferTv.setText(offerstr+" on every products");
        available_item.setText(available_itemstr);


    }

    private void initview() {
        ShopImageview = findViewById(R.id.shop_img);
        shopeNameTv = findViewById(R.id.nameTv);
        priceTv = findViewById(R.id.priceTv);
        OfferTv = findViewById(R.id.offer);
        AddressTv= findViewById(R.id.address_tv);
        DetailsTv = findViewById(R.id.detailsTv);
        available_item=findViewById(R.id.available_item);

    }

    public  void  shareshop(View view) throws FileNotFoundException {
        Utils.shareshop(ShopDetails.this,shopnamestr,offerstr+" on every products");
    }


}