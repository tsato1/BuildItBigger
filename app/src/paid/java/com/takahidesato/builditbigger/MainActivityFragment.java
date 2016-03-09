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

import com.takahidesato.javajokeslib.Joker;

/**
 * Created by tsato on 3/4/16.
 */
public class MainActivityFragment extends Fragment {

    private Button jokeButton = null;
    private ProgressBar mProgressBar = null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        jokeButton = (Button) root.findViewById(R.id.btn_joke);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLibraryActivity(v);
            }
        });

        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.GONE);

        return root;
    }

    public void launchLibraryActivity(View view) {
        Joker joker = new Joker();

        Log.d(MainActivity.class.getSimpleName(), joker.getJoke());

        new EndpointsAsyncTask(mProgressBar).execute(new Pair<Context, String>(getActivity(), "Test"));
    }
}