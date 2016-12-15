package com.example.libs.android.jokesactivitylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity implements JokeFragment.Callback{
    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // process intent extra text
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String joke = intent.getStringExtra(Intent.EXTRA_TEXT);
            if(joke != null && !joke.isEmpty())
                mJoke = joke;
        }
        setContentView(R.layout.activity_joke);
    }

    @Override
    public String getJoke() {
        return mJoke;
    }
}
