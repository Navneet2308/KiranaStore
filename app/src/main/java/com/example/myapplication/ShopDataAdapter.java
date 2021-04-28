package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class ShopDataAdapter extends RecyclerView.Adapter<ShopDataAdapter.ViewHolder> {
    private Context context;

    Integer[] img={R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop1,R.drawable.shop1,R.drawable.shop3,R.drawable.shop1,R.drawable.shop2,R.drawable.shop3,R.drawable.shop2,R.drawable.shop2,R.drawable.shop3};

    String[] Shopname ={"New Shop","Besties Shope","New Kirana Store","New Shop","Besties Shope","ALL in One","New Kirana Store","ALL in One","Kirana Store","New Kirana Store","ALL in One","Kirana Store"};

    String[] Offer = {"FLat 50% Off","Flat 10% off","Flat 20% off","Flat 40% off","FLat 50% Off","Flat 10% off","Flat 20% off","Flat 40% off","FLat 50% Off","Flat 10% off","Flat 20% off","Flat 40% off"};

    public ShopDataAdapter( Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_data_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.nameTv.setText(Shopname[position]);
        holder.imageView.setImageResource(img[position]);
        holder.nameTv2.setText(Offer[position]);

    }


    @Override
    public int getItemCount() {
        return img.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView nameTv,nameTv2;
        public RecyclerView expandiconrecyclerview;


        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTv = itemView.findViewById(R.id.nameTv);
            nameTv2 = itemView.findViewById(R.id.nameTv2);
            expandiconrecyclerview=itemView.findViewById(R.id.expandiconrecyclerview);


        }
    }



}
