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

    public String getmGermanTranslation() {
        return mGermanTranslation;
    }
}
