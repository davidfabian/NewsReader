package com.example.d.newsreader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static final int NEWS_LOADER_ID = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private String statusmessage;
    private ArticleAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            statusmessage = getString(R.string.loading);
        } else {
            statusmessage = getString(R.string.nointernet);
        }
        ListView articleListView = (ListView) findViewById(R.id.list);

        mAdapter = new ArticleAdapter(this, QueryUtils.extractArticles());

        articleListView.setAdapter(mAdapter);



    }
}
