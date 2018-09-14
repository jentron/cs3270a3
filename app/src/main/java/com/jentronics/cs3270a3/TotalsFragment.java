package com.jentronics.cs3270a3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TotalsFragment extends Fragment {
    private View root;
    private TextView tvCount;
    private Button btn_reset;

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
        btn_reset = root.findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), R.string.toast_message, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    public void updateCount(int c){
        tvCount.setText("The button as been pressed: " +c+" times.");
    }
}
