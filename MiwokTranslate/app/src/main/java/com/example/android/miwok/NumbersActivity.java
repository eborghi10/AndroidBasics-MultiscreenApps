package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an ARRAY LIST of words
        ArrayList<String> words = new ArrayList<>();

        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        /*
        // Logging messages with Android Monitor
        int i = -1;
        for (String w:words) {
            Log.v("Numbers Activity", "Word at index " + ++i + " : " + w);
        }
        */

        // Adding textViews to the LinearLayout (not using XML)
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        for (String w:words) {

            TextView wordView = new TextView(this); // Requires the current context as argument (class)
            wordView.setText(w);
            rootView.addView(wordView); // Add a child (wordView) to the parent view (rootView)
        }
    }
}
