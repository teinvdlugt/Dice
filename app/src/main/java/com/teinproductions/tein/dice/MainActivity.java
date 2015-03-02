package com.teinproductions.tein.dice;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private DieView dieView1, dieView2;
    private Button danceButton;

    private boolean dancing = false;
    private Dancer dancer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dieView1 = (DieView) findViewById(R.id.die_view1);
        dieView2 = (DieView) findViewById(R.id.die_view2);
        danceButton = (Button) findViewById(R.id.dance_button);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickGo(View view) {
        final int pips1 = (int) Math.floor(Math.random() * 6) + 1;
        final int pips2 = (int) Math.floor(Math.random() * 6) + 1;
        dieView1.setPips(pips1);
        dieView2.setPips(pips2);
    }

    public void onClickDance(View view) {
        if (dancing) {
            dancer.cancel(true);
            danceButton.setText(R.string.dance);
            dancing = false;
        } else {
            dancer = new Dancer();
            dancer.execute();
            dancing = true;
            danceButton.setText(R.string.stop_dancing);
        }
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