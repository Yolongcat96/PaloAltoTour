package com.example.android.paloaltotour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class about extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // setup the back arrow function
        setBackArrowFunction();
    }

    // When clicking the backarrow button, it moves the user to the previous (main List) activity.
    public void setBackArrowFunction() {
        final ImageView backArrowIV = (ImageView) findViewById(R.id.backArrow);
        backArrowIV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}
