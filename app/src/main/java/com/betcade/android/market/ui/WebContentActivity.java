package com.betcade.android.market.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.betcade.android.market.R;
import com.betcade.android.market.ui.fragment.WebContentFragment;

public class WebContentActivity extends ActionBarActivity {


    String url;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content);
        if (savedInstanceState == null) {
            getExtras();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new WebContentFragment().newInstance(this.url,this.title))
                    .commit();
            loadActionBar();
        }
    }

    private void getExtras()
    {
        // Get values from intent
    this.title=getIntent().getStringExtra("title");
    this.url=getIntent().getStringExtra("webUrl");

    }

    private void loadActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(this.title);
    }







}
