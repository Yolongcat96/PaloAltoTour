package com.example.android.paloaltotour;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class listItemUnitAdapter extends ArrayAdapter<listItemUnit> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    ImageView favoriteImageView;
    boolean isShowFavorite;

    public listItemUnitAdapter(Activity context, ArrayList<listItemUnit> items, int colorResourceID) {
        super(context, 0, items);
        mColorResourceId = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }
        // get the link ite, object located at this position
        listItemUnit currentItem = getItem(position);
        Log.d("item adapter", "position " + position + ", name: " + currentItem.getItemName() + ", address: " + currentItem.getItemAddress());
        // Find the item name TextView in the item_list.xml layout with the ID textview
        TextView nameView = (TextView) listItemView.findViewById(R.id.item_name);
        // set the name on this textView
        nameView.setText(currentItem.getItemName());
        // Find the address text view in the item_list.xml layout with the ID textview
        TextView addressView = (TextView) listItemView.findViewById(R.id.item_address);
        // set the address on this text view
        addressView.setText(currentItem.getItemAddress());
        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView thumbnailView = (ImageView) listItemView.findViewById(R.id.item_thumbnail);
        thumbnailView.setImageResource(currentItem.getmImageResourceId());
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        return listItemView;
    }

    public void setShowHideFavoriteIV(boolean show) {
        this.isShowFavorite = show;
    }
}