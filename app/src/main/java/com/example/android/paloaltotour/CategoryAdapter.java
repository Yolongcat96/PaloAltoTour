package com.example.android.paloaltotour;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;
    private int numOfCategory = 4;

    // create a new categoryadapter object.
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // return the fragment that should be shown for the given page number
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new PlacesFragment();
        } else if (position == 1) {
            return new TransportationFragment();
        } else if (position == 2) {
            return new FoodFragment();
        } else {
            return new LodgingsFragment();
        }

    }

    @Override
    public int getCount() {
        return numOfCategory;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_places);
        } else if (position == 1) {
            return mContext.getString(R.string.category_transportations);
        } else if (position == 2) {
            return mContext.getString(R.string.category_foods);
        } else {
            return mContext.getString(R.string.category_lodgings);
        }
    }
}
