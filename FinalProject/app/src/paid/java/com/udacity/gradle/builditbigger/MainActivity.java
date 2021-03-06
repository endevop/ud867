package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.libs.android.jokesactivitylibrary.JokeActivity;
import com.udacity.gradle.builditbigger.task.EndpointsAsyncTask;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.Callback{

    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        // show the spinner
        findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);

        new EndpointsAsyncTask().execute(this);
    }

    // callback for the async task
    public void putJoke(String joke) {
        mJoke = joke;
        startJokeActivity();
    }

    private void startJokeActivity() {
        // show the joke
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, mJoke);
        startActivity(intent);
    }
}
