package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.jokedisplay.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity implements OnJokeProvidedListener {

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

    @SuppressWarnings("unchecked")
    public void tellJoke(View view) {
        JokesEndpointsAsyncTask task = new JokesEndpointsAsyncTask();
        task.setJokeListener(this);
        task.execute(new Pair<Context, String>(this, "Cristian"));
    }


    @Override
    public void onJokeProvided(String result) {
        Intent jokeDisplayIntent = new Intent(this, JokeDisplayActivity.class);
        jokeDisplayIntent.putExtra(JokeDisplayActivity.EXTRA_JOKE, result);
        startActivity(jokeDisplayIntent);
    }
}
