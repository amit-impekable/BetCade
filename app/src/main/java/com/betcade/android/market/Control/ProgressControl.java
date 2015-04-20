package com.betcade.android.market.Control;

import android.view.View;
import android.widget.LinearLayout;

import com.betcade.android.market.R;

/**
 * Created by mobile on 18/4/15.
 */
public class ProgressControl {

    View view;

    public ProgressControl(View view) {
        this.view = view;
    }

    public void hideProgressBar() {

        LinearLayout linearLayoutProgress=(LinearLayout)view.findViewById(R.id.progress);
        linearLayoutProgress.setVisibility(View.GONE);
    }
    public void showProgressBar() {

        LinearLayout linearLayoutProgress=(LinearLayout)view.findViewById(R.id.progress);
        linearLayoutProgress.setVisibility(View.VISIBLE);
    }
}
