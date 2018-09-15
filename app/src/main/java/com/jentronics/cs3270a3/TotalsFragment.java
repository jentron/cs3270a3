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
    private TextView tvPlayerWins;
    private TextView tvPhoneWins;
    private TextView tvTies;
    private Button btn_reset;

    private int gameCount = 0;
    private int gameMyWins = 0;
    private int gamePhoneWins = 0;
    private int gameTies = 0;

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

        tvCount      = (TextView) root.findViewById(R.id.tvCount);
        tvPlayerWins = (TextView) root.findViewById(R.id.tvMyWinCount);
        tvPhoneWins  = (TextView) root.findViewById(R.id.tvPhoneWinCount);
        tvTies       = (TextView) root.findViewById(R.id.tvTieGameCount);
        btn_reset = root.findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), R.string.toast_message, Toast.LENGTH_SHORT);
                toast.show();
                gameCount = 0;
                gameMyWins = 0;
                gamePhoneWins = 0;
                gameTies = 0;
                tvCount.setText(Integer.toString(gameCount));
                tvPlayerWins.setText(Integer.toString(gameMyWins));
                tvPhoneWins.setText(Integer.toString(gamePhoneWins));
                tvTies.setText(Integer.toString(gameTies));
            }
        });

    }

    public void updateCount(int winner){
        gameCount ++;
        switch(winner){
            case 0: //tie
                gameTies++;
                break;
            case 1: // player wins
                gameMyWins++;
                break;
            case 2:
                gamePhoneWins++;
                break;
        }
        tvCount.setText(Integer.toString(gameCount));
        tvPlayerWins.setText(Integer.toString(gameMyWins));
        tvPhoneWins.setText(Integer.toString(gamePhoneWins));
        tvTies.setText(Integer.toString(gameTies));
    }
}
