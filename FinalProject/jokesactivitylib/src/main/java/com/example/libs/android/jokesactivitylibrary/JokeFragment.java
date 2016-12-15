package com.example.libs.android.jokesactivitylibrary;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {
    public JokeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeTextView = (TextView) root.findViewById(R.id.joke_text_view);
        // insert a joke
        String joke = ((Callback) getActivity()).getJoke();
        if(joke != null)
            jokeTextView.setText(joke);

        return root;
    }

    // Callback to retrieve joke text from the activity
    public interface Callback {
        public String getJoke();
    }
}
