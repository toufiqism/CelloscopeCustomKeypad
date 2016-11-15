package com.example.oblivion.swippedui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tofiq Akbar on 11/9/16.
 */

public class ZoneFragment extends Fragment {

    Button demo_collection_button;
    View rootView;
    LayoutInflater mInflater;
    ViewGroup mContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_section_launchpad, container, false);
        mInflater = inflater;
        mContainer = container;

        return rootView;
    }

    void setMessage(String msg) throws Exception {
        updateUI();
        demo_collection_button = (Button) rootView.findViewById(R.id.demo_collection_button);
        demo_collection_button.setText(msg);
    }

    private void updateUI() {
        if (rootView == null) {
            mInflater.inflate(R.layout.fragment_section_launchpad, mContainer, false);
        } else {
            return;
        }
    }
}
