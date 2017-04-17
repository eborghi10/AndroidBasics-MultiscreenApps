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
    private int mRussianAudio;
    private int mGermanAudio;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String russianTranslation,
                String germanTranslation, int imageID, int russianAudio, int germanAudio) {

        this(defaultTranslation, russianTranslation, germanTranslation, russianAudio, germanAudio);
        mImageResourceId = imageID;
    }

    public Word(String defaultTranslation, String russianTranslation, String germanTranslation,
                int russianAudio, int germanAudio) {
        mDefaultTranslation = defaultTranslation;
        mRussianTranslation = russianTranslation;
        mGermanTranslation = germanTranslation;
        mRussianAudio = russianAudio;
        mGermanAudio = germanAudio;
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

    public int getRussianAudio() {
        return mRussianAudio;
    }

    public int getGermanAudio() {
        return mGermanAudio;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
