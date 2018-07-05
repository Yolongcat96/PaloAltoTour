package com.example.android.paloaltotour;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class favoriteItemAdapter extends ArrayAdapter<listItemUnit> {

    public favoriteItemAdapter(Activity context, ArrayList<listItemUnit> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_listview, parent, false);
        }
        // get the link ite, object located at this position
        listItemUnit currentItem = getItem(position);
        Log.d("item adapter", "position " + position + ", name: " + currentItem.getItemName() + ", address: " + currentItem.getItemAddress());
        // Find the item name TextView in the item_list.xml layout with the ID textview
        TextView itemNameView = (TextView) listItemView.findViewById(R.id.itemTitle);
        // set the name on this textView
        itemNameView.setText(currentItem.getItemName());
        // Find the address text view in the item_list.xml layout with the ID textview
        TextView itemAddressView = (TextView) listItemView.findViewById(R.id.itemAddress);
        // set the address on this text view
        itemAddressView.setText(currentItem.getItemAddress());
        // Find the ImageView in the list_item.xml layout with the ID image.
        FrameLayout itemImageView = (FrameLayout) listItemView.findViewById(R.id.itemImageView);
        itemImageView.setBackground(getContext().getDrawable((itemUnitCollection.getInstance().getItemImage(currentItem.getCategoryName(), currentItem.getItemIndex()))));
        return listItemView;
    }

}
