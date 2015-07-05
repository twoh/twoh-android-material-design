package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Hafizh Herdi on 7/2/2015 www.twoh.co
 */
public class FloatingActionButtonActivity extends AppCompatActivity{

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.ly_fab), "This is Snackbar", Snackbar.LENGTH_LONG).setAction("Action", this).show();
            }
        });
    }



}
