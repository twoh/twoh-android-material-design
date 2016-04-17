package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Hafizh Herdi on 4/17/2016.
 */
public class RefreshViewActivity extends AppCompatActivity{

    SwipeRefreshLayout swLayout;
    LinearLayout llayout;
    TextView tvHello;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                }, 5000);
            }
        });
    }
}
