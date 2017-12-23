package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Hafizh Herdi on 4/17/2016.
 */
public class RefreshViewActivity extends BaseAdsActivity{

    SwipeRefreshLayout swLayout;
    LinearLayout llayout;
    TextView tvHello;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_refreshview);
        swLayout = (SwipeRefreshLayout) findViewById(R.id.swlayout);
        llayout = (LinearLayout) findViewById(R.id.ll_swiperefresh);
        tvHello = (TextView) findViewById(R.id.tv_helloworld);

        swLayout.setColorSchemeResources(R.color.twoh_accent,R.color.twoh_primary);
        swLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        swLayout.setRefreshing(false);
                        llayout.setBackground(ContextCompat.getDrawable(RefreshViewActivity.this, R.drawable.ic_bg_navview));
                        tvHello.setText("www.twoh.co");
                    }
                }, 3000);
                decideToDisplay();
            }
        });

        setupToolbar();
        super.onCreate(savedInstanceState);

        Button btTutorial = (Button) findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readTheTutorial(Const.TUTORIAL_REFRESH);
            }
        });
        decideToDisplay();
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Swipe Refresh Example");
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
