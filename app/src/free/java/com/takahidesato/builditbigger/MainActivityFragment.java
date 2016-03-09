package com.takahidesato.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.takahidesato.javajokeslib.Joker;

/**
 * Created by tsato on 2/29/16.
 */
public class MainActivityFragment extends Fragment {

    private Button jokeButton = null;
    private ProgressBar mProgressBar = null;
    private InterstitialAd mInterstitialAd = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        jokeButton = (Button) root.findViewById(R.id.btn_joke);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLibraryActivity(v);
            }
        });

        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(MainActivity.ID_AD_UNIT);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });
        requestNewInterstitial();

        return root;
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    public void launchLibraryActivity(View view) {
        Joker joker = new Joker();

        Log.d(MainActivity.class.getSimpleName(), joker.getJoke());

        new EndpointsAsyncTask(mProgressBar, mInterstitialAd).execute(new Pair<Context, String>(getActivity(), "Test"));
    }
}
