package com.pluralsight.candycoded;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Uri uri = Uri.parse("android.resource://com.codeschool.candycoded/" + R.drawable.store_front);
        ImageView candyStoreImageView = (ImageView) findViewById(R.id.image_view_candy_store);
        Picasso.with(this).
                load(uri).
                into(candyStoreImageView);


    }

    // ***
    // TODO - Task 2 - Launch the Google Maps Activity
    // ***
    //create a method called public void createMapIntent(View view). This is the method we'll attach to the Click Listener on the TextView.
    public void createMapIntent(View view) {
        //Create a Uri for the Address from an Intent String. Use the result to create an Intent.
        Uri uriAddress = Uri.parse("geo:0,0?q=618 E South St Orlando, FL 32801");
        //Create an Intent from uriAddress. Set the action to ACTION_VIEW Intent
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriAddress);
        //Set the Intent package. Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
        //Attempt to start an Activity that can handle the Intent
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    // ***
    // TODO - Task 3 - Launch the Phone Activity
    // ***
    //create a method called public void createPhoneIntent(View view). This is the method we'll attach to the Click Listener on the TextView.
    public void createPhoneIntent(View view) {
        //Create an Intent with action Intent.ACTION_DIAL.
        Intent actionPhoneIntent = new Intent(Intent.ACTION_DIAL);
        //Use the Intent setData() method and pass in a URI of the telephone number "tel:0123456789". You can create a URI with the Uri.parse() method.
        Uri telephoneNumber = Uri.parse("tel:0123456789");
        actionPhoneIntent.setData(telephoneNumber);
        //Start the Activity with the Intent.
        startActivity(actionPhoneIntent);
        //Create TextView Click Handler
        //connect this method to the button click. Go into activity_info.xml and add the following properties to the TextView with the id text_view_phone - android:clickable="true" and android:onClick="createPhoneIntent".

    }
}
