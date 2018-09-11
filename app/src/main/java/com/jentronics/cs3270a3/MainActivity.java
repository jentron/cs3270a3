package com.jentronics.cs3270a3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TotalsFragment fragTv;
    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleRockBtn(int count) {
        if(fragTv == null){
            fm = getSupportFragmentManager();
            fragTv = (TotalsFragment) fm.findFragmentById(R.id.fragTotals);
        }
        // update totals
        fragTv.updateCount(count);
    }
}
