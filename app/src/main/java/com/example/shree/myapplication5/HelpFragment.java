package com.example.shree.myapplication5;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by comp on 14-04-2018.
 */

public class HelpFragment extends Fragment {
    public WebView webView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getActivity().setTitle("Helpline");
        View v = inflater.inflate(R.layout.fragment_help, container, false);
        webView = (WebView) v.findViewById(R.id.whelp);
        webView.loadUrl("http://www.newincept.com/helpline-numbers-all-over-in-india.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
       // mWebView.getSettings().setAppCacheEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
