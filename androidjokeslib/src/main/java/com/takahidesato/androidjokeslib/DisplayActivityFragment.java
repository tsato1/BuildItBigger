package com.takahidesato.androidjokeslib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tsato on 3/1/16.
 */
public class DisplayActivityFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra("joke");

        TextView textView = (TextView) view.findViewById(R.id.txv_joke);
        textView.setText(joke);

        //Toast.makeText(getActivity(), joke, Toast.LENGTH_SHORT).show();

        return view;
    }
}
