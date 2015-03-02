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

    private int pips = ONE;
    private ImageView mImageView;
    private AnimatedVectorDrawable mDrawable;
    private int drawableResource = R.drawable.anim_1to2;

    public int getPips() {
        return pips;
    }

    public void setPips(int pips) {
        if (pips < 1 || pips > 6) {
            throw new IllegalArgumentException("number of pips must ly between 1 and 6");
        } else if (pips == this.pips) {
            return;
        }

        switch (pips) {
            case ONE:
                toOne();
                break;
            case TWO:
                toTwo();
                break;
            case THREE:
                toThree();
                break;
            case FOUR:
                toFour();
                break;
            case FIVE:
                toFive();
                break;
            case SIX:
                toSix();
        }

        mDrawable = (AnimatedVectorDrawable) getResources().getDrawable(drawableResource);
        mImageView.setBackground(mDrawable);
        mDrawable.start();
        this.pips = pips;
    }

    public DieView(Context context) {
        super(context);
    }

    public void toOne() {
        switch (pips) {
            case ONE:
                return;
            case TWO:
                drawableResource = R.drawable.anim_2to1;
                break;
            case THREE:
                drawableResource = R.drawable.anim_3to1;
                break;
            case FOUR:
                drawableResource = R.drawable.anim_4to1;
                break;
            case FIVE:
                drawableResource = R.drawable.anim_5to1;
                break;
            case SIX:
                drawableResource = R.drawable.anim_6to1;
            default:
                break;
        }
    }

    public void toTwo() {
        switch (pips) {
            case ONE:
                drawableResource = R.drawable.anim_1to2;
                break;
            case TWO:
                return;
            case THREE:
                drawableResource = R.drawable.anim_3to2;
                break;
            case FOUR:
                drawableResource = R.drawable.anim_4to2;
                break;
            case FIVE:
                drawableResource = R.drawable.anim_5to2;
                break;
            case SIX:
                drawableResource = R.drawable.anim_6to2;
            default:
                break;
        }
    }

    public void toThree() {
        switch (pips) {
            case ONE:
                drawableResource = R.drawable.anim_1to3;
                break;
            case TWO:
                drawableResource = R.drawable.anim_2to3;
                break;
            case THREE:
                return;
            case FOUR:
                drawableResource = R.drawable.anim_4to3;
                break;
            case FIVE:
                drawableResource = R.drawable.anim_5to3;
                break;
            case SIX:
                drawableResource = R.drawable.anim_6to3;
            default:
                break;
        }
    }

    public void toFour() {
        switch (pips) {
            case ONE:
                drawableResource = R.drawable.anim_1to4;
                break;
            case TWO:
                drawableResource = R.drawable.anim_2to4;
                break;
            case THREE:
                drawableResource = R.drawable.anim_3to4;
                break;
            case FOUR:
                return;
            case FIVE:
                drawableResource = R.drawable.anim_5to4;
                break;
            case SIX:
                drawableResource = R.drawable.anim_6to4;
            default:
                break;
        }
    }

    public void toFive() {
        switch (pips) {
            case ONE:
                drawableResource = R.drawable.anim_1to5;
                break;
            case TWO:
                drawableResource = R.drawable.anim_2to5;
                break;
            case THREE:
                drawableResource = R.drawable.anim_3to5;
                break;
            case FOUR:
                drawableResource = R.drawable.anim_4to5;
                break;
            case FIVE:
                return;
            case SIX:
                drawableResource = R.drawable.anim_6to5;
                break;
            default:
                break;
        }
    }

    public void toSix() {
        switch (pips) {
            case ONE:
                drawableResource = R.drawable.anim_1to6;
                break;
            case TWO:
                drawableResource = R.drawable.anim_2to6;
                break;
            case THREE:
                drawableResource = R.drawable.anim_3to6;
                break;
            case FOUR:
                drawableResource = R.drawable.anim_4to6;
                break;
            case FIVE:
                drawableResource = R.drawable.anim_5to6;
                break;
            case SIX:
                return;
            default:
                break;
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mImageView = new ImageView(getContext());
        mDrawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim_1to2);
        this.pips = ONE;

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
