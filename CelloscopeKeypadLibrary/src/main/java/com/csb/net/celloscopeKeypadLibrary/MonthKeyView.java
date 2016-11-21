package com.csb.net.celloscopeKeypadLibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LruCache;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;
import static com.csb.net.celloscopeKeypadLibrary.Utility.convertPixelsToDp;

/**
 * Created by Tofiq Akbar on 11/15/16.
 */

public class MonthKeyView extends FrameLayout {
    TextView numericMonthTextView;
    TextView alphaMonthTextView;

    String numTVFont, alphaTVFont;
    private static LruCache<String, Typeface> sTypefaceCache =
            new LruCache<String, Typeface>(12);
    /*The class implements a static LruCache to avoid unnecessary hits to disk for fonts that were previously loaded. Note that if you’re targeting API levels prior to 12 the LruCache is only available using the Android support library.*/
    String numValue;
    int numTVColor;
    float numTVSize;
    String alphaValue;
    int alphaTVColor;
    float alphaTVSize;
    Context context;
    FrameLayout.LayoutParams numericMonthTextViewFrameLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
    FrameLayout.LayoutParams alphaMonthTextViewFrameLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);


    protected MonthKeyView(Context context) {
        super(context);
        this.context = context;
        initUtils();
    }

    public MonthKeyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setParams(attrs);
        initUtils();
    }

    public MonthKeyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setParams(attrs);
        initUtils();
    }

    private void setParams(AttributeSet attrs) {
        TypedArray typedArray = this.context.getTheme().obtainStyledAttributes(attrs, R.styleable.MonthKeyView, 0, 0);
        numValue = typedArray.getString(R.styleable.MonthKeyView_numericLabel);
        numTVColor = typedArray.getInt(R.styleable.MonthKeyView_numericTextColor, Color.BLACK);
        numTVSize = typedArray.getDimension(R.styleable.MonthKeyView_numericTextSize, convertPixelsToDp(16, context));
        numTVFont = typedArray.getString(R.styleable.MonthKeyView_numTextViewFont);
        alphaValue = typedArray.getString(R.styleable.MonthKeyView_alphaLabel);
        alphaTVColor = typedArray.getInt(R.styleable.MonthKeyView_alphaTextColor, Color.BLACK);
        alphaTVSize = typedArray.getDimension(R.styleable.MonthKeyView_alphaTextSize, convertPixelsToDp(16, context));
        alphaTVFont = typedArray.getString(R.styleable.MonthKeyView_alphaTextViewFont);
    }

    private void initUtils() {
        //setOrientation(LinearLayout.VERTICAL);
        //init Views
        numericMonthTextView = new TextView(context);
        alphaMonthTextView = new TextView(context);
        //add Views
        //numericMonthTextViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        if (alphaValue == null) {
            numericMonthTextViewFrameLayoutParams.gravity = Gravity.CENTER;
            addView(numericMonthTextView, 0, numericMonthTextViewFrameLayoutParams);
            numericMonthTextView.setTypeface(getTypeface(numTVFont));
            numericMonthTextView.setText(numValue);
            numericMonthTextView.setTextSize(convertPixelsToDp(44, context));
            numericMonthTextView.setTextColor(numTVColor);
        } else if (numValue == null) {
            alphaMonthTextViewFrameLayoutParams.gravity = Gravity.CENTER;
            addView(alphaMonthTextView, 0, alphaMonthTextViewFrameLayoutParams);
            alphaMonthTextView.setTypeface(getTypeface(alphaTVFont));
            alphaMonthTextView.setText(alphaValue);
            alphaMonthTextView.setTextSize(convertPixelsToDp(26, context));
            alphaMonthTextView.setTextColor(alphaTVColor);
        } else {
            numericMonthTextViewFrameLayoutParams.gravity = Gravity.CENTER;
            addView(numericMonthTextView, 0, numericMonthTextViewFrameLayoutParams);
            alphaMonthTextViewFrameLayoutParams.gravity = Gravity.BOTTOM | Gravity.CENTER;
            addView(alphaMonthTextView, 1, alphaMonthTextViewFrameLayoutParams);
            numericMonthTextView.setTypeface(getTypeface(numTVFont));
            numericMonthTextView.setText(numValue);
            numericMonthTextView.setTextSize(convertPixelsToDp(numTVSize, context));
            numericMonthTextView.setTextColor(numTVColor);
            alphaMonthTextView.setTypeface(getTypeface(alphaTVFont));
            alphaMonthTextView.setText(alphaValue);
            alphaMonthTextView.setTextColor(alphaTVColor);
            alphaMonthTextView.setTextSize(convertPixelsToDp(alphaTVSize, context));
        }


    }

    private Typeface getTypeface(String fontName) {
        if (fontName != null) {
            Typeface tf = sTypefaceCache.get(fontName);
            if (tf == null) {
                try {
                    tf = Typeface.createFromAsset(context.getAssets(), fontName);
                } catch (RuntimeException e) {
                    Log.w("MonthKeyboardView", "getTypeface: " + "Please Ensure that the selected font is in the Assets Folder.");
                    e.printStackTrace();
                }
            } else {
                tf = Typeface.DEFAULT;
            }
            return tf;
        } else {
            return Typeface.DEFAULT;
        }
    }

    public String getNumValue() {
        return numValue;
    }

    public void setNumValue(String numValue) {
        this.numValue = numValue;
        numericMonthTextView.setTypeface(getTypeface(numTVFont));
        numericMonthTextView.setText(numValue);
        numericMonthTextView.setTextSize(convertPixelsToDp(44, context));
        numericMonthTextView.setTextColor(Color.BLACK);
        invalidate();
        requestLayout();
    }

    public String getAlphaValue() {
        return alphaValue;
    }

    public void setAlphaValue(String alphaValue) {
        this.alphaValue = alphaValue;
        alphaMonthTextView.setText(this.numValue);
        alphaMonthTextView.setTextColor(Color.BLACK);
        alphaMonthTextView.setTextSize(convertPixelsToDp(24, context));
        alphaMonthTextView.setTypeface(getTypeface(alphaTVFont));
        invalidate();
        requestLayout();
    }


}
