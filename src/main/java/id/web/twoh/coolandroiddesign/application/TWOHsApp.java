package id.web.twoh.coolandroiddesign.application;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.Arrays;

/**
 * Created by Hafizh Herdi on 10/3/2016.
 */

public class TWOHsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RequestConfiguration config = new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("B26F691B4FCC8E079BE566B04FE7701C")).build();
        MobileAds.setRequestConfiguration(config);
        new Thread(
                () -> {
                    // Initialize the Google Mobile Ads SDK on a background thread.
                    MobileAds.initialize(this, initializationStatus -> {
                    });
                })
                .start();
    }
}
