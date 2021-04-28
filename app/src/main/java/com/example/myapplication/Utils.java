package com.example.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class Utils {

   public static void getitems(ArrayList arrayList)
    {
        arrayList.add("apple");
        arrayList.add("banana");
        arrayList.add("wheel");
        arrayList.add("cat");
        arrayList.add("coconut");
        arrayList.add("deer");
        arrayList.add("earphone");
        arrayList.add("eat");
        arrayList.add("fruits");
        arrayList.add("fruti");
        arrayList.add("greps");
        arrayList.add("go");
        arrayList.add("hat");
        arrayList.add("house");
        arrayList.add("ice cream");
        arrayList.add("jug");
    }

    public static void getshopname(ArrayList arrayList)
    {
        arrayList.add("New Shop");
        arrayList.add("Besties Shop");
        arrayList.add("New Kirana Store");
        arrayList.add("New Shop");
        arrayList.add("Besties Shop");
        arrayList.add("New Shop");
        arrayList.add("Besties Shop");
        arrayList.add("New Kirana Store");
        arrayList.add("New Shop");
        arrayList.add("Besties Shop");
        arrayList.add("New Kirana Store");
        arrayList.add("Besties Shop");
    }

    public static void getoffer(ArrayList arrayList)
    {
        arrayList.add("FLat 50% Off");
        arrayList.add("Flat 10% off");
        arrayList.add("Flat 20% off");
        arrayList.add("FLat 50% Off");
        arrayList.add("Flat 10% off");
        arrayList.add("Flat 20% off");
        arrayList.add("FLat 50% Off");
        arrayList.add("Flat 10% off");
        arrayList.add("Flat 20% off");
        arrayList.add("FLat 50% Off");
        arrayList.add("Flat 10% off");
        arrayList.add("Flat 20% off");
    }


    public  static  void  getshopimg(ArrayList arrayList)
    {

        arrayList.add( R.drawable.shop1);
        arrayList.add(R.drawable.shop2);
        arrayList.add(R.drawable.shop3);
        arrayList.add(R.drawable.shop2);
        arrayList.add( R.drawable.shop1);
        arrayList.add(R.drawable.shop2);
        arrayList.add(R.drawable.shop3);
        arrayList.add(R.drawable.shop2);
        arrayList.add(R.drawable.shop3);
        arrayList.add(R.drawable.shop3);
        arrayList.add(R.drawable.shop2);
        arrayList.add(R.drawable.shop3);

    }


    public static void shareshop(Context context,String shopname,String discount) throws FileNotFoundException {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        /*This will be the actual content you wish you share.*/
        String shareBody = "Buy Product from "+shopname+" and get "+discount+"\n"+"Address - Zone-2,M.p Nagar,462022,Bhopal"+"\n"+"For Shopping Download our app - https://play.google.com/store/apps/details?id="+context.getPackageName();
        /*The type of the content is text, obviously.*/
        intent.setType("text/plain");
        /*Applying information Subject and Body.*/
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share shop");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        context.startActivity(Intent.createChooser(intent, "Share via:"));

    }


}
