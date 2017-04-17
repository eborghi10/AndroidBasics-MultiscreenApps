package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by emiliano on 09/04/17.
 *
 * CUSTOM ArrayAdapter:
 * - This class is need to avoid the error of the ArrayAdapter class.
 *
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceID;

    private ImageButton mRussianPlayButton;
    private ImageButton mGermanPlayButton;
    private MediaPlayer mMediaPlayer;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of Word objects to display in a list
     */

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceID = colorResourceID;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the String from the current Word object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        TextView russianTextView = (TextView) listItemView.findViewById(R.id.russian_text_view);
        russianTextView.setText(currentWord.getRussianTranslation());

        TextView germanTextView = (TextView) listItemView.findViewById(R.id.german_text_view);
        germanTextView.setText(currentWord.getGermanTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        if (currentWord.hasImage()) {

            // Get the image resource ID from the current Word object and
            // set the image to iconView
            iconView.setImageResource(currentWord.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);

        } else {
            iconView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        // Set the background color for the textContainer view
        textContainer.setBackgroundColor(color);

        mRussianPlayButton = (ImageButton) listItemView.findViewById(R.id.play_russian);
        mRussianPlayButton.setBackgroundColor(color);
        mGermanPlayButton = (ImageButton) listItemView.findViewById(R.id.play_german);
        mGermanPlayButton.setBackgroundColor(color);

        mRussianPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMediaPlayer = MediaPlayer.create(getContext(), currentWord.getRussianAudio());
                mMediaPlayer.start();
            }
        });

        mGermanPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMediaPlayer = MediaPlayer.create(getContext(), currentWord.getGermanAudio());
                mMediaPlayer.start();
            }
        });

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
