package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreAwayTeam = 0;
    int outAwayTeam = 0;
    int strikeAwayTeam = 0;
    int ballFoulAwayTeam = 0;
    int scoreHomeTeam = 0;
    int outHomeTeam = 0;
    int strikeHomeTeam = 0;
    int ballFoulHomeTeam = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    Spinner spinner = (Spinner) findViewById(R.id.spinner);
//    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//            R.array.baseball_team_names, android.R.layout.simple_spinner_item);
//    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//    spinner.setAdapter(adapter);
//
//    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {
//
//    }

    public void addRunAwayTeam(View view) {
        scoreAwayTeam = scoreAwayTeam + 1;
        displayRunAwayTeam(scoreAwayTeam);
    }

    public void addOutAwayTeam(View view) {
        outAwayTeam = outAwayTeam + 1;
        displayOutAwayTeam(outAwayTeam);
    }

    public void addStrikeAwayTeam(View view) {
        strikeAwayTeam = strikeAwayTeam + 1;
        displayStrikeAwayTeam(strikeAwayTeam);
    }

    public void addBallFoulAwayTeam(View view) {
        ballFoulAwayTeam = ballFoulAwayTeam + 1;
        displayBallFoulAwayTeam(ballFoulAwayTeam);
    }

    public void addRunHomeTeam(View view) {
        scoreHomeTeam = scoreHomeTeam + 1;
        displayRunHomeTeam(scoreHomeTeam);
    }

    public void addOutHomeTeam(View view) {
        outHomeTeam = outHomeTeam + 1;
        displayOutHomeTeam(outHomeTeam);
    }

    public void addStrikeHomeTeam(View view) {
        strikeHomeTeam = strikeHomeTeam + 1;
        displayStrikeHomeTeam(strikeHomeTeam);
    }

    public void addBallFoulHomeTeam(View view) {
        ballFoulHomeTeam = ballFoulHomeTeam + 1;
        displayBallFoulHomeTeam(ballFoulHomeTeam);
    }

    public void reset(View view) {
        scoreAwayTeam = 0;
        outAwayTeam = 0;
        strikeAwayTeam = 0;
        ballFoulAwayTeam = 0;
        scoreHomeTeam = 0;
        outHomeTeam = 0;
        strikeHomeTeam = 0;
        ballFoulHomeTeam = 0;
        displayRunAwayTeam(scoreAwayTeam);
        displayOutAwayTeam(outAwayTeam);
        displayStrikeAwayTeam(strikeAwayTeam);
        displayBallFoulAwayTeam(ballFoulAwayTeam);
        displayRunHomeTeam(scoreHomeTeam);
        displayOutHomeTeam(outHomeTeam);
        displayStrikeHomeTeam(strikeHomeTeam);
        displayBallFoulHomeTeam(ballFoulHomeTeam);
    }

    public void displayRunAwayTeam(int score) {
        TextView scoreView = findViewById(R.id.away_team_run);
        scoreView.setText(String.valueOf(score));
    }

    public void displayOutAwayTeam(int outs) {
        TextView outView = findViewById(R.id.away_team_outs);
        outView.setText(String.valueOf(outs));
    }

    public void displayStrikeAwayTeam(int strike) {
        TextView strikeView = findViewById(R.id.away_team_strikes);
        strikeView.setText(String.valueOf(strike));
    }

    public void displayBallFoulAwayTeam(int ballFoul) {
        TextView ballFoulView = findViewById(R.id.away_team_ball_foul);
        ballFoulView.setText(String.valueOf(ballFoul));
    }

    public void displayRunHomeTeam(int score) {
        TextView scoreView = findViewById(R.id.home_team_runs);
        scoreView.setText(String.valueOf(score));
    }

    public void displayOutHomeTeam(int outs) {
        TextView outView = findViewById(R.id.home_team_outs);
        outView.setText(String.valueOf(outs));
    }

    public void displayStrikeHomeTeam(int strike) {
        TextView strikeView = findViewById(R.id.home_team_strikes);
        strikeView.setText(String.valueOf(strike));
    }

    public void displayBallFoulHomeTeam(int ballFoul) {
        TextView ballFoulView = findViewById(R.id.home_team_ball_foul);
        ballFoulView.setText(String.valueOf(ballFoul));
    }

}
