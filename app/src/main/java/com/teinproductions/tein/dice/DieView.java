package com.teinproductions.tein.dice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DieView extends ImageView {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;

    private int pips = SIX;

    public int getPips() {
        return pips;
    }

    public void setPips() {

    }

    public DieView(Context context) {
        super(context);
        setBackgroundResource(R.drawable.die_view);
    }

    public DieView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DieView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
