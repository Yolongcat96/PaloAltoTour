package com.example.android.paloaltotour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class itemDetailView extends AppCompatActivity {

    // define variables
    private listItemUnit currUnit;
    private String curItemName;
    private FrameLayout curItemImage;
    private TextView curItemNameView;
    private TextView curItemAddressView;
    private LinearLayout currItemDetailEx;
    private TextView curItemDetails;

    private RelativeLayout curSiteLayout;
    private RelativeLayout curCallNumberLayout;
    private RelativeLayout curAddressLayout;
    private ImageView currFavoriteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail_view);
        // get data from the previous segment
        getDataFromPreSegment();
        // set the background
        setBackGround();
        // set item image and information
        setInformation();
        // set back arrow button to go back to main list
        setBackArrowFunction();
        // set favorite icon
        setFavoriteIcon();
    }

    private void getDataFromPreSegment() {
        Intent currIntent = getIntent();
        if (currIntent != null) {
            // get an item name
            curItemName = currIntent.getStringExtra("itemName");

        }
    }

    private void setBackGround() {
        currUnit = itemUnitCollection.getInstance().getItemUnit(curItemName);
        LinearLayout currMainLayout = (LinearLayout) findViewById(R.id.itemDetailLayout);
        currMainLayout.setBackgroundResource(itemUnitCollection.getInstance().getBackgroundColorWithName(curItemName));

    }

    private void setInformation() {
        // 1. set item image
        curItemImage = (FrameLayout) findViewById(R.id.itemImage);
        curItemImage.setBackground(getResources().getDrawable(itemUnitCollection.getInstance().getItemImage(currUnit.getCategoryName(), currUnit.getItemIndex())));
        // 2. set item name
        curItemNameView = (findViewById(R.id.itemNameView));
        curItemNameView.setText(currUnit.getItemName());
        // 3. set item address
        curItemAddressView = (findViewById(R.id.itemAddressView));
        curItemAddressView.setText(currUnit.getItemAddress());
        // 4. detail information layout
        currItemDetailEx = (LinearLayout) findViewById(R.id.itemDetailEx);
        currItemDetailEx.setBackgroundColor(getResources().getColor(R.color.main_background));
        // 5. Set the detailed information about the chosen item
        // 1) site address information
        curItemDetails = (TextView) findViewById(R.id.itemDetails);
        curItemDetails.setText(currUnit.getItemDetails());
        curSiteLayout = (RelativeLayout) findViewById(R.id.siteAddressLayout);
        ImageView siteIcon = (ImageView) findViewById(R.id.siteIcon);
        siteIcon.setImageResource(R.drawable.site_address_icon);
        TextView siteTextView = (TextView) findViewById(R.id.siteText);
        siteTextView.setText(currUnit.getItemSiteAddress());
        // 2) site call number information
        curCallNumberLayout = (RelativeLayout) findViewById(R.id.callNumberLayout);
        ImageView callNumberIcon = (ImageView) findViewById(R.id.callNumberIcon);
        callNumberIcon.setImageResource(R.drawable.phone_icon);
        TextView callNumberText = (TextView) findViewById(R.id.callNumberText);
        callNumberText.setText(currUnit.getItemCallNumber());
        // 3) item actual address information
        curAddressLayout = (RelativeLayout) findViewById(R.id.addressLayout);
        ImageView addressIcon = (ImageView) findViewById(R.id.addressIcon);
        addressIcon.setImageResource(R.drawable.address_icon);
        TextView addressText = (TextView) findViewById(R.id.addressText);
        addressText.setText(currUnit.getItemAddress());

    }

    // When clicking the backarrow button, it moves the user to the previous (main List) activity.
    public void setBackArrowFunction() {
        final ImageView backArrowIV = (ImageView) findViewById(R.id.goback);
        backArrowIV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setFavoriteIcon() {
        // set the imaged based on the current information
        currFavoriteView = (ImageView) findViewById(R.id.isfavorite);
        if (currUnit.getIsFavorite()) {
            currFavoriteView.setImageResource(R.drawable.on_favorite);
        } else {
            currFavoriteView.setImageResource(R.drawable.off_favorite);
        }
        currFavoriteView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (currUnit.getIsFavorite()) {
                    currUnit.setIsFavorite(false);
                    currFavoriteView.setImageResource(R.drawable.off_favorite);
                } else {
                    currUnit.setIsFavorite(true);
                    currFavoriteView.setImageResource(R.drawable.on_favorite);
                }

            }
        });

    }


}
