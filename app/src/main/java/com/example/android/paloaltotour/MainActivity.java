package com.example.android.paloaltotour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // set click event on the START button
        setClickEvent4START();
        // read the data files to get item list
        receiveItemListDataFromFile();
    }

    // when click START button, it moves the user to the listview screen
    public void setClickEvent4START() {
        final Button startButton = (Button) findViewById(R.id.startButton);
        // call menu screen activity
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainListIntent = new Intent(getApplicationContext(), mainListActivity.class);
                startActivity(mainListIntent);
            }
        });

    }

    // receive all data for the item list: places, transportations, foods, and lodgins.
    private void receiveItemListDataFromFile() {
        // read json string to get the each song information
        String jsonString = loadJSONFromAsset("itemList.json");
        // save the song data to the songUnitCollection singleton
        saveItemList(jsonString);
    }

    // create the singleton to save item list
    private void saveItemList(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray proArray = obj.getJSONArray("List");
            for (int i = 0; i < proArray.length(); i++) {
                // receive the variables from the json file
                JSONObject object = proArray.getJSONObject(i);
                int mIndex = object.getInt("itemIndex");
                String mCategory = object.getString("itemCategory");
                String mName = object.getString("itemName");
                String mAddress = object.getString("itemAddress");
                String mSiteAddress = object.getString("itemSiteAddress");
                String mCallNumber = object.getString("itemCallNumber");
                String mDetail = object.getString("itemDetails");
                Boolean mIsFavorite = object.getBoolean("isFavorite");
                String mImageString = object.getString("imageString");
                // create the song unit
                listItemUnit liUnit = new listItemUnit();
                liUnit.listItemUnit(mCategory, mIndex, mName, mAddress, mSiteAddress, mCallNumber, mIsFavorite, mDetail, null, null, -1);
                Log.d("(***) data file", "Item category: " + mCategory + ", Item name:" + mName + ", item address: " + mAddress + ", isFavorite:" + mIsFavorite);
                // save song unit information at the listItemUnitCollection (singleton)
                itemUnitCollection.getInstance().addItem(liUnit);
            }

        } catch (Throwable t) {
            Log.e("Palo Alto Tour", "Could not parse malformed JSON: \"" + jsonString + "\"");
        }
    }

    private String loadJSONFromAsset(String fileName) {
        String json = null;
        try {
            InputStream is = getAssets().open(fileName);
            StringBuilder buf = new StringBuilder();
            BufferedReader in =
                    new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
            json = buf.toString();

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
