package com.teinproductions.tein.dice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class DieView extends FrameLayout {

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;

    private int pips = SIX;
    private ImageView mImageView;

    public int getPips() {
        return pips;
    }

    public void setPips() {

    }

    public DieView(Context context) {
        super(context);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mImageView = new ImageView(getContext());
        mImageView.setBackgroundResource(R.drawable.die_view);

        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        this.addView(mImageView, params);
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
