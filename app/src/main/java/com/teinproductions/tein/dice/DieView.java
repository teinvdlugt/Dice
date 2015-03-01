package com.teinproductions.tein.dice;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.util.AttributeSet;
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
    private AnimatedVectorDrawable mDrawable;

    public int getPips() {
        return pips;
    }

    public void setPips(int pips) {
        if (pips < 1 || pips > 6) {
            throw new IllegalArgumentException("number of pips must ly between 1 and 6");
        }

        this.pips = pips;
    }

    public DieView(Context context) {
        super(context);
    }

    public void toTwo() {
        mDrawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim_1to2);
        mImageView.setBackground(mDrawable);

        mDrawable.start();
        setPips(2);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mImageView = new ImageView(getContext());
        mDrawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim_1to2);

        mImageView.setBackground(mDrawable);
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
