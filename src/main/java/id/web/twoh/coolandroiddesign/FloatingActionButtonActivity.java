package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Hafizh Herdi on 7/2/2015 www.twoh.co
 */
public class FloatingActionButtonActivity extends BaseAdsActivity{

    private FloatingActionButton fab;
    private Button btTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_fab);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.ly_fab), "Contoh sebuah Snackbar", Snackbar.LENGTH_LONG).setAction("Click me!", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        decideToDisplay();
                    }
                }).show();
            }
        });

        btTutorial = findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(v -> readTheTutorial(Const.TUTORIAL_FAB));

        setupToolbar();
        super.onCreate(savedInstanceState);
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Floating Action Button Example");
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
