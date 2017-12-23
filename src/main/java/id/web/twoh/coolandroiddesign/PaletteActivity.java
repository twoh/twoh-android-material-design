package id.web.twoh.coolandroiddesign;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.web.twoh.coolandroiddesign.utils.Const;

/**
 * Created by Herdi_WORK on 18.09.16.
 */
public class PaletteActivity extends BaseAdsActivity{

    private TextView vibrantView;
    private TextView vibrantLightView;
    private TextView vibrantDarkView;
    private TextView mutedView;
    private TextView mutedLightView;
    private TextView mutedDarkView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_pallete);
        super.onCreate(savedInstanceState);
        initViews();
        paintTextBackground();
        setupToolbar();
        decideToDisplay();
    }

    private void initViews() {
        vibrantView = (TextView) findViewById(R.id.tvVibrant);
        vibrantLightView = (TextView) findViewById(R.id.tvVibrantLight);
        vibrantDarkView = (TextView) findViewById(R.id.tvVibrantDark);
        mutedView = (TextView) findViewById(R.id.tvMuted);
        mutedLightView = (TextView) findViewById(R.id.tvMutedLight);
        mutedDarkView = (TextView) findViewById(R.id.tvMutedDark);
        Button btTutorial = (Button) findViewById(R.id.bt_tutorial);
        btTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readTheTutorial(Const.TUTORIAL_PALETTE);
            }
        });
    }

    private void paintTextBackground() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.face2);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // ambil warna dari gambar menggunakan Palette
                int defaultValue = 0x000000;
                int vibrant = palette.getVibrantColor(defaultValue);
                int vibrantLight = palette.getLightVibrantColor(defaultValue);
                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
                int muted = palette.getMutedColor(defaultValue);
                int mutedLight = palette.getLightMutedColor(defaultValue);
                int mutedDark = palette.getDarkMutedColor(defaultValue);

                vibrantView.setBackgroundColor(vibrant);
                vibrantLightView.setBackgroundColor(vibrantLight);
                vibrantDarkView.setBackgroundColor(vibrantDark);
                mutedView.setBackgroundColor(muted);
                mutedLightView.setBackgroundColor(mutedLight);
                mutedDarkView.setBackgroundColor(mutedDark);
            }
        });


    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("TWOH's Palette View Example");
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
