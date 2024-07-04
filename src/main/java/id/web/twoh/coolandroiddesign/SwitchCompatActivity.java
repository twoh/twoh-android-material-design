package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Hafizh Herdi on 1/4/2017.
 */

public class SwitchCompatActivity extends BaseAdsActivity {

    private SwitchCompat switchCompat1;
    private SwitchCompat switchCompat2;
    private CompoundButton.OnCheckedChangeListener checkedChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_switch_view);
        switchCompat1 = findViewById(R.id.sw_button);
        switchCompat2 = findViewById(R.id.sw_button2);
        super.onCreate(savedInstanceState);
        setupToolbar();

        checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(SwitchCompatActivity.this,compoundButton.getText()+" is "+compoundButton.isChecked(),Toast.LENGTH_SHORT).show();
                decideToDisplay();
            }
        };

        switchCompat1.setOnCheckedChangeListener(checkedChangeListener);
        switchCompat2.setOnCheckedChangeListener(checkedChangeListener);

        Button btTutorial = findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(v -> {
            decideToDisplay();
            readTheTutorial(Const.TUTORIAL_SWITCHCOMPAT);
        });
        decideToDisplay();
    }


    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Switch Button Example");
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
