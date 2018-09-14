package com.jentronics.cs3270a3;


import android.app.Activity;
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
    private Button btn_paper;
    private Button btn_scissors;

    private onButtonListener mCallBack;

    public interface onButtonListener {
        void handleRockBtn();
        void handlePaperBtn();
        void handleScissorsBtn();
    }

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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallBack = (onButtonListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    +" must implement onButtonListern");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        btn_rock = (Button)root.findViewById(R.id.btn_rock);
        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Button has been pressed
                mCallBack.handleRockBtn();

            }
        });

        btn_paper = (Button)root.findViewById(R.id.btn_paper);
        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Button has been pressed
                mCallBack.handlePaperBtn();
            }
        });

        btn_scissors = (Button)root.findViewById(R.id.btn_scissors);
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Button has been pressed

                mCallBack.handleScissorsBtn();

            }
        });

    }
}
