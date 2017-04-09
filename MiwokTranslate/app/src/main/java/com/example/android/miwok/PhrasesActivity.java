package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        // Create an ARRAY LIST of words using my custom class "Word"
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Where are you going?", "Куда ты идешь?", "Wohin gehst du?"));
        words.add(new Word("What is your name?", "Как вас зовут?", "Wie heißt du?"));
        words.add(new Word("My name is...", "Меня зовут...", "Ich heiße..."));
        words.add(new Word("How are you feeling?", "как ты себя чувствуешь?", "Wie fühlst du dich?"));
        words.add(new Word("I'm feeling good.", "мне хорошо.", "Ich fühle mich gut."));
        words.add(new Word("Are you coming?","ты идешь?", "Kommst du?"));
        words.add(new Word("Yes, I'm coming.","Да, я иду.", "Ja, ich komme."));
        words.add(new Word("Let's go.","Пойдем.", "Lass uns gehen."));
        words.add(new Word("Come here.","Иди сюда.", "Komm her."));


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
