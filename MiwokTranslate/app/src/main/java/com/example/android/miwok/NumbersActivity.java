package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        // Create an ARRAY LIST of words using my custom class "Word"
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("one", "один", "eins", R.drawable.number_one));
        words.add(new Word("two", "два", "zwei", R.drawable.number_two));
        words.add(new Word("three", "три", "drei", R.drawable.number_three));
        words.add(new Word("four", "четыре", "vier", R.drawable.number_four));
        words.add(new Word("five", "пять", "fünf", R.drawable.number_five));
        words.add(new Word("six","шесть", "sechs", R.drawable.number_six));
        words.add(new Word("seven","семь", "sieben", R.drawable.number_seven));
        words.add(new Word("eight","восемь", "acht", R.drawable.number_eight));
        words.add(new Word("nine","девять", "neun", R.drawable.number_nine));
        words.add(new Word("ten","десять", "zehn", R.drawable.number_ten));

        /*
        // Logging messages with Android Monitor
        int i = -1;
        for (String w:words) {
            Log.v("Numbers Activity", "Word at index " + ++i + " : " + w);
        }
        */

        /*
        // Adding textViews to the LinearLayout (not using XML)
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        for (String w:words) {

            TextView wordView = new TextView(this); // Requires the current context as argument (class)
            wordView.setText(w);
            rootView.addView(wordView); // Add a child (wordView) to the parent view (rootView)
        }
        */

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        /**
         * First argument: Context -> class NumbersActivity (this)
         * We need that because we are creating views
         */
        //ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        // I'll use my custom layout file with my custom class "Word"
        //ArrayAdapter<Word> itemsAdapter = new ArrayAdapter<>(this, R.layout.list_item, words);
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        /**
         * Creates a ListView with items to display them on the ListView layout.
         *
         */
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        //listView.setAdapter(itemsAdapter);
        listView.setAdapter(adapter);
    }
}
