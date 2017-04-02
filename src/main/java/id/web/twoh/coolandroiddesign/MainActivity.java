package id.web.twoh.coolandroiddesign;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.text.util.LinkifyCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseAdsActivity {

    private Button btFab;
    private Button btTil;
    private Button btNav;
    private Button btTab;
    private Button btAppBar;
    private Button collapseTool;
    private Button refreshViewBut;
    private Button btRecyclerView;
    private Button btPallete;
    private Button btSwitch;
    private Button btRipple;
    private Button btRatingBar;
    private Button btNavBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setupToolbar();
        btFab = (Button) findViewById(R.id.bt_fab);
        btFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, FloatingActionButtonActivity.class));
            }
        });

        btTil = (Button) findViewById(R.id.bt_til);
        btTil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, TextInputActivity.class));
            }
        });

        btNav = (Button) findViewById(R.id.bt_nav_view);
        btNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, NavigationViewActivity.class));
            }
        });

        btAppBar = (Button) findViewById(R.id.bt_appcontainer);
        btAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, AppContainerTabActivity.class));
            }
        });

        btTab = (Button) findViewById(R.id.bt_tab);
        btTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
            }
        });

        collapseTool = (Button) findViewById(R.id.bt_coll);
        collapseTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, CollapsingToolbarActivity.class));
            }
        });

        refreshViewBut = (Button) findViewById(R.id.bt_refreshview);
        refreshViewBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this,RefreshViewActivity.class));
            }
        });

        btRecyclerView = (Button) findViewById(R.id.bt_recview);
        btRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
            }
        });

        btPallete = (Button) findViewById(R.id.bt_pallete);
        btPallete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, PaletteActivity.class));
            }
        });

        btSwitch = (Button) findViewById(R.id.bt_switch);
        btSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, SwitchCompatActivity.class));
            }
        });

        btRipple = (Button) findViewById(R.id.bt_ripple);
        btRipple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, RippleEffectActivity.class));
            }
        });

        btRatingBar = (Button) findViewById(R.id.bt_ratingbar);
        btRatingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, RatingBarActivity.class));
            }
        });

        btNavBottom = (Button) findViewById(R.id.bt_bottomnav);
        btNavBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decideToDisplay();
                startActivity(new Intent(MainActivity.this, BottomNavigationViewActivity.class));
            }
        });
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            open();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void open(){


        SpannableString str = new SpannableString("Copyright © : TWOh's Engineering " +
                "\nTutorial lengkap di http://www.twoh.co/mudengdroid-belajar-android-bersama-twohs-engineering/android-design-tutorial/");
        LinkifyCompat.addLinks(str, Linkify.WEB_URLS);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(str);
                alertDialogBuilder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                arg0.dismiss();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
