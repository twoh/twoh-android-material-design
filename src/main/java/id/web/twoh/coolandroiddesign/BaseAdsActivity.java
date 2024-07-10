package id.web.twoh.coolandroiddesign;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.analytics.FirebaseAnalytics;

import id.web.twoh.coolandroiddesign.utils.Factory;

/**
 * Created by Hafizh Herdi on 11/13/2016.
 */

public class BaseAdsActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private InterstitialAd interstitialAd;
    private static final String TAG = BaseAdsActivity.class.getSimpleName();
    private int counter = 0;
    private AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        AdView mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
                //addTestDevice("22FFB74E3E00DEC909938864EE0B401E").build();
        mAdView.loadAd(adRequest);

        System.out.println("Outer class "+this.getClass().getSimpleName());

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, this.getClass().getSimpleName());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "activity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle);


        initInterstitial();

    }

    protected void initInterstitial(){
        InterstitialAd.load(this, getString(R.string.interstitial_ad_unit_id), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                interstitialAd = null;
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAdLoaded) {
                super.onAdLoaded(interstitialAdLoaded);
                interstitialAd = interstitialAdLoaded;
                decideToDisplay();
            }
        });
    }

    protected void readTheTutorial(String url){
        Factory.DialogRegulerYesNo("", "Lanjut baca tutorial di Web?", this, false, (dialog, which) -> {
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.intent.putExtra(Intent.EXTRA_REFERRER,
                    Uri.parse(Intent.URI_ANDROID_APP_SCHEME + "//" + this.getPackageName()));
            customTabsIntent.launchUrl(this, Uri.parse(url));
        }).show();
    }

    protected void displayInterstitial() {
        if (interstitialAd!=null) {
            interstitialAd.show(BaseAdsActivity.this);
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
        if (interstitialAd !=null) {

            interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdClicked() {
                    super.onAdClicked();
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    interstitialAd = null;
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                    interstitialAd = null;
                }

                @Override
                public void onAdImpression() {
                    super.onAdImpression();
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent();
                }
            });

            interstitialAd.show(BaseAdsActivity.this);
        }
    }
}
