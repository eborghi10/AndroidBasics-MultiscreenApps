package com.example.android.miwok;

import java.util.ArrayList;

/**
 * Created by andif on 07/04/17.
 */

public class Word {

    // Default translation for the word
    private String mDefaultTranslation;
    // Translations for the word
    private String mRussianTranslation;
    private String mGermanTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String russianTranslation,
                String germanTranslation, int imageID) {

        this(defaultTranslation, russianTranslation, germanTranslation);
        mImageResourceId = imageID;
    }

    public Word(String defaultTranslation, String russianTranslation, String germanTranslation) {
        mDefaultTranslation = defaultTranslation;
        mRussianTranslation = russianTranslation;
        mGermanTranslation = germanTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getRussianTranslation() {
        return mRussianTranslation;
    }

    public String getGermanTranslation() {
        return mGermanTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
