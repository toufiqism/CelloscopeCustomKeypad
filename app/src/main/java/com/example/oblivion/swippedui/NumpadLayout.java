package com.example.oblivion.swippedui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.csb.net.celloscopeKeypadLibrary.CelloscopeKeypadView;
import com.csb.net.celloscopeKeypadLibrary.MonthKeyView;

import static android.content.ContentValues.TAG;

/**
 * Created by Tofiq Akbar on 11/9/16.
 */

public class NumpadLayout extends Fragment implements CelloscopeKeypadView.OnMonthKeyClickListener {

    CelloscopeKeypadView celloscopeKeyView_0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Test", "hello");
    }

    View rootView;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.activity_numpad_layout, container, false);
        celloscopeKeyView_0 = (CelloscopeKeypadView) rootView.findViewById(R.id.celloscopeKeyView_0);
        celloscopeKeyView_0.setOnMonthKeyClickListener(this);
        Bundle args = getArguments();


        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFileSelectedListener");
        }
    }

    @Override
    public void onMonthKeyClicked(MonthKeyView monthKeyView, String numValue) {
        Log.d(TAG, "onMonthKeyClicked: " + numValue);
    }
}
