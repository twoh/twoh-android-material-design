package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
        swLayout = findViewById(R.id.swlayout);
        llayout = findViewById(R.id.ll_swiperefresh);
        tvHello = findViewById(R.id.tv_helloworld);

        swLayout.setColorSchemeResources(R.color.twoh_accent,R.color.twoh_primary);
        swLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        swLayout.setRefreshing(false);
                        llayout.setBackground(ContextCompat.getDrawable(RefreshViewActivity.this, R.drawable.bg_navview));
                        tvHello.setText("www.twoh.co");
                    }
                }, 3000);
                decideToDisplay();
            }
        });

        setupToolbar();
        super.onCreate(savedInstanceState);

        Button btTutorial = findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(v -> readTheTutorial(Const.TUTORIAL_REFRESH));
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
