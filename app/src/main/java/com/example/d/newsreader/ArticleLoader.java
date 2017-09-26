package com.example.d.newsreader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by d on 9/26/2017.
 */

public class ArticleLoader extends AsyncTaskLoader {
    private String LOG_TAG = ArticleLoader.class.getName();

    public ArticleLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        List<Article> articles = QueryUtils.extractArticles();
        return articles;
    }
}
