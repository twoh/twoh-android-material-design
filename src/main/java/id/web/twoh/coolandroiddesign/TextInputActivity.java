package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Hafizh Herdi on 7/9/2015.
 */
public class TextInputActivity extends BaseAdsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_textinput);

        // findview toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // set toolbar ke dalam support action bar
        setSupportActionBar(toolbar);

        // enable home button untuk navigasi
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // mengeset title/nama aplikasi
        getSupportActionBar().setTitle("TWOH's Engineering");

        // mengeset subtitle
        getSupportActionBar().setSubtitle("Tutorial TextInputLayout");

        // set logo toolbar
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        super.onCreate(savedInstanceState);

        Button btTutorial = (Button) findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decideToDisplay();
                readTheTutorial(Const.TUTORIAL_TIL);
            }
        });
        decideToDisplay();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
