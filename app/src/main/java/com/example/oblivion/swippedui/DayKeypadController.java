package com.example.oblivion.swippedui;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Tofiq Akbar on 11/15/16.
 */

public class DayKeypadController implements View.OnClickListener {

    Context mContext;
    View rootView;
    LinearLayout L0_1_1;


    DayKeypadController(Context context, View v) {
        mContext = context;
        rootView = v;
        init();

    }

    private void init() {
        L0_1_1 = (LinearLayout) rootView.findViewById(R.id.L0_1_1);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.L0_1_1:
                doSomething();
                break;

            default:
        }
    }

    private void doSomething() {
        Log.d("::DATA::", "doSomething:++++" + "MY NAME IS");
    }
}
