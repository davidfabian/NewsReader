package com.example.d.newsreader;

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

    //basic constructor
    public Article(String title, String section, String url) {
        String mTitle = title;
        String mSection = section;
        String mURL = url;
    }

    //title getter
    public String getmTitle() {
        return mTitle;
    }

    //section getter
    public String getmSection() {
        return mSection;
    }

    //URL getter
    public String getmURL() {
        return mURL;
    }

}

