package com.example.d.newsreader;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by d on 9/22/2017.
 * Adapter to connect the data and the user interface
 */

public class ArticleAdapter extends ArrayAdapter<Article> {
    private static final String LOG_TAG = ArticleAdapter.class.getSimpleName();

    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for three TextViews, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.
    public ArticleAdapter(@NonNull Activity context, List<Article> articles) {
        super(context, 0, articles);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Article currentArticle = getItem(position);

        //inflate
        TextView sectionTextView = listItemView.findViewById(R.id.section_textview);
        sectionTextView.setText(currentArticle.getmSection());


        TextView dateTextView = listItemView.findViewById(R.id.date_textview);
        dateTextView.setText(currentArticle.getmDate());

        TextView titleTextView = listItemView.findViewById(R.id.title_textview);
        titleTextView.setText(currentArticle.getmTitle());

        return listItemView;
    }
}

