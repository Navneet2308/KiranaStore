package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static  ShopDataAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

        mAdapter = new ShopDataAdapter(MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    private void initview() {
        recyclerView =findViewById(R.id.recycler_view);
    }
    public  void gotosearch(View view)
    {
        Intent intent = new Intent(MainActivity.this,SearchData.class);
        startActivity(intent);
    }

}