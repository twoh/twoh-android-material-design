package id.web.twoh.coolandroiddesign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by Hafizh Herdi on 11/13/2016.
 */

public class BaseAdsActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private InterstitialAd interstitialAd;
    private static final String TAG = BaseAdsActivity.class.getSimpleName();
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("22FFB74E3E00DEC909938864EE0B401E").build();
        mAdView.loadAd(adRequest);

        System.out.println("Outer class "+this.getClass().getSimpleName());

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, this.getClass().getSimpleName());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "activity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle);

        initInterstitial();

    }

    protected void initInterstitial(){
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadInterstitial();
            }
        });

        loadInterstitial();
    }

    protected void readTheTutorial(String url){
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.intent.putExtra(Intent.EXTRA_REFERRER,
                Uri.parse(Intent.URI_ANDROID_APP_SCHEME + "//" + this.getPackageName()));
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }

    protected void displayInterstitial() {
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            loadInterstitial();
        }
    }

    protected void decideToDisplay(){
        counter++;
        Log.v(TAG, "ads matdes counter display "+counter);
        if(counter==5)
        {
            Log.v(TAG, "ads matdes counter display displayed "+counter);
            displayInterstitial();
            counter = 0;
        }
    }

    private void loadInterstitial() {

        if (!interstitialAd.isLoading() && !interstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder().build();
            interstitialAd.loadAd(adRequest);
        }
    }
}
