package com.jentronics.cs3270a3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleGameFrag extends Fragment {

    private View root;
    private Button btn_rock;
    private int rock_count = 0;

    public SingleGameFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return root = inflater.inflate(R.layout.fragment_single_game, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        btn_rock = (Button)root.findViewById(R.id.btn_rock);
        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Button has been pressed
                rock_count++;
                MainActivity activity = (MainActivity)getActivity();
                activity.handleRockBtn(rock_count);

            }
        });

    }
}
