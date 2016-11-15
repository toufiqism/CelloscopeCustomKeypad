package com.example.oblivion.swippedui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Tofiq Akbar on 11/10/16.
 */
@SuppressLint("ValidFragment")
public class DayLayout extends Fragment {
    Context mCon;

    public DayLayout(Context c) {
        mCon = c;
    }

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return rootView;
    }


}
