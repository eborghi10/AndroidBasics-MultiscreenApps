package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        // Create an ARRAY LIST of words using my custom class "Word"
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("red", "красный","rot", R.drawable.color_red, R.raw.ru_red, R.raw.de_red));
        words.add(new Word("green", "зеленый","grün", R.drawable.color_green, R.raw.ru_green, R.raw.de_green));
        words.add(new Word("brown", "коричневый","braun", R.drawable.color_brown, R.raw.ru_brown, R.raw.de_brown));
        words.add(new Word("gray", "серый","grau", R.drawable.color_gray, R.raw.ru_gray, R.raw.de_gray));
        words.add(new Word("black", "черный","schwarz", R.drawable.color_black, R.raw.ru_black, R.raw.de_black));
        words.add(new Word("white","белое","Weiß", R.drawable.color_white, R.raw.ru_white, R.raw.de_white));
        words.add(new Word("dusty yellow","пыльно-желтый","staubiges Gelb", R.drawable.color_dusty_yellow, R.raw.ru_dusty_yellow, R.raw.de_dusty_yellow));
        words.add(new Word("mustard yellow","горчично-желтый", "senfgelb", R.drawable.color_mustard_yellow, R.raw.ru_mustard_yellow, R.raw.de_mustard_yellow));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s.
        // The adapter knows how to create list item views for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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
