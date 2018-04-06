package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Spinner;
import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.Arrays;
//import java.util.List;

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
    String[] spinnerAwayTeamNames;
    String[] spinnerHomeTeamNames;
    //    String[] awayTeamNames = getResources().getStringArray(R.array.away_team_name_choices);
//    String[] homeTeamNames = getResources().getStringArray(R.array.home_team_name_choices);
//    List<String> awayTeamNameList = Arrays.asList(awayTeamNames);
//    List<String> homeTeamNameList = Arrays.asList(homeTeamNames);
    int[] spinnerLogos;
    Spinner awaySpinner;
    Spinner homeSpinner;
    private boolean isUserInteracting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awaySpinner = findViewById(R.id.away_team_name);
        homeSpinner = findViewById(R.id.home_team_name);
        spinnerAwayTeamNames = new String[]{"Choose Away Team", "Arizona Diamondbacks", "Atlanta Braves"
                , "Baltimore Orioles", "Boston Red Sox", "Chicago Cubs", "Chicago White Sox", "Cincinnati Reds", "Cleveland Indians"
                , "Colorado Rockies", "Detroit Tigers", "Houston Astros", "Kansas City Royals", "Los Angeles Angels"
                , "Log Angeles Dodgers", "Miami Marlins", "Milwaukee Brewers", "Minnesota Twins", "New York Mets"
                , "New York Yankees", "Oakland Athletics", "Philadelphia Phillies", "Pittsburgh Pirates"
                , "San Diego Padres", "San Francisco Giants", "Seattle Mariners", "St. Louis Cardinals"
                , "Tampa Bay Rays", "Texas Rangers", "Toronto Blue Jays", "Washington Nationals"};
        spinnerHomeTeamNames = new String[]{"Choose Home Team", "Arizona Diamondbacks", "Atlanta Braves"
                , "Baltimore Orioles", "Boston Red Sox", "Chicago Cubs", "Chicago White Sox", "Cincinnati Reds", "Cleveland Indians"
                , "Colorado Rockies", "Detroit Tigers", "Houston Astros", "Kansas City Royals", "Los Angeles Angels"
                , "Log Angeles Dodgers", "Miami Marlins", "Milwaukee Brewers", "Minnesota Twins", "New York Mets"
                , "New York Yankees", "Oakland Athletics", "Philadelphia Phillies", "Pittsburgh Pirates"
                , "San Diego Padres", "San Francisco Giants", "Seattle Mariners", "St. Louis Cardinals"
                , "Tampa Bay Rays", "Texas Rangers", "Toronto Blue Jays", "Washington Nationals"};
        spinnerLogos = new int[]{R.drawable.mlb_logo, R.drawable.logo_ari_79x76, R.drawable.logo_atl_79x76
                , R.drawable.logo_bal_79x76, R.drawable.logo_bos_79x76, R.drawable.logo_chc_79x76
                , R.drawable.logo_cws_79x76, R.drawable.logo_cin_79x76, R.drawable.logo_cle_79x76
                , R.drawable.logo_col_79x76, R.drawable.logo_det_79x76, R.drawable.logo_hou_79x76
                , R.drawable.logo_kc_79x76, R.drawable.logo_ana_79x76, R.drawable.logo_la_79x76
                , R.drawable.logo_mia_79x76, R.drawable.logo_mil_79x76, R.drawable.logo_min_79x76
                , R.drawable.logo_nym_79x76, R.drawable.logo_nyy_79x76, R.drawable.logo_oak_79x76
                , R.drawable.logo_phi_79x76, R.drawable.logo_pit_79x76, R.drawable.logo_sd_79x76
                , R.drawable.logo_sf_79x76, R.drawable.logo_sea_79x76, R.drawable.logo_stl_79x76
                , R.drawable.logo_tb_79x76, R.drawable.logo_tex_79x76, R.drawable.logo_tor_79x76
                , R.drawable.logo_was_79x76};

        CustomAdapter awayCustomAdapter = new CustomAdapter(MainActivity.this, spinnerAwayTeamNames, spinnerLogos);
        awaySpinner.setAdapter(awayCustomAdapter);

        CustomAdapter homeCustomAdapter = new CustomAdapter(MainActivity.this, spinnerHomeTeamNames, spinnerLogos);
        homeSpinner.setAdapter(homeCustomAdapter);

        awaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isUserInteracting) {
                    Toast.makeText(MainActivity.this, spinnerAwayTeamNames[i], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        homeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isUserInteracting) {
                    Toast.makeText(MainActivity.this, spinnerHomeTeamNames[i], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        isUserInteracting = true;
    }

    public void addRunAwayTeam(View view) {
        if (teamAtBat == 0) {
            scoreAwayTeam += 1;
            displayRunAwayTeam(scoreAwayTeam);
        } else if (teamAtBat == 2) {
            Toast awayRunGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            awayRunGameOver.setGravity(Gravity.TOP, 0, 150);
            awayRunGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast awayOutGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            awayOutGameOver.setGravity(Gravity.TOP, 0, 150);
            awayOutGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast awayStrikeGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            awayStrikeGameOver.setGravity(Gravity.TOP, 0, 150);
            awayStrikeGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast awayFoulGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            awayFoulGameOver.setGravity(Gravity.TOP, 0, 150);
            awayFoulGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast homeRunGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            homeRunGameOver.setGravity(Gravity.TOP, 0, 150);
            homeRunGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast homeOutGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            homeOutGameOver.setGravity(Gravity.TOP, 0, 150);
            homeOutGameOver.show();
        } else {
            Toast outAwayAtBat = Toast.makeText(this, "The away team is at bat!", Toast.LENGTH_SHORT);
            outAwayAtBat.setGravity(Gravity.TOP, 0, 150);
            outAwayAtBat.show();
        }
        if (outHomeTeam == 3 & teamAtBat == 1) {
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
        } else if (teamAtBat == 2) {
            Toast homeStrikeGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            homeStrikeGameOver.setGravity(Gravity.TOP, 0, 150);
            homeStrikeGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast homeFoulGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            homeFoulGameOver.setGravity(Gravity.TOP, 0, 150);
            homeFoulGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast resetStrikeGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            resetStrikeGameOver.setGravity(Gravity.TOP, 0, 150);
            resetStrikeGameOver.show();
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
        } else if (teamAtBat == 2) {
            Toast resetFoulGameOver = Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT);
            resetFoulGameOver.setGravity(Gravity.TOP, 0, 150);
            resetFoulGameOver.show();
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
