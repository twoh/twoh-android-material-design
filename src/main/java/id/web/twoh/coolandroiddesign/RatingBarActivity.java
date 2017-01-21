package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Hafizh Herdi on 1/16/2017.
 */

public class RatingBarActivity extends BaseAdsActivity {

    private AppCompatRatingBar ratingBar;
    private Button btRating;
    private TextView tvRating;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_rating_bar);

        ratingBar = (AppCompatRatingBar) findViewById(R.id.rt_bar);
        btRating = (Button) findViewById(R.id.bt_submit);
        tvRating = (TextView) findViewById(R.id.tv_rate);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvRating.setText("Rate : "+rating);
            }
        });

        btRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingBarActivity.this," Rating "+ratingBar.getRating(), Toast.LENGTH_SHORT).show();
                decideToDisplay();
            }
        });

        super.onCreate(savedInstanceState);

        setToolbar();

        Button btTutorial = (Button) findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decideToDisplay();
                readTheTutorial(Const.TUTORIAL_RATINGBAR);
            }
        });
        decideToDisplay();
    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Rating Bar Tutorial");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }

        return true;
    }
}
