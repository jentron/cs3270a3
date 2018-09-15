package com.jentronics.cs3270a3;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleGameFrag extends Fragment {

    private View root;
    private Button btn_rock;
    private Button btn_paper;
    private Button btn_scissors;
    private TextView sgPhonePick;
    private TextView sgResult;

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

        sgPhonePick = (TextView) root.findViewById(R.id.sg_phone_pick);
        sgResult    = (TextView) root.findViewById(R.id.sg_result);

        btn_rock = (Button)root.findViewById(R.id.btn_rock);
        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int winner = whoWon(Mode.ROCK.ordinal(), getPhonePlay());
                mCallBack.handleBtnPress(winner);

            }
        });

        btn_paper = (Button)root.findViewById(R.id.btn_paper);
        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int winner = whoWon(Mode.PAPER.ordinal(), getPhonePlay());
                mCallBack.handleBtnPress(winner);
            }
        });

        btn_scissors = (Button)root.findViewById(R.id.btn_scissors);
        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int winner = whoWon(Mode.SCISSORS.ordinal(), getPhonePlay());
                mCallBack.handleBtnPress(winner);


            }
        });

    }

    /**************
     * Game logic below
     **************/
    private void sayWinner(int winner) {
        switch(winner){
            case 0: //tie
                sgResult.setText(R.string.result_tie);
                break;
            case 1: // player wins
               sgResult.setText(R.string.result_win);
                break;
            case 2:
                sgResult.setText(R.string.result_lose);
                break;
        }
    }

    private int whoWon(int playerOne, int playerTwo) {
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
        sayWinner(result);
        return result;
    } // whoWon

    private int getPhonePlay(){

        switch(random.nextInt(3) + 1)
        {
            case 1:
                sgPhonePick.setText(R.string.btn_rock);
                return Mode.ROCK.ordinal();

            case 2:
                sgPhonePick.setText(R.string.btn_paper);
                return Mode.PAPER.ordinal();

            case 3:
                sgPhonePick.setText(R.string.btn_scissors);
                return Mode.SCISSORS.ordinal();

        }
        return Mode.NULL.ordinal();
    } // getPlayMode(String)
}
