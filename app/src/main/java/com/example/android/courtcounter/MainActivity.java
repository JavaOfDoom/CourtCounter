package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreAwayTeam = 0;
    int outAwayTeam = 0;
    int strikeAwayTeam = 0;
    int foulAwayTeam = 0;
    int scoreHomeTeam = 0;
    int outHomeTeam = 0;
    int strikeHomeTeam = 0;
    int foulHomeTeam = 0;
    int currentInning = 1;
    int teamAtBat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

/*    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.baseball_team_names, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);

    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    }*/

    public void addRunAwayTeam(View view) {
        if (teamAtBat == 0) {
            scoreAwayTeam += 1;
            displayRunAwayTeam(scoreAwayTeam);
        } else {
            Toast runHomeAtBat = Toast.makeText(this, "The home team is at bat!", Toast.LENGTH_SHORT);
            runHomeAtBat.setGravity(Gravity.TOP, 0, 150);
            runHomeAtBat.show();
        }
    }

    public void addOutAwayTeam(View view) {
        if (teamAtBat == 0) {
            outAwayTeam += 1;
            displayOutAwayTeam(outAwayTeam);
        } else {
            Toast outHomeAtBat = Toast.makeText(this, "The home team is at bat!", Toast.LENGTH_SHORT);
            outHomeAtBat.setGravity(Gravity.TOP, 0, 150);
            outHomeAtBat.show();
        }
        if (outAwayTeam == 3) {
            teamAtBat = 1;
            Toast awayFinalOut = Toast.makeText(this, "That was 3 outs! It is the bottom of the inning. The home team is at bat now.", Toast.LENGTH_SHORT);
            awayFinalOut.setGravity(Gravity.TOP, 0, 150);
            awayFinalOut.show();
            outAwayTeam = 0;
            strikeAwayTeam = 0;
            foulAwayTeam = 0;
            displayOutAwayTeam(outAwayTeam);
            displayStrikeAwayTeam(strikeAwayTeam);
            displayFoulAwayTeam(foulAwayTeam);
        }
    }

    public void addStrikeAwayTeam(View view) {
        if (teamAtBat == 0) {
            strikeAwayTeam += 1;
            displayStrikeAwayTeam(strikeAwayTeam);
        } else {
            Toast strikeHomeAtBat = Toast.makeText(this, "The home team is at bat!", Toast.LENGTH_SHORT);
            strikeHomeAtBat.setGravity(Gravity.TOP, 0, 150);
            strikeHomeAtBat.show();
        }
        if (strikeAwayTeam == 3) {
            outAwayTeam += 1;
            strikeAwayTeam = 0;
            foulAwayTeam = 0;
            displayOutAwayTeam(outAwayTeam);
            displayStrikeAwayTeam(strikeAwayTeam);
            displayFoulAwayTeam(foulAwayTeam);
            Toast awayStrikeOut = Toast.makeText(this, "3 strikes and you're out!", Toast.LENGTH_SHORT);
            awayStrikeOut.setGravity(Gravity.TOP, 0, 150);
            awayStrikeOut.show();
            if (outAwayTeam == 3) {
                teamAtBat = 1;
                Toast awayFinalStrikeOut = Toast.makeText(this, "That was 3 outs! It is the bottom" +
                        " of the inning. The home team is at bat now.", Toast.LENGTH_SHORT);
                awayFinalStrikeOut.setGravity(Gravity.TOP, 0, 150);
                awayFinalStrikeOut.show();
                outAwayTeam = 0;
                displayOutAwayTeam(outAwayTeam);
            }
        }
    }

    public void addFoulAwayTeam(View view) {
        if (teamAtBat == 0) {
            if (strikeAwayTeam < 2) {
                strikeAwayTeam += 1;
                displayStrikeAwayTeam(strikeAwayTeam);
            } else {
                foulAwayTeam = foulAwayTeam + 1;
                displayFoulAwayTeam(foulAwayTeam);
            }
        } else {
            Toast foulHomeAtBat = Toast.makeText(this, "The home team is at bat!", Toast.LENGTH_SHORT);
            foulHomeAtBat.setGravity(Gravity.TOP, 0, 150);
            foulHomeAtBat.show();
        }
    }

    public void addRunHomeTeam(View view) {
        if (teamAtBat == 1) {
            scoreHomeTeam += 1;
            displayRunHomeTeam(scoreHomeTeam);
        } else {
            Toast runAwayAtBat = Toast.makeText(this, "The away team is at bat!", Toast.LENGTH_SHORT);
            runAwayAtBat.setGravity(Gravity.TOP, 0, 150);
            runAwayAtBat.show();
        }
    }

    public void addOutHomeTeam(View view) {
        if (teamAtBat == 1) {
            outHomeTeam += 1;
            displayOutHomeTeam(outHomeTeam);
        } else {
            Toast outAwayAtBat = Toast.makeText(this, "The away team is at bat!", Toast.LENGTH_SHORT);
            outAwayAtBat.setGravity(Gravity.TOP, 0, 150);
            outAwayAtBat.show();
        }
        if (outHomeTeam == 3) {
            teamAtBat = 0;
            if (currentInning < 9) {
                currentInning += 1;
                displayCurrentInning(currentInning);
                Toast homeFinalOut = Toast.makeText(this, "That was 3 outs! It is the top of" +
                        " a new inning. The away team is at bat now.", Toast.LENGTH_SHORT);
                homeFinalOut.setGravity(Gravity.TOP, 0, 150);
                homeFinalOut.show();
                outHomeTeam = 0;
                strikeHomeTeam = 0;
                foulHomeTeam = 0;
                displayOutHomeTeam(outHomeTeam);
                displayStrikeHomeTeam(strikeHomeTeam);
                displayFoulHomeTeam(foulHomeTeam);
            } else {
                if (scoreHomeTeam == scoreAwayTeam) {
                    currentInning += 1;
                    displayCurrentInning(currentInning);
                    Toast outTiedScore = Toast.makeText(this, "The score is tied! We're " +
                            "going into extra innings", Toast.LENGTH_SHORT);
                    outTiedScore.setGravity(Gravity.TOP, 0, 150);
                    outTiedScore.show();
                    outHomeTeam = 0;
                    strikeHomeTeam = 0;
                    foulHomeTeam = 0;
                    displayOutHomeTeam(outHomeTeam);
                    displayStrikeHomeTeam(strikeHomeTeam);
                    displayFoulHomeTeam(foulHomeTeam);
                } else if (scoreHomeTeam > scoreAwayTeam) {
                    Toast outHomeWins = Toast.makeText(this, "The home team wins!", Toast.LENGTH_SHORT);
                    outHomeWins.setGravity(Gravity.TOP, 0, 150);
                    outHomeWins.show();
                    teamAtBat = 2;
                } else {
                    Toast awayWins = Toast.makeText(this, "The away team wins!", Toast.LENGTH_SHORT);
                    awayWins.setGravity(Gravity.TOP, 0, 150);
                    awayWins.show();
                    teamAtBat = 2;
                }
            }
        }
    }

    public void addStrikeHomeTeam(View view) {
        if (teamAtBat == 1) {
            strikeHomeTeam += 1;
            displayStrikeHomeTeam(strikeHomeTeam);
        } else {
            Toast strikeAwayAtBat = Toast.makeText(this, "The away team is at bat!", Toast.LENGTH_SHORT);
            strikeAwayAtBat.setGravity(Gravity.TOP, 0, 150);
            strikeAwayAtBat.show();
        }
        if (strikeHomeTeam == 3) {
            outHomeTeam += 1;
            strikeHomeTeam = 0;
            foulHomeTeam = 0;
            displayOutHomeTeam(outHomeTeam);
            displayStrikeHomeTeam(strikeHomeTeam);
            displayFoulHomeTeam(foulHomeTeam);
            Toast homeStrikeOut = Toast.makeText(this, "3 strikes and you're out!", Toast.LENGTH_SHORT);
            homeStrikeOut.setGravity(Gravity.TOP, 0, 150);
            homeStrikeOut.show();
            if (outHomeTeam == 3) {
                teamAtBat = 0;
                if (currentInning < 9) {
                    currentInning += 1;
                    displayCurrentInning(currentInning);
                    Toast homeFinalStrikeOut = Toast.makeText(this, "That was 3 outs! It is the top" +
                            " of a new inning. The away team is at bat now.", Toast.LENGTH_SHORT);
                    homeFinalStrikeOut.setGravity(Gravity.TOP, 0, 150);
                    homeFinalStrikeOut.show();
                    outHomeTeam = 0;
                    strikeHomeTeam = 0;
                    foulHomeTeam = 0;
                    displayOutHomeTeam(outHomeTeam);
                    displayStrikeHomeTeam(strikeHomeTeam);
                    displayFoulHomeTeam(foulHomeTeam);
                } else {
                    if (scoreHomeTeam == scoreAwayTeam) {
                        currentInning += 1;
                        displayCurrentInning(currentInning);
                        Toast strikeTiedScore = Toast.makeText(this, "The score is tied! " +
                                "We're going into extra innings", Toast.LENGTH_SHORT);
                        strikeTiedScore.setGravity(Gravity.TOP, 0, 150);
                        strikeTiedScore.show();
                        outHomeTeam = 0;
                        strikeHomeTeam = 0;
                        foulHomeTeam = 0;
                        displayOutHomeTeam(outHomeTeam);
                        displayStrikeHomeTeam(strikeHomeTeam);
                        displayFoulHomeTeam(foulHomeTeam);
                    } else if (scoreHomeTeam > scoreAwayTeam) {
                        Toast strikeHomeWins = Toast.makeText(this, "The home team wins!", Toast.LENGTH_SHORT);
                        strikeHomeWins.setGravity(Gravity.TOP, 0, 150);
                        strikeHomeWins.show();
                        teamAtBat = 2;
                    } else {
                        Toast strikeAwayWins = Toast.makeText(this, "The away team wins!", Toast.LENGTH_SHORT);
                        strikeAwayWins.setGravity(Gravity.TOP, 0, 150);
                        strikeAwayWins.show();
                        teamAtBat = 2;
                    }
                }
            }
        }
    }

    public void addFoulHomeTeam(View view) {
        if (teamAtBat == 1) {
            if (strikeHomeTeam < 2) {
                strikeHomeTeam += 1;
                displayStrikeHomeTeam(strikeHomeTeam);
            } else {
                foulHomeTeam = foulHomeTeam + 1;
                displayFoulHomeTeam(foulHomeTeam);
            }
        } else {
            Toast foulAwayAtBat = Toast.makeText(this, "The away team is at bat!", Toast.LENGTH_SHORT);
            foulAwayAtBat.setGravity(Gravity.TOP, 0, 150);
            foulAwayAtBat.show();
        }
    }

    public void resetStrike(View view) {
        if (teamAtBat == 0) {
            strikeAwayTeam = 0;
            displayStrikeAwayTeam(strikeAwayTeam);
        } else {
            strikeHomeTeam = 0;
            displayStrikeHomeTeam(strikeHomeTeam);
        }
    }

    public void resetAll(View view) {
        scoreAwayTeam = 0;
        outAwayTeam = 0;
        strikeAwayTeam = 0;
        foulAwayTeam = 0;
        scoreHomeTeam = 0;
        outHomeTeam = 0;
        strikeHomeTeam = 0;
        foulHomeTeam = 0;
        currentInning = 1;
        teamAtBat = 0;
        displayRunAwayTeam(scoreAwayTeam);
        displayOutAwayTeam(outAwayTeam);
        displayStrikeAwayTeam(strikeAwayTeam);
        displayFoulAwayTeam(foulAwayTeam);
        displayRunHomeTeam(scoreHomeTeam);
        displayOutHomeTeam(outHomeTeam);
        displayStrikeHomeTeam(strikeHomeTeam);
        displayFoulHomeTeam(foulHomeTeam);
        displayCurrentInning(currentInning);
    }

    public void resetFoul(View view) {
        if (teamAtBat == 0) {
            foulAwayTeam = 0;
            displayFoulAwayTeam(foulAwayTeam);
        } else {
            foulHomeTeam = 0;
            displayFoulHomeTeam(foulHomeTeam);
        }
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

    public void displayFoulAwayTeam(int foul) {
        TextView foulView = findViewById(R.id.away_team_foul);
        foulView.setText(String.valueOf(foul));
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

    public void displayFoulHomeTeam(int foul) {
        TextView foulView = findViewById(R.id.home_team_foul);
        foulView.setText(String.valueOf(foul));
    }

    public void displayCurrentInning(int inning) {
        TextView inningView = findViewById(R.id.current_inning);
        inningView.setText(String.valueOf(inning));
    }

}
