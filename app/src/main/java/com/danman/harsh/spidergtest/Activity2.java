package com.danman.harsh.spidergtest;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/** Import various youtube data api libraries */

public class Activity2 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String API_KEY = "AIzaSyBdxnzLou65S1pS-paeS4BnfQiG6oDkKSQ";  // This is my API KEY obtained from google devloper console
    public String some;     //string to hold the video ID
    Toolbar tool2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundle = getIntent().getExtras();                        // Bundle receives toolbar title and youtube vid from the calling activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        tool2 = (Toolbar) findViewById(R.id.tool2);
        tool2.setTitle(bundle.getString("TOOL_TITLE"));                 //Extract and set the toolbar title
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY, this);
        some=bundle.getString("VID_ID");

    }
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult result) {
        Toast.makeText(this, "Failed to initialize.", Toast.LENGTH_LONG).show();  //Show toast if any error
    }

    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (null == player) return;
        if (!wasRestored) {
            player.cueVideo(some);                                  // Play the video from specified VIDEO_ID
        }
    }
}
