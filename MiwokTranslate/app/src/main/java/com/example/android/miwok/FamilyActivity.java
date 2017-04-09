package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        // Create an ARRAY LIST of words using my custom class "Word"
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("father", "отец", "Vatter"));
        words.add(new Word("mother", "мама", "Mutter"));
        words.add(new Word("son", "сын", "Sohn"));
        words.add(new Word("daughter", "дочь", "Tochter"));
        words.add(new Word("older brother", "старший брат", "älterer Bruder"));
        words.add(new Word("younger brother","младший брат", "jüngerer Bruder"));
        words.add(new Word("older sister","старшая сестра", "ältere Schwester"));
        words.add(new Word("younger sister","младшая сестра", "jüngere Schwester"));
        words.add(new Word("grandmother", "бабушка", "Oma"));
        words.add(new Word("grandfather","дед", "Großvater"));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list item views for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words);

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
