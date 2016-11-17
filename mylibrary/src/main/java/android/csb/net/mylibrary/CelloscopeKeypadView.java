package android.csb.net.mylibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.ArrayRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import static android.content.ContentValues.TAG;

/**
 * Created by Tofiq Akbar on 11/16/16.
 */

public class CelloscopeKeypadView extends LinearLayout {

    TypedArray typedArray;
    // CelloscopeKeypadView celloscopeKeypadView;
    LinearLayout.LayoutParams celloscopeKeypadLayoutParams
            = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    LinearLayout.LayoutParams celloscopeKeyViewLayoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    Context context;
    private int row, column;
    private CharSequence[] numValuesArray;
    private CharSequence[] alphaValuesArray;

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
        this.numValuesArray = typedArray.getTextArray(R.styleable.CelloscopeKeypadView_numValue);
        this.alphaValuesArray = typedArray.getTextArray(R.styleable.CelloscopeKeypadView_alphaValue);
        newInstance(row, column, numValuesArray, alphaValuesArray);
    }

    private void initUtils() {
        setOrientation(LinearLayout.VERTICAL);
    }


    private void newInstance(int row, int column, CharSequence[] numValue, CharSequence[] alphaValue) {

        for (int i = 0, j = 0; i <= row * column; i++) {
            if (i % row == 0 && getChildCount() < row) {
                final LinearLayout linearRow = new LinearLayout(context);
                linearRow.setOrientation(LinearLayout.HORIZONTAL);
                int temp = j;
                int viewCounter = 0;
                while (j < column + temp) {
                    Log.d(TAG, "newInstance: " + j + "=" + i);
                    MonthKeyboardView monthKeyboardView = new MonthKeyboardView(context);
                    monthKeyboardView.setNumValue((String) numValue[j]);
                    monthKeyboardView.setAlphaValue((String) alphaValue[j]);
                    linearRow.addView(monthKeyboardView, viewCounter, celloscopeKeyViewLayoutParams);

                    viewCounter++;
                    j++;
                    switch (j % 2) {
                        case 0:
                            monthKeyboardView.setBackgroundColor(Color.GREEN);
                            break;
                        case 1:
                            monthKeyboardView.setBackgroundColor(Color.WHITE);
                            break;
                        default:
                    }
                }
                Log.d(TAG, "newInstance: linearRow.getChildCount() " + linearRow.getChildCount());
                addView(linearRow, i / row, celloscopeKeypadLayoutParams);
            }

        }
        invalidate();
        requestLayout();
        Log.d(TAG, "newInstance: getChildCount() " + getChildCount());

    }


}
