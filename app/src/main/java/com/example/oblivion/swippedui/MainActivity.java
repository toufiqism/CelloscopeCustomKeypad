/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.oblivion.swippedui;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener, Listener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the
     * three primary sections of the app. We use a {@link FragmentPagerAdapter}
     * derivative, which will keep every loaded fragment in memory. If this becomes too memory
     * intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will display the three primary sections of the app, one at a
     * time.
     */
    ImageView btnNext, btnPrev;

    TextView lblHeaderUserInApp, lblHeader1InApp, lblHeaderAgentInApp, lblHeader2InApp, lblHeaderOutletInApp, lblHeader3InApp;
    ViewPager mViewPager;
    public EditText txtAnotherAccountNumberInCustomerTransactionInformationActivity, txtAccountNumberInCustomerTransactionInformationActivity;
    public TextView lblTransactionAmountBasedOnType, lblAnotherTransactionAmountBasedOnType;

    public ImageButton btnSubmit, btnAnotherSubmit;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = (ImageView) findViewById(R.id.a);
        btnPrev = (ImageView) findViewById(R.id.b);
        lblHeaderUserInApp = (TextView) findViewById(R.id.lblHeaderUserInApp);
        lblHeader1InApp = (TextView) findViewById(R.id.lblHeader1InApp);
        lblHeaderAgentInApp = (TextView) findViewById(R.id.lblHeaderAgentInApp);
        lblHeader2InApp = (TextView) findViewById(R.id.lblHeader2InApp);
        lblHeaderOutletInApp = (TextView) findViewById(R.id.lblHeaderOutletInApp);
        lblHeader3InApp = (TextView) findViewById(R.id.lblHeader3InApp);

        Typeface externalFont = Typeface.createFromAsset(getAssets(), "kalpurush.ttf");

        lblHeaderUserInApp.setTypeface(externalFont);
      //  lblHeader1InApp.setTypeface(externalFont);
        lblHeaderAgentInApp.setTypeface(externalFont);
      //  lblHeader2InApp.setTypeface(externalFont);
        lblHeaderOutletInApp.setTypeface(externalFont);
      //  lblHeader3InApp.setTypeface(externalFont);
        // Create the adapter that will return a fragment for each of the three primary sections
        // of the app.
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());

        // Set up the action bar.
        final ActionBar actionBar = getActionBar();

        // Specify that the Home/Up button should not be enabled, since there is no hierarchical
        // parent.
        actionBar.setHomeButtonEnabled(false);

        // Specify that we will be displaying tabs in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Set up the ViewPager, attaching the adapter and setting up a listener for when the
        // user swipes between sections.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAppSectionsPagerAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When swiping between different app sections, select the corresponding tab.
                // We can also use ActionBar.Tab#select() to do this if we have a reference to the
                // Tab.

                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mAppSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by the adapter.
            // Also specify this Activity object, which implements the TabListener interface, as the
            // listener for when this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mAppSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
        actionBar.hide();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
            }
        });
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onEditPressed1(String edit1) {
        ZoneFragment zoneFragment = new ZoneFragment();
        try {
            zoneFragment.setMessage(edit1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the primary
     * sections of the app.
     */
    public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {

                case 0:
                    // The other sections of the app are dummy placeholders.

                    return new ButtonActivity(MainActivity.this);
                case 1:

                    return new NumpadLayout();
                default:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return new MobileNumberFragment(MainActivity.this);

            }
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "Step " + (position + 1);
        }
    }

    /**
     * A fragment that launches other parts of the demo application.
     */


    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     */
    @SuppressLint("ValidFragment")
    public class DummySectionFragment extends Fragment {

        public static final String ARG_SECTION_NUMBER = "section_number";

        @SuppressLint("StringFormatInvalid")
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.activity_mobile_number_input, container, false);
            Bundle args = getArguments();

            //btnSubmit = (ImageButton) rootView.findViewById(R.id.btnSubmit);


            return rootView;
        }


    }


}
