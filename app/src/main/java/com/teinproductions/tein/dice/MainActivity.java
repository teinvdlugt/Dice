package com.teinproductions.tein.dice;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private static final String PIPS_1 = "PIPS_OF_DIE_VIEW_1";
    private static final String PIPS_2 = "PIPS_OF_DIE_VIEW_2";

    private boolean dancing = false;
    private Dancer dancer;
    private DieContainer dieContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dieContainer = (DieContainer) findViewById(R.id.dieContainer);
        dieContainer.addDie();
    }

    public void onClickGo(View view) {
        dieContainer.goRandom();
    }

    public void onClickDance(View view) {
        if (dancing) {
            dancer.cancel(true);
            dancing = false;
        } else {
            dancer = new Dancer();
            dancer.execute();
            dancing = true;
        }
    }

    public void onClickAdd(View view) {
        dieContainer.addDie();
    }

    public void onClickRemove(View view) {
        dieContainer.removeDie();
    }

    @Override
    protected void onPause() {
        if (dancer != null) {
            dancer.cancel(true);
        }
        super.onPause();
    }

    class Dancer extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            //noinspection ConstantConditions
            while (1 + 1 == 2) {
                if (isCancelled()) {
                    return null;
                }
                publishProgress();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            onClickGo(null);
        }
    }
}