package com.wordpress.jonyonandroidcraftsmanship.swipetabsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Logger.log("onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null) {
            Logger.log("onCreate Subsequent Time");
        } else {
            Logger.log("onCreate First Time");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Logger.log("onCreateView");
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Logger.log("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.log("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.log("onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.log("onSaveInstanceState");
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.log("onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.log("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.log("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.log("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.log("onDetach");
    }
}