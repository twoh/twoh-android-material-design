package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Hafizh Herdi on 3/5/2017.
 */

    public class BottomNavigationViewActivity extends BaseAdsActivity {

    private BottomNavigationView bottomNavigationView;
    private Button btTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_bottom_nav_view);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.btm_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.action_home :
                        Toast.makeText(BottomNavigationViewActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_star :
                        Toast.makeText(BottomNavigationViewActivity.this, "Star clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_money :
                        Toast.makeText(BottomNavigationViewActivity.this, "Money clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });

        btTutorial = (Button) findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readTheTutorial(Const.TUTORIAL_BOTTOMNAVVIEW);
            }
        });

        setupToolbar();
        super.onCreate(savedInstanceState);
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
