package com.teinproductions.tein.dice;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.GridLayout;

import java.util.ArrayList;


public class DieContainer extends GridLayout {

    private static final int DEFAULT_DICE_WIDTH_DIP = 120;
    private ArrayList<DieView> dice = new ArrayList<>();
    private int dicePixelWidth;

    private void restoreDefaultDiceWidth() {
        dicePixelWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_DICE_WIDTH_DIP, getResources().getDisplayMetrics());
    }

    private void resetColumnCount() {
        setColumnCount(Math.round(getWidth() / dicePixelWidth));

        // Adapt dicePixelWidth to columns to exactly fill in the columns
        dicePixelWidth = getWidth() / getColumnCount();

        int columns = getColumnCount();
        while ((dice.size() / columns + 1) * dicePixelWidth > getHeight()) {
            columns++;
        }

        if (getColumnCount() != columns) {
            setColumnCount(columns);
            dicePixelWidth = getWidth() / getColumnCount();

            reloadDieViews();
        }
    }

    private void reloadDieViews() {
        removeAllViews();
        for (DieView die : dice) {
            die.getLayoutParams().width = dicePixelWidth;
            die.getLayoutParams().height = dicePixelWidth;
            addView(die);
        }
    }

    private void removeDice() {
        this.dice.clear();
        removeAllViews();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        restoreDefaultDiceWidth();
        resetColumnCount();

        int amount = dice.size();
        removeDice();
        addDice(amount);
    }

    public void addDie() {
        if (getColumnCount() > 0 && getHeight() > 0 && ((dice.size() + 1) / getColumnCount() + 1) * dicePixelWidth > getHeight()) {
            resetColumnCount();
        }

        DieView newDie = new DieView(getContext());
        newDie.setRandomPips();

        LayoutParams p = new LayoutParams();
        p.width = dicePixelWidth;
        p.height = dicePixelWidth;
        newDie.setLayoutParams(p);
        addView(newDie);
        dice.add(newDie);
    }

    public void removeDie() {
        removeView(dice.remove(dice.size() - 1));
    }

    public void addDice(int amount) {
        for (int i = 0; i < amount; i++) addDie();
    }

    public void goRandom() {
        for (DieView die : dice)
            die.setRandomPips();
    }


    public DieContainer(Context context) {
        super(context);
    }

    public DieContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DieContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DieContainer(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
