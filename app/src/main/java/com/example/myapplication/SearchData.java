package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchData extends AppCompatActivity implements TextWatcher, AdapterView.OnItemClickListener {
    public static AutoCompleteTextView searchEt;
    private List<String> strings;
    private ArrayList<String> arrayList;
    private ArrayList<Integer> imagearrayList=new ArrayList<Integer>();
    private ArrayList<String>shopnamearrayList=new ArrayList<String>();
    private ArrayList<String>offerarrayList=new ArrayList<String>();
    ListView listView;
    ProgressBar progressBar;
    RelativeLayout searcresult;
    LinearLayout nodatafound;
    ImageView back,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);
        searchEt = findViewById(R.id.searchEt);
        searcresult=findViewById(R.id.searcresult);
        progressBar=findViewById(R.id.progresslist);
        nodatafound=findViewById(R.id.nodatafound);
        strings = new ArrayList<>();
        listView=findViewById(R.id.lsit);
        back=findViewById(R.id.back_btn);
        search=findViewById(R.id.search_btn);

        searchEt.requestFocus();
        arrayList = new ArrayList<String>();
        Utils.getitems(arrayList);
        Utils.getoffer(offerarrayList);
        Utils.getshopimg(imagearrayList);
        Utils.getshopname(shopnamearrayList);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboardFrom(getApplicationContext(),v);
                serachdata(searchEt.getText().toString().trim());
            }
        });
        searchEt.setOnItemClickListener(this);
        searchEt.addTextChangedListener(this);
        searchEt.setOnEditorActionListener(new AutoCompleteTextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    serachdata(searchEt.getText().toString().trim());
                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                    return true;
                }
                return false;
            }
        });
    }

    private void serachdata(String strss) {
        strings.clear();
        for (String element : arrayList) {
            if (element.contains(strss)) {
                strings.add(element);
            }
        }
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchData.this, ShopDetails.class);
                intent.putExtra("offer", offerarrayList.get(position).toString());
                intent.putExtra("shopname", shopnamearrayList.get(position).toString());
                intent.putExtra("shopimage", imagearrayList.get(position));
                intent.putExtra("available_item",strings.get(position));
                searchEt.setText("");
                startActivity(intent);

            }
        });

    }



    private void hideKeyboardFrom(Context applicationContext, View v) {
        InputMethodManager imm = (InputMethodManager) applicationContext.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!s.toString().equals("")) {
            serachdata(s.toString());
        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}