package com.example.android.miwok;

import java.util.ArrayList;

/**
 * Created by andif on 07/04/17.
 */

public class Word {

    // Default translation for the word
    private String mDefaultTranslation;
    // Miwok translation for the word
    private String mMiwokTranslation;

    ArrayList<String> default_words;
    ArrayList<String> miwok_words;

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
}
