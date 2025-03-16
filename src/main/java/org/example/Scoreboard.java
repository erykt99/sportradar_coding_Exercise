package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Scoreboard {
    private final List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }
    //  Start a new match, assuming initial score 0 – 0 and adding it the scoreboard.
    //  This should capture following parameters:
    //  a. Home team
    //  b. Away team
    public Match startMatch(Team homeTeam, Team awayTeam) {
        if(isTeamInMatch(homeTeam) || isTeamInMatch(awayTeam)) {
            throw new IllegalStateException("Match already exists");
        }
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    //  Update score. This should receive a pair of absolute scores: home team score and away
    //  team score.
    public Match updateScore(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore) {
        Match matchToUpdate = findMatch(homeTeam, awayTeam)
                .orElseThrow(() -> new IllegalStateException("Match not found"));
        matchToUpdate.updateScore(homeTeamScore, awayTeamScore);
        return matchToUpdate;
    }

    //  Finish match currently in progress. This removes a match from the scoreboard.
    public Match finishMatch(Team homeTeam, Team awayTeam) {
        Match matchToFinish = findMatch(homeTeam, awayTeam)
                .orElseThrow(() -> new IllegalStateException("Match not found"));
        matches.remove(matchToFinish);
        return matchToFinish;
    }

    //    Get a summary of matches in progress ordered by their total score. The matches with the
    //    same total score will be returned ordered by the most recently started match in the
    //    scoreboard.
    public List<Match> getRunningMatchesByTheirTotalScoreAndTime() {
        List<Match> sortedMatches = new ArrayList<>(matches);
        sortedMatches.sort(
                Comparator.comparing(Match::getTotalScore, Comparator.reverseOrder())
                        .thenComparing(Match::getStartTime, Comparator.reverseOrder())
        );
        return sortedMatches;
    }

    private boolean isTeamInMatch(Team team) {
        return matches.stream()
                .anyMatch(m -> m.getHomeTeam().equals(team) || m.getAwayTeam().equals(team));
    }

    private Optional<Match> findMatch(Team homeTeam, Team awayTeam) {
        return matches.stream()
                .filter(m -> m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam))
                .findFirst();
    }

}
