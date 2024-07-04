package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Hafizh Herdi on 7/23/2015.
 */
public class NavigationViewActivity extends BaseAdsActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        setupToolbar();
        navView = findViewById(R.id.navigation);
        navView.setNavigationItemSelectedListener(menuItem -> {
            if(menuItem.isChecked())
                menuItem.setChecked(false);
            else
                menuItem.setChecked(true);

            drawerLayout.closeDrawers();

            switch (menuItem.getItemId()){

                case R.id.nav_home:
                    decideToDisplay();
                    Toast.makeText(NavigationViewActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.nav_my_profile:
                    decideToDisplay();
                    Toast.makeText(NavigationViewActivity.this, "My profile clicked", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.nav_settings:
                    decideToDisplay();
                    Toast.makeText(NavigationViewActivity.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                    return true;

            }
            return true;
        });
        super.onCreate(savedInstanceState);

        Button btTutorial = findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decideToDisplay();
                readTheTutorial(Const.TUTORIAL_NAV);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar()
    {
        toolbar = findViewById(R.id.toolbar);

        // set toolbar ke dalam support action bar
        setSupportActionBar(toolbar);

        // mengeset icon untuk home button Toolbar
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        // mengeset title/nama aplikasi
        getSupportActionBar().setTitle("TWOH's Engineering");

        // mengeset subtitle
        getSupportActionBar().setSubtitle("Tutorial Material Design");

        // set logo toolbar
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
