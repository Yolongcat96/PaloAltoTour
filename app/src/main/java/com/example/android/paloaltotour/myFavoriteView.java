package com.example.android.paloaltotour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class myFavoriteView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorite_view);
        // setup the back arrow function
        setBackArrowFunction();
        // show listview:choose favorite and create the list for favorite
        setListViews();

    }

    // When clicking the backarrow button, it moves the user to the previous (main List) activity.
    public void setBackArrowFunction() {
        final ImageView backArrowIV = (ImageView) findViewById(R.id.backArrow);
        backArrowIV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainListIntent = new Intent(getApplicationContext(), mainListActivity.class);
                startActivity(mainListIntent);
            }
        });
    }

    private void setListViews() {
        // adapter knows how to create list items for each item in the li
        ArrayList<listItemUnit> favoriteList = new ArrayList<listItemUnit>();
        for (int i = 0; i < itemUnitCollection.getInstance().itemList.size(); i++) {
            if (itemUnitCollection.getInstance().itemList.get(i).getIsFavorite() == true) {
                favoriteList.add(itemUnitCollection.getInstance().itemList.get(i));
            }
        }
        final favoriteItemAdapter adapter = new favoriteItemAdapter(this, favoriteList);
        ListView listView = (ListView) findViewById(R.id.favorite_item_list);
        listView.setAdapter(adapter);
        // When clicking the one item of the list, it calls the new activity (play music activity)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listItemUnit sUnit = (listItemUnit) adapter.getItem(position);
                // call the item detail view based on the clicked information
                Intent itemDetailedViewIntent = new Intent(getApplicationContext(), itemDetailView.class);
                itemDetailedViewIntent.putExtra("itemName", sUnit.getItemName());
                startActivity(itemDetailedViewIntent);
            }
        });

    }

}
