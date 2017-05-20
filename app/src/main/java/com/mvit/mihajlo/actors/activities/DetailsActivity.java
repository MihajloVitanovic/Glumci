package com.mvit.mihajlo.actors.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mvit.mihajlo.actors.R;
import com.mvit.mihajlo.actors.providers.ActorProvider;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by androiddevelopment on 20.5.17..
 */

public class DetailsActivity extends AppCompatActivity {

    private int position = 0;

    OnItemSelectedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (savedInstanceState != null) {
            position = savedInstanceState.getInt("position", 0);
        }

        ImageView ivImage = (ImageView)findViewById(R.id.ivActorImage);
        InputStream is = null;
        try{
            is = getAssets().open(ActorProvider.getActorById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tvFirstName = (TextView)findViewById(R.id.tvActorFirstName);
        tvFirstName.setText(ActorProvider.getActorById(position).getFirstName());

        TextView tvLastName = (TextView)findViewById(R.id.tvActorLastName);
        tvLastName.setText(ActorProvider.getActorById(position).getLastName());

        TextView tvSummary = (TextView)findViewById(R.id.tvActorSummary);
        tvSummary.setText(ActorProvider.getActorById(position).getSummary());

        TextView tvActorYear = (TextView)findViewById(R.id.tvActorYear);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = ActorProvider.getActorById(position).getYear();
        tvActorYear.setText(sdf.format(date));

        RatingBar rbRating = (RatingBar) findViewById(R.id.rbActorRating);
        rbRating.setRating(ActorProvider.getActorById(position).getRating());


        // Loads actors from array resource
        final List<String> actorMovies = ActorProvider.getActorMovies();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, actorMovies);
        ListView listView = (ListView)findViewById(R.id.lvActorMovies);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);


    }

    // Container activity must implement this interface
    public interface OnItemSelectedListener {

        public void onItemSelected(int position);
    }

}
