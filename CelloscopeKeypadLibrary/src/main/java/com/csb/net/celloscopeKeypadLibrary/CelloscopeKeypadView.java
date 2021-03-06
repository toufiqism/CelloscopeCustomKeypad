package com.csb.net.celloscopeKeypadLibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.IntRange;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import static android.content.ContentValues.TAG;

/**
 * Created by Tofiq Akbar on 11/16/16.
 */

public class CelloscopeKeypadView extends LinearLayout implements View.OnClickListener {

    TypedArray typedArray;
    // CelloscopeKeypadView celloscopeKeypadView;
    LinearLayout.LayoutParams celloscopeKeypadLayoutParams
            = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 0, 1f);
    LinearLayout.LayoutParams celloscopeKeyViewLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1f);

    Context context;
    private int row, column;
    private int setMonthKeyBorder;
    private CharSequence[] numValuesArray;
    private CharSequence[] alphaValuesArray;
    private boolean isActive;

    private OnMonthKeyClickListener onMonthKeyClickListener;

    protected CelloscopeKeypadView(Context context) {
        super(context);
        this.context = context;
        initUtils();
    }

    public CelloscopeKeypadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setParams(attrs);
        initUtils();
    }

    public CelloscopeKeypadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setParams(attrs);
        initUtils();
    }

    private void setParams(AttributeSet attrs) {
        typedArray = this.context.getTheme().obtainStyledAttributes(attrs, R.styleable.CelloscopeKeypadView, 0, 0);
        this.row = typedArray.getInt(R.styleable.CelloscopeKeypadView_row, 0);
        this.column = typedArray.getInt(R.styleable.CelloscopeKeypadView_column, 0);
        this.setMonthKeyBorder = typedArray.getResourceId(R.styleable.CelloscopeKeypadView_setMonthKeyBorder, 0);
        this.numValuesArray = typedArray.getTextArray(R.styleable.CelloscopeKeypadView_numValue);
        this.alphaValuesArray = typedArray.getTextArray(R.styleable.CelloscopeKeypadView_alphaValue);
        this.isActive = typedArray.getBoolean(R.styleable.CelloscopeKeypadView_isActive, false);
        newInstance(row, column, numValuesArray, alphaValuesArray);
    }

    private void initUtils() {
        setOrientation(LinearLayout.VERTICAL);
        this.setWeightSum(row);
    }


    private void newInstance(int row, int column, CharSequence[] numValue, CharSequence[] alphaValue) {

        for (int i = 0, j = 0; i <= row * column; i++) {
            if (i % row == 0 && getChildCount() < row) {
                final LinearLayout linearRow = new LinearLayout(context);
                linearRow.setOrientation(LinearLayout.HORIZONTAL);
                int temp = j;
                int viewCounter = 0;
                while (j < column + temp) {
                    Log.d(TAG, "newInstance:" + j + "=" + i);
                    MonthKeyView monthKeyboardView = new MonthKeyView(context);
                    monthKeyboardView.setNumValue((String) numValue[j]);
                    monthKeyboardView.setAlphaValue((String) alphaValue[j]);
                    monthKeyboardView.setOnClickListener(this);
                    monthKeyboardView.setBackgroundResource(setMonthKeyBorder);
                    linearRow.setWeightSum(column);
                    linearRow.addView(monthKeyboardView, viewCounter, celloscopeKeyViewLayoutParams);
                    viewCounter++;
                    j++;
                }
                Log.d(TAG, "newInstance: linearRow.getChildCount() " + linearRow.getChildCount());
                addView(linearRow, i / row, celloscopeKeypadLayoutParams);
            }

        }
        invalidate();
        requestLayout();
        Log.d(TAG, "newInstance: getChildCount() " + getChildCount());

    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public MonthKeyView getItemAt(int row, int column) {
        LinearLayout childAt = (LinearLayout) this.getChildAt(row);
        return (MonthKeyView) childAt.getChildAt(column);

    }

    public void setOnMonthKeyClickListener(OnMonthKeyClickListener onMonthKeyClickListener) {
        this.onMonthKeyClickListener = onMonthKeyClickListener;
    }

    @Override
    public void onClick(View view) {
        if (onMonthKeyClickListener != null) {
            MonthKeyView monthKeyView = (MonthKeyView) view;
            onMonthKeyClickListener.onMonthKeyClicked(monthKeyView, monthKeyView.getNumValue());
        }
    }

    public int getSetMonthKeyBorder() {
        return setMonthKeyBorder;
    }

    public void setSetMonthKeyBorder(int setMonthKeyBorder) {
        this.setMonthKeyBorder = setMonthKeyBorder;
    }

    public interface OnMonthKeyClickListener {
        void onMonthKeyClicked(MonthKeyView monthKeyView, String numValue);
    }


}
