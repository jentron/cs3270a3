package com.jentronics.cs3270a3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TotalsFragment extends Fragment {
    private View root;
    private TextView tvCount;

    public TotalsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_totals, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();

        tvCount = (TextView) root.findViewById(R.id.tvCount);

    }

    public void updateCount(int c){
        tvCount.setText("The button as been pressed: " +c+" times.");
    }
}
