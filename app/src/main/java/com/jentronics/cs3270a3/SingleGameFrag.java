package com.jentronics.cs3270a3;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleGameFrag extends Fragment {

    private View root;
    private Button btn_rock;
    private Button btn_paper;
    private Button btn_scissors;

    private onButtonListener mCallBack;

/***
 * Game stuff
 */
    private enum Mode {NULL,ROCK, PAPER, SCISSORS};
    private enum Result {TIE, PLAYERONE, PLAYERTWO}
    private Random random= new Random();

    /***
     * UI Logic
     */
    public interface onButtonListener {
        void handleBtnPress(int winner);
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
                mCallBack.handleBtnPress(0);

            }
        });

        btn_paper = (Button)root.findViewById(R.id.btn_paper);
        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Button has been pressed
                mCallBack.handleBtnPress(1);
            }
        });

        btn_scissors = (Button)root.findViewById(R.id.btn_scissors);
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Button has been pressed

                mCallBack.handleBtnPress(2);


            }
        });

    }

    /**************
     * Game logic below
     **************/


    private static int whoWon(int playerOne, int playerTwo) {
        int result=Result.TIE.ordinal();

        switch( playerOne){
            case 1: // rock
                if(playerTwo == Mode.ROCK.ordinal()) result = Result.TIE.ordinal();  // rock
                else if (playerTwo == Mode.PAPER.ordinal()) result = Result.PLAYERTWO.ordinal(); // paper
                else result = Result.PLAYERONE.ordinal(); // scissors
                break;
            //
            case 2: // paper
                if(playerTwo == Mode.ROCK.ordinal()) result = Result.PLAYERONE.ordinal(); // rock
                else if (playerTwo == Mode.PAPER.ordinal()) result = Result.TIE.ordinal(); // paper
                else result = Result.PLAYERTWO.ordinal(); //scissors
                break;
            //
            case 3: // scissors
                if(playerTwo == Mode.ROCK.ordinal()) result = Result.PLAYERTWO.ordinal(); // rock
                else if (playerTwo == Mode.PAPER.ordinal()) result = Result.PLAYERONE.ordinal(); // paper
                else result = Result.TIE.ordinal(); //scissors
                break;
        } // switch
        return result;
    } // whoWon

    private Mode getPhonePlay(){

        switch(random.nextInt(3) + 1)
        {
            case 1:
                return Mode.ROCK;

            case 2:
                return Mode.PAPER;

            case 3:
                return Mode.SCISSORS;

        }
        return Mode.NULL;
    } // getPlayMode(String)
}
