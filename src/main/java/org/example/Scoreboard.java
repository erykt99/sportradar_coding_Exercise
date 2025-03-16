package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    private final List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }
    //  Start a new match, assuming initial score 0 – 0 and adding it the scoreboard.
    //  This should capture following parameters:
    //  a. Home team
    //  b. Away team
    public void StartMatch() {}

    //  Update score. This should receive a pair of absolute scores: home team score and away
    //  team score.
    public void updateScore() {}

    //  Finish match currently in progress. This removes a match from the scoreboard.
    public void finishMatch() {}

    //    Get a summary of matches in progress ordered by their total score. The matches with the
    //    same total score will be returned ordered by the most recently started match in the
    //    scoreboard.
    public void getSummaryOfMatches() {}

}
