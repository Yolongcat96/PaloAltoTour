package com.example.android.paloaltotour;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class mainListActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ImageView settingImageView;

    private int[] tabIcons = {
            R.drawable.places_icon,
            R.drawable.transportations_icon,
            R.drawable.foods_icon,
            R.drawable.lodgings_icon
    };

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use activity_main_list.xml layout file
        setContentView(R.layout.activity_main_list);
        // Add drawer menu
        setDraweLayout();
        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        // set the adapter onto the view manager
        viewPager.setAdapter(adapter);
        // Find the tab layout that shows tabs
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        // Connect the tab layout with the view manager
        tabLayout.setupWithViewPager(viewPager);
        // add icons to each tab
        setupTabIcons();
        // add background image to each tab
        setupTabBackgroundImages();
        // add setting menu
        setupSettigs();
    }

    private void setDraweLayout() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setBackgroundColor(getResources().getColor(R.color.buttonColor));
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();
                        int id = menuItem.getItemId();
                        if (id == R.id.nav_about) {
                            callAboutActivity();
                        } else if (id == R.id.nav_favorite) {
                            callMyFavoritesActivity();
                        } else { // exit
                            exitFromApp();
                        }
                        return true;
                    }
                });

    }


    private void callAboutActivity() {
        Log.d("main_list", "About Palo Alto");
        Intent aboutIntent = new Intent(getApplicationContext(), about.class);
        startActivity(aboutIntent);
    }

    private void callMyFavoritesActivity() {
        Log.d("main_list", "My Favorites");
        Intent myFavoriteIntent = new Intent(getApplicationContext(), myFavoriteView.class);
        startActivity(myFavoriteIntent);
    }

    private void exitFromApp() {
        Log.d("main_list", "exit from the app");
        finishAffinity();
        System.exit(0);
    }

    public void setupSettigs() {
        settingImageView = (ImageView) findViewById(R.id.settings);
        settingImageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });
    }

    // setup different background color(image) per each tab
    private void setupTabBackgroundImages() {
        LinearLayout tabsContainer = (LinearLayout) tabLayout.getChildAt(0);
        LinearLayout childLayout1 = (LinearLayout) tabsContainer.getChildAt(0);
        LinearLayout childLayout2 = (LinearLayout) tabsContainer.getChildAt(1);
        LinearLayout childLayout3 = (LinearLayout) tabsContainer.getChildAt(2);
        LinearLayout childLayout4 = (LinearLayout) tabsContainer.getChildAt(3);
        // The first tab: places
        LinearLayout tabView = (LinearLayout) childLayout1.getChildAt(0).getParent();
        tabView.setBackgroundResource(R.drawable.places_back);
        // The second tab: transporations
        tabView = (LinearLayout) childLayout2.getChildAt(0).getParent();
        tabView.setBackgroundResource(R.drawable.transportations_back);
        // The third tab: foods
        tabView = (LinearLayout) childLayout3.getChildAt(0).getParent();
        tabView.setBackgroundResource(R.drawable.foods_back);
        // The fourth tab: lodgings
        tabView = (LinearLayout) childLayout4.getChildAt(0).getParent();
        tabView.setBackgroundResource(R.drawable.lodgings_back);

    }

    // setup icons for each category: places, transportations, foods, and lodgings
    private void setupTabIcons() {
        for (int i = 0; i < 4; i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }

}
