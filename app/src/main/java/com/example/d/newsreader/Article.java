package com.example.d.newsreader;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by d on 9/22/2017.
 * news article class, to store individual news articles/details as objects.
 */

public class Article {

    private static final String LOG_TAG = Article.class.getSimpleName();

    //variables to store
    private String mTitle;
    private String mSection;
    private String mURL;
    private String mAuthor;
    private String mDate;

    //basic constructor
    public Article(String title, String section, String url, String date) {
        mTitle = title;
        mSection = section;
        mURL = url;
        mDate = date;
    }

    //title getter
    String getmTitle() {
        return mTitle;
    }

    //section getter
    String getmSection() {
        return mSection;
    }

    //URL getter
    String getmURL() {
        return mURL;
    }

    //Author getter
    String getmAuthor() {
        return mAuthor;
    }

    //Date getter
    String getmDate() {
        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat shortDate = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate;
        try {
            formattedDate = shortDate.format(utcFormat.parse(mDate));
        } catch (ParseException e) {
            Log.e("parse problem", "date" + e);
            formattedDate = "N/A";
        }
        return formattedDate;
    }

}

