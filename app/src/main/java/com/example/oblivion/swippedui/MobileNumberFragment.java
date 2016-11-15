package com.example.oblivion.swippedui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Tofiq Akbar on 10/10/16.
 */
@SuppressLint("ValidFragment")
public class MobileNumberFragment extends android.support.v4.app.Fragment {
    /*http://stackoverflow.com/questions/22027107/get-edittext-value-on-different-fragment*/
    LinearLayout L0_1_1, L0_1_2, L0_1_3, L0_2_1, L0_2_2, L0_2_3, L0_3_1, L0_3_2, L0_3_3, L0_4_1, L0_4_2, L0_4_3;
    TextView txtMonth_Input, txtDate_Input, txtYear_Input;
    TextView txtYearUpper, txtYearLower;
    LinearLayout Date_L0_1_1, Date_L0_1_2, Date_L0_1_3, Date_L0_1_4, Date_L0_1_5, Date_L0_1_6, Date_L0_2_1, Date_L0_2_2, Date_L0_2_3, Date_L0_2_4, Date_L0_2_5, Date_L0_2_6, Date_L0_3_1, Date_L0_3_2, Date_L0_3_3, Date_L0_3_4, Date_L0_3_5, Date_L0_3_6, Date_L0_4_1, Date_L0_4_2, Date_L0_4_3, Date_L0_4_4, Date_L0_4_5, Date_L0_4_6, Date_L0_5_1, Date_L0_5_2, Date_L0_5_3, Date_L0_5_4, Date_L0_5_5, Date_L0_5_6, Date_L0_6_1, Date_L0_6_2, Date_L0_6_3, Date_L0_6_4, Date_L0_6_5, Date_L0_6_6;
    Calendar now = Calendar.getInstance();
    int year;
    LinearLayout Year_L0_1, Year_L0_2;
    LinearLayout layoutFragmentContainerInMobileNumberInput, layoutFragmentContainerInMobileNumberInput_numpad, layoutFragmentContainerInMobileNumberInput_date, layoutFragmentContainerInMobileNumberInput_Year;
    ImageButton btnSubmitInMobileNumberInput;
    TextView lblTransactionAmountBasedOnType, txtDate, txtMonth, txtYear;
    final String pattern = "##,##,##,###.##";
    String displayText = "";
    String displayTextHidden = "";
    String displayTextExact = "";
    int NumberOfdecimalPointClick = 0;
    Locale bdLocale;
    StringBuilder stringBuilder = new StringBuilder("");
    Animation anim;
    double amountForTransaction = 0;
    final String pattern2DecimalPoint = ".*[.][0-9][0-9]$";
    final String patternOnlyDecimalPoint = ".*[.]$";
    final String patternDecimalPointWithOneleadingZero = ".*[.]0$";
    final String patternDecimalPointWithTwoleadingZero = ".*[.]00$";
    final String patternDecimalPointWithOneNumberWithOneLeadingZero = ".*[.][1-9]0$";

    String decimalPointWithLeadingZeros = "";

    boolean amountAlreadyTaken = false;
    StringBuilder displayTextBuilder;
    NumberFormat numberFormat;
    DecimalFormat decimalFormat;
    private String TAG = MobileNumberFragment.class.getSimpleName();
    Context mCon;
    public static int res_January = 0, res_February = 0, res_March = 0, res_April = 0, res_May = 0, res_June = 0, res_July = 0, res_August = 0, res_September = 0, res_October = 0, res_November = 0, res_December = 0;

    public MobileNumberFragment(Context context) {
        mCon = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        try {

            View rootView = inflater.inflate(R.layout.activity_mobile_number_input, container, false);
            Bundle args = getArguments();

            initializeUIControls(rootView);
            registerUIControlEvents(rootView);


            return rootView;
        } catch (Exception e) {
            e.printStackTrace();
            return super.onCreateView(inflater, container, savedInstanceState);
        }
    }

/*    Listener listener;*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

       /* try {
            listener = (Listener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implemnt onEditPressed");
        }*/
    }

    private void registerUIControlEvents(View rootView) throws Exception {


        txtDate_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutFragmentContainerInMobileNumberInput_date.setVisibility(View.VISIBLE);
                layoutFragmentContainerInMobileNumberInput.setVisibility(View.GONE);
                layoutFragmentContainerInMobileNumberInput_numpad.setVisibility(View.GONE);
                txtYear_Input.setBackgroundResource(0);
                txtMonth_Input.setBackgroundResource(0);
                txtDate_Input.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            }
        });
        txtYear_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutFragmentContainerInMobileNumberInput_numpad.setVisibility(View.VISIBLE);
                layoutFragmentContainerInMobileNumberInput_date.setVisibility(View.GONE);
                layoutFragmentContainerInMobileNumberInput.setVisibility(View.GONE);
                txtYear_Input.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                txtMonth_Input.setBackgroundResource(0);
                txtDate_Input.setBackgroundResource(0);
            }
        });
        txtMonth_Input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutFragmentContainerInMobileNumberInput.setVisibility(View.VISIBLE);
                layoutFragmentContainerInMobileNumberInput_date.setVisibility(View.GONE);
                layoutFragmentContainerInMobileNumberInput_numpad.setVisibility(View.GONE);
                txtDate_Input.setBackgroundResource(0);
                txtYear_Input.setBackgroundResource(0);
                txtMonth_Input.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            }
        });

        Year_L0_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    isYearSelected(year);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Year_L0_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    isYearSelected(year - 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        L0_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isSelected("January");

            }
        });

        L0_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                isSelected("February");
            }
        });
        L0_1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("March");
            }
        });

        L0_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("April");
            }
        });
        L0_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("May");
            }
        });
        L0_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("June");
            }
        });
        L0_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("July");
            }
        });
        L0_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("August");
            }
        });
        L0_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("September");
            }
        });
        L0_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("October");
            }
        });
        L0_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("November");
            }
        });
        L0_4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSelected("December");
            }
        });

        Date_L0_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("1");
            }
        });
        Date_L0_1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("2");
            }
        });
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
        Date_L0_1_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("6");
            }
        });
        Date_L0_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("7");
            }
        });
        Date_L0_2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("8");
            }
        });
        Date_L0_2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("9");
            }
        });
        Date_L0_2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("10");
            }
        });
        Date_L0_2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("11");
            }
        });
        Date_L0_2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("12");
            }
        });
        Date_L0_3_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("13");
            }
        });
        Date_L0_3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("14");
            }
        });
        Date_L0_3_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("15");
            }
        });
        Date_L0_3_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("16");
            }
        });
        Date_L0_3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("17");
            }
        });
        Date_L0_3_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("18");
            }
        });
        Date_L0_4_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("19");
            }
        });
        Date_L0_4_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("20");
            }
        });
        Date_L0_4_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("21");
            }
        });
        Date_L0_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("22");
            }
        });
        Date_L0_4_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("23");
            }
        });
        Date_L0_4_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("24");
            }
        });
        Date_L0_5_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("25");
            }
        });
        Date_L0_5_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("26");
            }
        });
        Date_L0_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("27");
            }
        });
        Date_L0_5_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("28");
            }
        });
        Date_L0_5_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("29");
            }
        });
        Date_L0_5_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("30");
            }
        });
        Date_L0_6_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDateSelected("31");
            }
        });

        txtDate_Input.performClick();
    }

    private void initializeUIControls(View rootView) throws Exception {
        ((Activity) mCon).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the blinking time with this parameter
        anim.setStartOffset(560);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        ((Activity) mCon).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        txtMonth_Input = (TextView) rootView.findViewById(R.id.txtMonth_Input);
        txtDate_Input = (TextView) rootView.findViewById(R.id.txtDate_Input);
        txtYear_Input = (TextView) rootView.findViewById(R.id.txtYear_Input);
        txtMonth_Input.setInputType(InputType.TYPE_NULL);
        txtDate_Input.setInputType(InputType.TYPE_NULL);
        txtYear_Input.setInputType(InputType.TYPE_NULL);
       /* keyboardHide(mCon, txtDate_Input);
        keyboardHide(mCon, txtYear_Input);
        keyboardHide(mCon, txtMonth_Input);*/
        lblTransactionAmountBasedOnType = (TextView) rootView.findViewById(R.id.lblTransactionAmountBasedOnType);

        txtDate = (TextView) rootView.findViewById(R.id.txtDate);
        txtMonth = (TextView) rootView.findViewById(R.id.txtMonth);
        txtYear = (TextView) rootView.findViewById(R.id.txtYear);
        layoutFragmentContainerInMobileNumberInput = (LinearLayout) rootView.findViewById(R.id.layoutFragmentContainerInMobileNumberInput);

        layoutFragmentContainerInMobileNumberInput_date = (LinearLayout) rootView.findViewById(R.id.layoutFragmentContainerInMobileNumberInput_date);

        layoutFragmentContainerInMobileNumberInput_numpad = (LinearLayout) rootView.findViewById(R.id.layoutFragmentContainerInMobileNumberInput_numpad);
        Year_L0_1 = (LinearLayout) rootView.findViewById(R.id.Year_L0_1);
        Year_L0_2 = (LinearLayout) rootView.findViewById(R.id.Year_L0_2);
        displayTextBuilder = new StringBuilder("");
        numberFormat = NumberFormat.getCurrencyInstance();
        decimalFormat = new DecimalFormat(pattern);
        txtYearUpper = (TextView) rootView.findViewById(R.id.txtYearUpper);
        txtYearLower = (TextView) rootView.findViewById(R.id.txtYearLower);


        now = Calendar.getInstance();   // Gets the current date and time
        year = now.get(Calendar.YEAR);
        txtYearUpper.setText(getBanglaFromEnglish(year));
        txtYearLower.setText(getBanglaFromEnglish(year - 1));
        isYearSelected(year);


        L0_1_1 = (LinearLayout) rootView.findViewById(R.id.L0_1_1);
        L0_1_2 = (LinearLayout) rootView.findViewById(R.id.L0_1_2);
        L0_1_3 = (LinearLayout) rootView.findViewById(R.id.L0_1_3);
        L0_2_1 = (LinearLayout) rootView.findViewById(R.id.L0_2_1);
        L0_2_2 = (LinearLayout) rootView.findViewById(R.id.L0_2_2);
        L0_2_3 = (LinearLayout) rootView.findViewById(R.id.L0_2_3);
        L0_3_1 = (LinearLayout) rootView.findViewById(R.id.L0_3_1);
        L0_3_2 = (LinearLayout) rootView.findViewById(R.id.L0_3_2);
        L0_3_3 = (LinearLayout) rootView.findViewById(R.id.L0_3_3);
        L0_4_1 = (LinearLayout) rootView.findViewById(R.id.L0_4_1);
        L0_4_2 = (LinearLayout) rootView.findViewById(R.id.L0_4_2);
        L0_4_3 = (LinearLayout) rootView.findViewById(R.id.L0_4_3);

        Date_L0_1_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_1);
        Date_L0_1_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_2);
        Date_L0_1_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_3);
        Date_L0_1_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_4);
        Date_L0_1_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_5);
        Date_L0_1_6 = (LinearLayout) rootView.findViewById(R.id.Date_L0_1_6);
        Date_L0_2_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_1);
        Date_L0_2_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_2);
        Date_L0_2_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_3);
        Date_L0_2_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_4);
        Date_L0_2_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_5);
        Date_L0_2_6 = (LinearLayout) rootView.findViewById(R.id.Date_L0_2_6);
        Date_L0_3_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_1);
        Date_L0_3_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_2);
        Date_L0_3_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_3);
        Date_L0_3_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_4);
        Date_L0_3_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_5);
        Date_L0_3_6 = (LinearLayout) rootView.findViewById(R.id.Date_L0_3_6);
        Date_L0_4_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_1);
        Date_L0_4_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_2);
        Date_L0_4_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_3);
        Date_L0_4_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_4);
        Date_L0_4_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_5);
        Date_L0_4_6 = (LinearLayout) rootView.findViewById(R.id.Date_L0_4_6);
        Date_L0_5_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_1);
        Date_L0_5_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_2);
        Date_L0_5_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_3);
        Date_L0_5_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_4);
        Date_L0_5_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_5);
        Date_L0_5_6 = (LinearLayout) rootView.findViewById(R.id.Date_L0_5_6);
        Date_L0_6_1 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_1);
        Date_L0_6_2 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_2);
        Date_L0_6_3 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_3);
        Date_L0_6_4 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_4);
        Date_L0_6_5 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_5);
        Date_L0_6_6 = (LinearLayout) rootView.findViewById(R.id.Date_L0_6_6);

        /*edit=(EditText) view.findViewById(R.id.editText1);

        //cada vez que se modifique texto llamar
        edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
                final String edit11 = edit.getText().toString();
                listener.onEditPressed1(edit11);

            }
        });*/
    }

    private void isYearSelected(int value) throws Exception {
        if (value == year) {
            Year_L0_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Year_L0_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtYear_Input.setText(getBanglaFromEnglish(value));
        } else if (value == (year - 1)) {
            Year_L0_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Year_L0_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtYear_Input.setText(getBanglaFromEnglish(value));
        }
    }

    private void isDateSelected(String value) {
        if (value.compareToIgnoreCase("1") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_1));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("2") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_2));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("3") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_3));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("4") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_4));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("5") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_5));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("6") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_6));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("7") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_7));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("8") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_8));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("9") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_9));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("10") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_10));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("11") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_11));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("12") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_12));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("13") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_13));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("14") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_14));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("15") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_15));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("16") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_16));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("17") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_17));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("18") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_18));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("19") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_19));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("20") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_20));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("21") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_21));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("22") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_22));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("23") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_23));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("24") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_24));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("25") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_25));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("26") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_26));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("27") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_27));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("28") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_28));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("29") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_29));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("30") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_30));
            txtMonth_Input.performClick();
        } else if (value.compareToIgnoreCase("31") == 0) {
            Date_L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_1_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_2_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_3_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_4_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_1.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_5_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            Date_L0_6_2.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_3.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_4.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_5.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            Date_L0_6_6.setBackground(getResources().getDrawable(R.drawable.keypad_date_border));
            txtDate_Input.setText(getResources().getString(R.string.date_bangla_31));
            txtMonth_Input.performClick();
        }
    }

    private void isSelected(String value) {
        if (value.compareToIgnoreCase("January") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_01));
            txtYear_Input.performClick();

        } else if (value.compareToIgnoreCase("February") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_02));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("March") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_03));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("April") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_04));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("May") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_05));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("June") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_06));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("July") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_07));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("August") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_08));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("September") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_09));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("October") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_10));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("November") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_11));
            txtYear_Input.performClick();
        } else if (value.compareToIgnoreCase("December") == 0) {
            L0_1_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_1_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_2_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_3_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_1.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_2.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
            L0_4_3.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
            txtMonth_Input.setText(getResources().getString(R.string.bangla_12));
            txtYear_Input.performClick();
        }


    }

    private void isSelected(LinearLayout l0, String value, TextView textView) {

        if (value.compareToIgnoreCase("January") == 0) {
            if (res_January == 0) {
                res_January = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_January = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("February") == 0) {
            if (res_February == 0) {
                res_February = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_February = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("March") == 0) {
            if (res_March == 0) {
                res_March = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_March = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("April") == 0) {
            if (res_April == 0) {
                res_April = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_April = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("May") == 0) {
            if (res_May == 0) {
                res_May = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_May = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("June") == 0) {
            if (res_June == 0) {
                res_June = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_June = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("July") == 0) {
            if (res_July == 0) {
                res_July = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_July = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("August") == 0) {
            if (res_August == 0) {
                res_August = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_August = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("September") == 0) {
            if (res_September == 0) {
                res_September = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_September = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("October") == 0) {
            if (res_October == 0) {
                res_October = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_October = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }

        } else if (value.compareToIgnoreCase("November") == 0) {
            if (res_November == 0) {
                res_November = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_November = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }
        } else if (value.compareToIgnoreCase("December") == 0) {
            if (res_December == 0) {
                res_December = 1;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border_selected));
                stringBuilder.append(value);
                textView.setText(stringBuilder);
            } else {
                res_December = 0;
                l0.setBackground(getResources().getDrawable(R.drawable.keypad_month_border));
                deleteLastString(value, stringBuilder);
                textView.setText(stringBuilder);
            }


        }

    }


    public static StringBuilder deleteLastString(String prefix, StringBuilder sb) {
        int last = sb.lastIndexOf(prefix);
        Log.d("TAG", "::DATA::" + (last + "=" + prefix.length() + "=" + (sb.length() - prefix.length())));
        if (last >= 0) {
            sb.delete(last, last + (prefix.length()));
        }
        return sb;

    }

    private void keyboardHide(Context mContext, EditText filterEditText) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(filterEditText.getWindowToken(), 0);
    }

    private void blink(final TextView txt) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 500;    //in milliseconds
                try {
                    Thread.sleep(timeToBlink);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        if (txt.getVisibility() == View.VISIBLE) {
                            txt.setVisibility(View.INVISIBLE);
                        } else {
                            txt.setVisibility(View.VISIBLE);
                        }
                        blink(txt);
                    }
                });
            }
        }).start();
    }

    public static String getBanglaFromEnglish(int intNum) throws Exception {

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

}
