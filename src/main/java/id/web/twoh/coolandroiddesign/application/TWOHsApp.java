package id.web.twoh.coolandroiddesign.application;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

/**
 * Created by Hafizh Herdi on 10/3/2016.
 */

public class TWOHsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, "ca-app-pub-6916955256570875~9533087755");
    }
}
