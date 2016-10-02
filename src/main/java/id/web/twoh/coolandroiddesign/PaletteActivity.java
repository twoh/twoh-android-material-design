package id.web.twoh.coolandroiddesign;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by Herdi_WORK on 18.09.16.
 */
public class PaletteActivity extends AppCompatActivity{

    private TextView vibrantView;
    private TextView vibrantLightView;
    private TextView vibrantDarkView;
    private TextView mutedView;
    private TextView mutedLightView;
    private TextView mutedDarkView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallete);

        initViews();
        paintTextBackground();
        setToolbar();

    }

    private void setToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("TWOH's Palette Tutorial");
    }

    private void initViews() {
        vibrantView = (TextView) findViewById(R.id.tvVibrant);
        vibrantLightView = (TextView) findViewById(R.id.tvVibrantLight);
        vibrantDarkView = (TextView) findViewById(R.id.tvVibrantDark);
        mutedView = (TextView) findViewById(R.id.tvMuted);
        mutedLightView = (TextView) findViewById(R.id.tvMutedLight);
        mutedDarkView = (TextView) findViewById(R.id.tvMutedDark);

    }

    private void paintTextBackground() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lena);

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
}
