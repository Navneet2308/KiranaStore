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
    private ArrayList<String> shopname=new ArrayList<String>();
    private ArrayList<String> avialbleitemarray=new ArrayList<String>();
    private ArrayList<Integer> img=new ArrayList<Integer>();
    private ArrayList<String> offer=new ArrayList<String>();
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


        Utils.getshopname(shopname);
        Utils.getshopimg(img);
        Utils.getoffer(offer);
        Utils.getitems(avialbleitemarray);

        holder.nameTv.setText(shopname.get(position).toString());
        holder.imageView.setImageResource(img.get(position));
        holder.nameTv2.setText(offer.get(position).toString());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ShopDetails.class);
                intent.putExtra("offer",offer.get(position).toString());
                intent.putExtra("shopname",(shopname.get(position).toString()));
                intent.putExtra("shopimage",img.get(position));
                intent.putExtra("available_item",avialbleitemarray.get(position).toString());
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return 12;
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
