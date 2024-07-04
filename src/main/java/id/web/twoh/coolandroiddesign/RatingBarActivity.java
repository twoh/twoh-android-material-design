package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

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

        ratingBar =findViewById(R.id.rt_bar);
        btRating = findViewById(R.id.bt_submit);
        tvRating = findViewById(R.id.tv_rate);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> tvRating.setText("Rate : "+rating));

        btRating.setOnClickListener(v -> {
            Toast.makeText(RatingBarActivity.this," Rating "+ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            decideToDisplay();
        });

        super.onCreate(savedInstanceState);

        setToolbar();

        Button btTutorial = findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(v -> {
            decideToDisplay();
            readTheTutorial(Const.TUTORIAL_RATINGBAR);
        });
        decideToDisplay();
    }

    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
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
