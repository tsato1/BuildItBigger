package com.takahidesato.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.takahidesato.androidjokeslib.DisplayActivity;
import com.takahidesato.builditbigger.backend.myApi.MyApi;
import com.takahidesato.javajokeslib.Joker;

import java.io.IOException;

/**
 * Created by tsato on 3/2/16.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        Joker joker = new Joker();
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://id.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;

        try {
            Log.d("test", "say hi called in doinbackground");
            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            Log.d(EndpointsAsyncTask.class.getSimpleName(), e.toString());
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, DisplayActivity.class);
        intent.putExtra("joke", result);
        context.startActivity(intent);

        Log.d(EndpointsAsyncTask.class.getSimpleName(), result);
    }
}
