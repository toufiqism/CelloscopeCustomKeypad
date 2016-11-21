package com.example.oblivion.swippedui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;

import com.csb.net.celloscopeKeypadLibrary.MonthKeyView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

import static android.content.ContentValues.TAG;

/**
 * Created by Tofiq Akbar on 10/24/16.
 */


@SuppressLint("ValidFragment")
public class FinalLayoutFragment extends Fragment {
    int year;
    Calendar now;


    LinearLayout Date_L0_1_1, Date_L0_1_2, Date_L0_1_3, Date_L0_1_4, Date_L0_1_5, Date_L0_2_1, Date_L0_2_2, Date_L0_2_3, Date_L0_2_4, Date_L0_2_5, Date_L0_3_1, Date_L0_3_2, Date_L0_3_3, Date_L0_3_4, Date_L0_3_5, Date_L0_4_1, Date_L0_4_2, Date_L0_4_3, Date_L0_4_4, Date_L0_4_5, Date_L0_5_1, Date_L0_5_2, Date_L0_5_3, Date_L0_5_4, Date_L0_5_5, Date_L0_6_1, Date_L0_6_2, Date_L0_6_3, Date_L0_6_4, Date_L0_6_5, Date_L0_7_1;
    TextView date_txt_31, date_txt_30, date_txt_29, date_txt_28, date_txt_27, date_txt_26, date_txt_25, date_txt_24, date_txt_23, date_txt_22, date_txt_21, date_txt_20, date_txt_19, date_txt_18, date_txt_17, date_txt_16, date_txt_15, date_txt_14, date_txt_13, date_txt_12, date_txt_11, date_txt_10, date_txt_09, date_txt_08, date_txt_07, date_txt_06, date_txt_05, date_txt_04, date_txt_03, date_txt_02, date_txt_01;
    View rootView;
    MonthKeyView monthKeyView;

    LinearLayout L0_1_1, L0_1_2, L0_1_3, L0_2_1, L0_2_2, L0_2_3, L0_3_1, L0_3_2, L0_3_3, L0_4_1, L0_4_2, L0_4_3;
    LinearLayout Year_L0_1, Year_L0_2;
    TextView lblBillLabel, txtDate_Input, txtMonth_Input, txtYear_Input, txt1, txt1_1, txt2, txt2_1, txt3, txt3_1, txt4, txt4_1, txt5, txt5_1, txt6, txt6_1, txt7, txt7_1, txt8, txt8_1, txt9, txt9_1, txt10, txt10_1, txt11, txt11_1, txt12, txt12_1, lblBillSlash_1, lblBillSlash_2;
    Context mCon;
    LinearLayout layoutFragmentContainerInMobileNumberInput_date, layoutFragmentContainerInMobileNumberInput_year, layoutFragmentContainerInMobileNumberInput_Month;
    Animation anim;
    private TextView txtYearUpper;
    private TextView txtYearLower;
    LinearLayout layoutTest;
    MonthKeyView l1;
    private MonthKeyView l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;

    public FinalLayoutFragment(Context c) {
        mCon = c;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_final_layout, container, false);
        init(rootView);
        regi();
        return rootView;
    }

    private void regi() {

        Date_L0_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("3");
            }
        });
        Date_L0_1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("4");
            }
        });
        Date_L0_1_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("5");
            }
        });
        Date_L0_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("6");
            }
        });
        Date_L0_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("7");
            }
        });
        Date_L0_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("8");
            }
        });
        Date_L0_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("9");
            }
        });
        Date_L0_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("10");
            }
        });
        Date_L0_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("11");
            }
        });
        Date_L0_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("12");
            }
        });
        Date_L0_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("13");
            }
        });
        Date_L0_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("14");
            }
        });
        Date_L0_3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("15");
            }
        });
        Date_L0_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("16");
            }
        });
        Date_L0_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("17");
            }
        });
        Date_L0_4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("18");
            }
        });
        Date_L0_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("19");
            }
        });
        Date_L0_4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("20");
            }
        });
        Date_L0_5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("21");
            }
        });
        Date_L0_5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("22");
            }
        });
        Date_L0_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("23");
            }
        });
        Date_L0_5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("24");
            }
        });
        Date_L0_5_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("25");
            }
        });
        Date_L0_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("26");
            }
        });
        Date_L0_6_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("27");
            }
        });
        Date_L0_6_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("28");
            }
        });
        Date_L0_6_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("29");
            }
        });
        Date_L0_6_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("30");
            }
        });
        Date_L0_7_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("31");
            }
        });

        txtDate_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutFragmentContainerInMobileNumberInput_date.setVisibility(View.VISIBLE);
                layoutFragmentContainerInMobileNumberInput_year.setVisibility(View.GONE);
                layoutFragmentContainerInMobileNumberInput_Month.setVisibility(View.GONE);
                txtYear_Input.setBackgroundResource(0);
                txtMonth_Input.setBackgroundResource(0);
                txtDate_Input.setBackground(getResources().getDrawable(R.drawable.border_bottom));
                txtDate_Input.setTypeface(txtDate_Input.getTypeface(), Typeface.BOLD);
                txtMonth_Input.setTypeface(txtMonth_Input.getTypeface(), Typeface.NORMAL);
                txtYear_Input.setTypeface(txtMonth_Input.getTypeface(), Typeface.NORMAL);
            }
        });
        txtYear_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutFragmentContainerInMobileNumberInput_date.setVisibility(View.GONE);
                layoutFragmentContainerInMobileNumberInput_year.setVisibility(View.VISIBLE);
                layoutFragmentContainerInMobileNumberInput_Month.setVisibility(View.GONE);
                txtYear_Input.setBackground(getResources().getDrawable(R.drawable.border_bottom));
                txtMonth_Input.setBackgroundResource(0);
                txtDate_Input.setBackgroundResource(0);
                txtDate_Input.setTypeface(txtDate_Input.getTypeface(), Typeface.NORMAL);
                txtMonth_Input.setTypeface(txtMonth_Input.getTypeface(), Typeface.NORMAL);
                txtYear_Input.setTypeface(txtMonth_Input.getTypeface(), Typeface.BOLD);
            }
        });
        txtMonth_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutFragmentContainerInMobileNumberInput_date.setVisibility(View.GONE);
                layoutFragmentContainerInMobileNumberInput_year.setVisibility(View.GONE);
                layoutFragmentContainerInMobileNumberInput_Month.setVisibility(View.VISIBLE);
                txtYear_Input.setBackgroundResource(0);
                txtDate_Input.setBackgroundResource(0);
                txtMonth_Input.setBackground(getResources().getDrawable(R.drawable.border_bottom));
                txtDate_Input.setTypeface(txtDate_Input.getTypeface(), Typeface.NORMAL);
                txtMonth_Input.setTypeface(txtMonth_Input.getTypeface(), Typeface.BOLD);
                txtYear_Input.setTypeface(txtMonth_Input.getTypeface(), Typeface.NORMAL);

            }
        });


        Year_L0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isYearSelected(year);

            }
        });
        Year_L0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isYearSelected(year - 1);
            }
        });
        txtDate_Input.performClick();

    }

    private void isMonthSelected(String value) {

        l1.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        l2.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        l3.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        l4.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        l5.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        l6.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        l7.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        l8.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        l9.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        l10.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_bottom_month));
        l11.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_bottom_month));
        l12.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_bottom_right_month));

        if (value.compareToIgnoreCase("January") == 0) {
            l1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_01));
            txtYear_Input.performClick();

        } else if (value.compareToIgnoreCase("February") == 0) {
            l2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_02));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("March") == 0) {
            l3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_03));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("April") == 0) {
            l4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_04));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("May") == 0) {
            l5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_05));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("June") == 0) {
            l6.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_06));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("July") == 0) {
            l7.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_07));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("August") == 0) {
            l8.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_08));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("September") == 0) {
            l9.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_09));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("October") == 0) {
            l10.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_10));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("November") == 0) {
            l11.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_11));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("December") == 0) {
            l12.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_12));
            txtYear_Input.performClick();
        }


    }

    private void isYearSelected(int value) {
        if (value == year) {
            Year_L0_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Year_L0_2.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_bottom_right_month));
            txtYear_Input.setText(getBanglaFromEnglish(value));
        } else if (value == (year - 1)) {
            Year_L0_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Year_L0_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_bottom_right_month));
            txtYear_Input.setText(getBanglaFromEnglish(value));
        }
    }

    private void init(View rootView) {

        l1 = (MonthKeyView) rootView.findViewById(R.id.l1);
        l2 = (MonthKeyView) rootView.findViewById(R.id.l2);
        l3 = (MonthKeyView) rootView.findViewById(R.id.l3);
        l4 = (MonthKeyView) rootView.findViewById(R.id.l4);
        l5 = (MonthKeyView) rootView.findViewById(R.id.l5);
        l6 = (MonthKeyView) rootView.findViewById(R.id.l6);
        l7 = (MonthKeyView) rootView.findViewById(R.id.l7);
        l8 = (MonthKeyView) rootView.findViewById(R.id.l8);
        l9 = (MonthKeyView) rootView.findViewById(R.id.l9);
        l10 = (MonthKeyView) rootView.findViewById(R.id.l10);
        l11 = (MonthKeyView) rootView.findViewById(R.id.l11);
        l12 = (MonthKeyView) rootView.findViewById(R.id.l12);
        layoutFragmentContainerInMobileNumberInput_date = (LinearLayout) rootView.findViewById(R.id.layoutFragmentContainerInMobileNumberInput_date);
        layoutFragmentContainerInMobileNumberInput_Month = (LinearLayout) rootView.findViewById(R.id.layoutFragmentContainerInMobileNumberInput_Month);
        layoutFragmentContainerInMobileNumberInput_year = (LinearLayout) rootView.findViewById(R.id.layoutFragmentContainerInMobileNumberInput_year);
        Year_L0_1 = (LinearLayout) rootView.findViewById(R.id.Year_L0_1);
        Year_L0_2 = (LinearLayout) rootView.findViewById(R.id.Year_L0_2);
        txtYearUpper = (TextView) rootView.findViewById(R.id.txtYearUpper);
        txtYearLower = (TextView) rootView.findViewById(R.id.txtYearLower);
        ((Activity) mCon).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        now = Calendar.getInstance();   // Gets the current date and time
        year = now.get(Calendar.YEAR);
        txtYearUpper.setText(getBanglaFromEnglish(year));
        txtYearLower.setText(getBanglaFromEnglish(year - 1));

        lblBillLabel = (TextView) rootView.findViewById(R.id.lblBillLabel);
        txtDate_Input = (TextView) rootView.findViewById(R.id.txtDate_Input);
        txtMonth_Input = (TextView) rootView.findViewById(R.id.txtMonth_Input);
        txtYear_Input = (TextView) rootView.findViewById(R.id.txtYear_Input);
        lblBillSlash_1 = (TextView) rootView.findViewById(R.id.lblBillSlash_1);
        lblBillSlash_2 = (TextView) rootView.findViewById(R.id.lblBillSlash_2);

        Typeface externalFont = Typeface.createFromAsset(mCon.getAssets(), "kalpurush.ttf");
        Typeface newFont = Typeface.createFromAsset(mCon.getAssets(), "Lohit_Bengali.ttf");
        Typeface muktiNormal = Typeface.createFromAsset(mCon.getAssets(), "Mukti_normal.ttf");

        lblBillLabel.setTypeface(externalFont);


        txtDate_Input.setTypeface(newFont);
        lblBillSlash_1.setTypeface(newFont);
        txtMonth_Input.setTypeface(newFont);
        lblBillSlash_2.setTypeface(newFont);
        txtYear_Input.setTypeface(newFont);


        Date_L0_1_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_1);
        Date_L0_1_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_2);
        Date_L0_1_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_3);
        Date_L0_1_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_4);
        Date_L0_1_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_5);
        Date_L0_2_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_1);
        Date_L0_2_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_2);
        Date_L0_2_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_3);
        Date_L0_2_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_4);
        Date_L0_2_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_5);
        Date_L0_3_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_1);
        Date_L0_3_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_2);
        Date_L0_3_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_3);
        Date_L0_3_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_4);
        Date_L0_3_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_5);
        Date_L0_4_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_1);
        Date_L0_4_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_2);
        Date_L0_4_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_3);
        Date_L0_4_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_4);
        Date_L0_4_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_5);
        Date_L0_5_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_1);
        Date_L0_5_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_2);
        Date_L0_5_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_3);
        Date_L0_5_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_4);
        Date_L0_5_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_5);
        Date_L0_6_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_1);
        Date_L0_6_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_2);
        Date_L0_6_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_3);
        Date_L0_6_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_4);
        Date_L0_6_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_5);
        Date_L0_7_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_7_1);

        date_txt_01 = (TextView) rootView.findViewById(R.id.date_txt_01);
        date_txt_02 = (TextView) rootView.findViewById(R.id.date_txt_02);
        date_txt_03 = (TextView) rootView.findViewById(R.id.date_txt_03);
        date_txt_04 = (TextView) rootView.findViewById(R.id.date_txt_04);
        date_txt_05 = (TextView) rootView.findViewById(R.id.date_txt_05);
        date_txt_06 = (TextView) rootView.findViewById(R.id.date_txt_06);
        date_txt_07 = (TextView) rootView.findViewById(R.id.date_txt_07);
        date_txt_08 = (TextView) rootView.findViewById(R.id.date_txt_08);
        date_txt_09 = (TextView) rootView.findViewById(R.id.date_txt_09);
        date_txt_10 = (TextView) rootView.findViewById(R.id.date_txt_10);
        date_txt_11 = (TextView) rootView.findViewById(R.id.date_txt_11);
        date_txt_12 = (TextView) rootView.findViewById(R.id.date_txt_12);
        date_txt_13 = (TextView) rootView.findViewById(R.id.date_txt_13);
        date_txt_14 = (TextView) rootView.findViewById(R.id.date_txt_14);
        date_txt_15 = (TextView) rootView.findViewById(R.id.date_txt_15);
        date_txt_16 = (TextView) rootView.findViewById(R.id.date_txt_16);
        date_txt_17 = (TextView) rootView.findViewById(R.id.date_txt_17);
        date_txt_18 = (TextView) rootView.findViewById(R.id.date_txt_18);
        date_txt_19 = (TextView) rootView.findViewById(R.id.date_txt_19);
        date_txt_20 = (TextView) rootView.findViewById(R.id.date_txt_20);
        date_txt_21 = (TextView) rootView.findViewById(R.id.date_txt_21);
        date_txt_22 = (TextView) rootView.findViewById(R.id.date_txt_22);
        date_txt_23 = (TextView) rootView.findViewById(R.id.date_txt_23);
        date_txt_24 = (TextView) rootView.findViewById(R.id.date_txt_24);
        date_txt_25 = (TextView) rootView.findViewById(R.id.date_txt_25);
        date_txt_26 = (TextView) rootView.findViewById(R.id.date_txt_26);
        date_txt_27 = (TextView) rootView.findViewById(R.id.date_txt_27);
        date_txt_28 = (TextView) rootView.findViewById(R.id.date_txt_28);
        date_txt_29 = (TextView) rootView.findViewById(R.id.date_txt_29);
        date_txt_30 = (TextView) rootView.findViewById(R.id.date_txt_30);
        date_txt_31 = (TextView) rootView.findViewById(R.id.date_txt_31);

        date_txt_01.setTypeface(newFont);
        date_txt_02.setTypeface(newFont);
        date_txt_03.setTypeface(newFont);
        date_txt_04.setTypeface(newFont);
        date_txt_05.setTypeface(newFont);
        date_txt_06.setTypeface(newFont);
        date_txt_07.setTypeface(newFont);
        date_txt_08.setTypeface(newFont);
        date_txt_09.setTypeface(newFont);
        date_txt_10.setTypeface(newFont);
        date_txt_11.setTypeface(newFont);
        date_txt_12.setTypeface(newFont);
        date_txt_13.setTypeface(newFont);
        date_txt_14.setTypeface(newFont);
        date_txt_15.setTypeface(newFont);
        date_txt_16.setTypeface(newFont);
        date_txt_17.setTypeface(newFont);
        date_txt_18.setTypeface(newFont);
        date_txt_19.setTypeface(newFont);
        date_txt_20.setTypeface(newFont);
        date_txt_21.setTypeface(newFont);
        date_txt_22.setTypeface(newFont);
        date_txt_23.setTypeface(newFont);
        date_txt_24.setTypeface(newFont);
        date_txt_25.setTypeface(newFont);
        date_txt_26.setTypeface(newFont);
        date_txt_27.setTypeface(newFont);
        date_txt_28.setTypeface(newFont);
        date_txt_29.setTypeface(newFont);
        date_txt_30.setTypeface(newFont);
        date_txt_31.setTypeface(newFont);

        txtYearLower.setTypeface(newFont);
        txtYearUpper.setTypeface(newFont);

        isYearSelected(year);
    }

    public static String getBanglaFromEnglish(int intNum) {

        String engNum = String.valueOf(intNum);
        char[] cArray = engNum.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '1':
                    cArray[i] = '১';
                    break;
                case '2':
                    cArray[i] = '২';
                    break;
                case '3':
                    cArray[i] = '৩';
                    break;
                case '4':
                    cArray[i] = '৪';
                    break;
                case '5':
                    cArray[i] = '৫';
                    break;
                case '6':
                    cArray[i] = '৬';
                    break;
                case '7':
                    cArray[i] = '৭';
                    break;
                case '8':
                    cArray[i] = '৮';
                    break;
                case '9':
                    cArray[i] = '৯';
                    break;
                case '0':
                    cArray[i] = '০';
                    break;

                default:
                    cArray[i] = 'f';
                    break;
            }
        }
        return new String(cArray);
    }

    private void isDateSelected(String value) {

        Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_border_upper_left_month));
        Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_right_month));
        Date_L0_7_1.setBackground(getResources().getDrawable(R.drawable.keypad_border_up_left_bottom_month));

        if (value.compareToIgnoreCase("1") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_1));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("2") == 0) {
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_2));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("3") == 0) {
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_3));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("4") == 0) {
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_4));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("5") == 0) {
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_5));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("6") == 0) {
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_6));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("7") == 0) {
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_7));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("8") == 0) {
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_8));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("9") == 0) {
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_9));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("10") == 0) {
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_10));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("11") == 0) {
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_11));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("12") == 0) {
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_12));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("13") == 0) {
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_13));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("14") == 0) {
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_14));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("15") == 0) {
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_15));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("16") == 0) {
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_16));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("17") == 0) {
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_17));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("18") == 0) {
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_18));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("19") == 0) {
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_19));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("20") == 0) {
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_20));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("21") == 0) {
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_21));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("22") == 0) {
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_22));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("23") == 0) {
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_23));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("24") == 0) {
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_24));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("25") == 0) {
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_25));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("26") == 0) {
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_26));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("27") == 0) {
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_27));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("28") == 0) {
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_28));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("29") == 0) {
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_29));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("30") == 0) {
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_30));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("31") == 0) {
            Date_L0_7_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_31));
            txtMonth_Input.performClick();
        }
    }


}
