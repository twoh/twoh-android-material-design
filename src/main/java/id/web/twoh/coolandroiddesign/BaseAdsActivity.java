package id.web.twoh.coolandroiddesign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.google.firebase.analytics.FirebaseAnalytics;

import id.web.twoh.coolandroiddesign.utils.Factory;

/**
 * Created by Hafizh Herdi on 11/13/2016.
 */

public class BaseAdsActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    private static final String TAG = BaseAdsActivity.class.getSimpleName();
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        System.out.println("Outer class "+this.getClass().getSimpleName());

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, this.getClass().getSimpleName());
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "activity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle);


        initInterstitial();

    }

    protected void initInterstitial(){

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

    }
}
