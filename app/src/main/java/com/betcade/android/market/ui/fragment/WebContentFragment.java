package com.betcade.android.market.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.betcade.android.market.Control.ProgressControl;
import com.betcade.android.market.R;

public class WebContentFragment extends Fragment {


    private static final String _webUrl = "webUrl";



    private String webUrl;




    public static WebContentFragment newInstance(String url, String title) {
        WebContentFragment fragment = new WebContentFragment();
        Bundle args = new Bundle();
        args.putString(_webUrl, url);

        fragment.setArguments(args);
        return fragment;
    }

    public WebContentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            webUrl = getArguments().getString(_webUrl);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_content, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadWebView();
    }

    private void loadWebView()
    {
        WebView webContentWebView=(WebView)getView().findViewById(R.id.webcontentWebView);

        final ProgressControl control=new ProgressControl(getView());
        control.showProgressBar();


        webContentWebView = (WebView) getView().findViewById(R.id.webcontentWebView);
        webContentWebView.getSettings().setJavaScriptEnabled(true);
        webContentWebView.getSettings().setSupportZoom(true);
        webContentWebView.getSettings().setBuiltInZoomControls(true);
        webContentWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {

                control.hideProgressBar();

            }
        });
        webContentWebView.loadUrl(webUrl);

    }

}
