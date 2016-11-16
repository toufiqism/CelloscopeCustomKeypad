package android.csb.net.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Tofiq Akbar on 11/16/16.
 */

public class CelloscopeKeypadView extends LinearLayout {
    int row, column;
    LinearLayout.LayoutParams celloscopeKeypadLayoutParamsForMonthKeyboard = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    Context context;

    public CelloscopeKeypadView(Context context, int row, int column) {
        super(context);
        this.row = row;
        this.column = column;
        this.context = context;
        initUtils();
    }

    public CelloscopeKeypadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initUtils();
    }

    public CelloscopeKeypadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initUtils();
    }

    private void initUtils() {
        setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                MonthKeyboardView monthKeyboardView = new MonthKeyboardView(context);
                LinearLayout.LayoutParams celloscopeKeypadLayoutParamsForMonthKeyboard = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                monthKeyboardView.setLayoutParams(celloscopeKeypadLayoutParamsForMonthKeyboard);
                addView(monthKeyboardView, j, celloscopeKeypadLayoutParamsForMonthKeyboard);
            }
        }
    }
}
