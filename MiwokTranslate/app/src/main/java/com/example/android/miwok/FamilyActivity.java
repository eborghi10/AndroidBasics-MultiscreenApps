package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        // Create an ARRAY LIST of words using my custom class "Word"
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("father", "отец", "Vatter", R.drawable.family_father, R.raw.ru_father, R.raw.de_father));
        words.add(new Word("mother", "мама", "Mutter", R.drawable.family_mother, R.raw.ru_mother, R.raw.de_mother));
        words.add(new Word("son", "сын", "Sohn", R.drawable.family_son, R.raw.ru_son, R.raw.de_son));
        words.add(new Word("daughter", "дочь", "Tochter", R.drawable.family_daughter, R.raw.ru_daughter, R.raw.de_daughter));
        words.add(new Word("older brother", "старший брат", "älterer Bruder", R.drawable.family_older_brother, R.raw.ru_older_brother, R.raw.de_older_brother));
        words.add(new Word("younger brother","младший брат", "jüngerer Bruder", R.drawable.family_younger_brother, R.raw.ru_younger_brother, R.raw.de_younger_brother));
        words.add(new Word("older sister","старшая сестра", "ältere Schwester", R.drawable.family_older_sister, R.raw.ru_older_sister, R.raw.de_older_sister));
        words.add(new Word("younger sister","младшая сестра", "jüngere Schwester", R.drawable.family_younger_sister, R.raw.ru_younger_sister, R.raw.de_younger_sister));
        words.add(new Word("grandmother", "бабушка", "Oma", R.drawable.family_grandmother, R.raw.ru_grandmother, R.raw.de_grandmother));
        words.add(new Word("grandfather","дед", "Großvater", R.drawable.family_grandfather, R.raw.ru_grandfather, R.raw.de_grandfather));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list item views for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);

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
