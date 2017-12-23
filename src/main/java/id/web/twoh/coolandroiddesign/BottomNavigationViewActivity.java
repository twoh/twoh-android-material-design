package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by Hafizh Herdi on 3/5/2017.
 */

public class BottomNavigationViewActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

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

        super.onCreate(savedInstanceState);
    }

}
