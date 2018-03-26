package sap.com.travelguide.ui.detail.info;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.Serializable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import sap.com.travelguide.R;
import sap.com.travelguide.TravelGuideApplication;
import sap.com.travelguide.ui.Presenter;
import sap.com.travelguide.ui.detail.weather.WeatherFragment;

/**
 * Created by I344065 on 2018. 01. 19..
 */

public class InfoFragment extends Fragment implements InfoScreen {

    @Inject
    InfoPresenter infoPresenter;

    @BindView(R.id.webView)
    WebView webView;

    Unbinder unbinder;

    public static InfoFragment getInstance() {

        return new InfoFragment();
    }

    public InfoFragment() {
        TravelGuideApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        //artist = getActivity().getIntent().getStringExtra(MainActivity.KEY_ARTIST);
        infoPresenter.setCityModel(getActivity().getIntent().getSerializableExtra("city"));
        infoPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {
        infoPresenter.detachScreen();
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.info_fragment,container,false);

        unbinder = ButterKnife.bind(this,root);

        initWebView();

        return root;
    }

    private void initWebView() {
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();

        webView.loadUrl(infoPresenter.getWikiUrl());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
    }
}
