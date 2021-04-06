package com.example.browser;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    EditText url;
    WebView web;
    Button gotoButton, refresh;
    String currentSite == null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("moi");

        url = (EditText) findViewById(R.id.url);

        web = findViewById(R.id.web);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        web.loadUrl("http://www.google.fi");


        /*url.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    System.out.println(url.toString());
                    web.loadUrl(url.toString());
                    handled = true;
                }
                return handled;
            }
        });*/

        gotoButton.setOnClickListener(v -> {
            currentSite = "https://" + url.getText().toString();
            System.out.println(currentSite);


            if (currentSite == null || currentSite.equals("https://")) {
                System.out.println("No address given");

            } else {
                web.loadUrl(currentSite);
            }
        });

        refresh.setOnClickListener(v -> {
            web.loadUrl(currentSite);
        });
    }
}