package android.csb.net.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Tofiq Akbar on 11/15/16.
 */

public class MonthKeyboardView extends FrameLayout {
    TextView numericMonthTextView;
    TextView alphaMonthTextView;

    String numTVFont, alphaTVFont;
    private static LruCache<String, Typeface> sTypefaceCache =
            new LruCache<String, Typeface>(12);
    /*The class implements a static LruCache to avoid unnecessary hits to disk for fonts that were previously loaded. Note that if you’re targeting API levels prior to 12 the LruCache is only available using the Android support library.*/
    String numValue;
    int numTVColor;
    String alphaValue;
    int alphaTVColor;
    float alphaTVSize;
    float numTVSize;

    Context context;
    LayoutParams numericMonthTextViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    LayoutParams alphaMonthTextViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    FrameLayout.LayoutParams numericMonthTextViewFrameLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
    FrameLayout.LayoutParams alphaMonthTextViewFrameLayoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

    public MonthKeyboardView(Context context) {
        super(context);
        this.context = context;
        initUtils();
    }

    public MonthKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        setParams(attrs);
        initUtils();

    }

    public MonthKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setParams(attrs);


        initUtils();


    }

    private void setParams(AttributeSet attrs) {

        TypedArray typedArray = this.context.getTheme().obtainStyledAttributes(attrs, R.styleable.MonthKeyboardView, 0, 0);
        numValue = typedArray.getString(R.styleable.MonthKeyboardView_numericLabel);
        numTVColor = typedArray.getInt(R.styleable.MonthKeyboardView_numericTextColor, 0);
        numTVSize = typedArray.getDimension(R.styleable.MonthKeyboardView_numericTextSize, 16);
        numTVFont = typedArray.getString(R.styleable.MonthKeyboardView_numTextViewFont);
        alphaValue = typedArray.getString(R.styleable.MonthKeyboardView_alphaLabel);
        alphaTVColor = typedArray.getInt(R.styleable.MonthKeyboardView_alphaTextColor, 0);
        alphaTVSize = typedArray.getDimension(R.styleable.MonthKeyboardView_alphaTextSize, 16);
        alphaTVFont = typedArray.getString(R.styleable.MonthKeyboardView_alphaTextViewFont);

    }

    private void initUtils() {
        //setOrientation(LinearLayout.VERTICAL);
        //init Views
        numericMonthTextView = new TextView(context);
        alphaMonthTextView = new TextView(context);

        //add Views
        //numericMonthTextViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        numericMonthTextViewFrameLayoutParams.gravity = Gravity.CENTER;

        addView(numericMonthTextView, 0, numericMonthTextViewFrameLayoutParams);


        alphaMonthTextViewFrameLayoutParams.gravity = Gravity.BOTTOM | Gravity.CENTER;

        addView(alphaMonthTextView, 1, alphaMonthTextViewFrameLayoutParams);


        numericMonthTextView.setTypeface(getTypeface(numTVFont));
        numericMonthTextView.setText(numValue);
        numericMonthTextView.setTextSize(numTVSize);
        numericMonthTextView.setTextColor(numTVColor);


        alphaMonthTextView.setTypeface(getTypeface(alphaTVFont));
        alphaMonthTextView.setText(alphaValue);
        alphaMonthTextView.setTextColor(alphaTVColor);
        alphaMonthTextView.setTextSize(alphaTVSize);


    }

    private Typeface getTypeface(String fontName) {

        Typeface tf = sTypefaceCache.get(fontName);

        if (tf == null) {
            tf = Typeface.createFromAsset(context.getAssets(), fontName);

        }

        return tf;

    }

    public String getNumValue() {
        return numValue;
    }

    public void setNumValue(String numValue) {
        this.numValue = numValue;
        numericMonthTextView.setText(this.numValue);
        invalidate();
        requestLayout();
    }

    public String getAlphaValue() {
        return alphaValue;
    }

    public void setAlphaValue(String alphaValue) {
        this.alphaValue = alphaValue;
        alphaMonthTextView.setText(this.numValue);
        invalidate();
        requestLayout();
    }
}
