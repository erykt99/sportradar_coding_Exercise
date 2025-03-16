package org.example;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public void updateScore(int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore < 0 || awayTeamScore < 0) {
            throw new IllegalArgumentException("Invalid score, scores must be non-negative");
        }
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public int getTotalScore() {return homeTeamScore + awayTeamScore;}
    public int getHomeTeamScore() {return homeTeamScore;}
    public int getAwayTeamScore() {return awayTeamScore;}
    public Team getHomeTeam() {return homeTeam;}
    public Team getAwayTeam() {return awayTeam;}
    public LocalDateTime getStartTime() {return startTime;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(homeTeam, match.homeTeam) &&
                Objects.equals(awayTeam, match.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }

    @Override
    public String toString() {
        return homeTeam.getTeamName() + " " + homeTeamScore + " - " + awayTeam.getTeamName() + " " + awayTeamScore;
    }
}
