package org.example;

import java.time.LocalDateTime;

public class Match {
    private final Team homeTeam;
    private final Team awayTeam;
    private int homeTeamScore;
    private int awayTeamScore;
    private final LocalDateTime startTime;

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
        this.startTime = LocalDateTime.now();
    }

    public void updateScore(int homeTeamScore, int awayTeamScore) {}
}
