package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Scoreboard {
    private final List<Match> matches;

    /**
     * Constructs a new empty Scoreboard.
     * Initializes the internal list to track ongoing matches.
     */
    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    /**
     * Starts a new match between two teams with an initial score of 0-0.
     * The match is added to the scoreboard's tracking list.
     *
     * <p>A team cannot participate in multiple matches simultaneously.</p>
     *
     * @param homeTeam The team playing at home
     * @param awayTeam The team playing away
     * @return The newly created Match object
     * @throws IllegalStateException If either team is already participating in an ongoing match
     */
    public Match startMatch(Team homeTeam, Team awayTeam) {
        if(isTeamInMatch(homeTeam) || isTeamInMatch(awayTeam)) {
            throw new IllegalStateException("Match already exists");
        }
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    /**
     * Updates the score for a match between the specified home and away teams.
     *
     * <p>This method first finds the match between the given teams using the {@code findMatch}
     * method. It then updates the match's score with the provided values. If the match cannot
     * be found, an {@code IllegalStateException} is thrown. If either score is negative, an
     * {@code IllegalArgumentException} is thrown.</p>
     *
     * @param homeTeam      the home team of the match to update
     * @param awayTeam      the away team of the match to update
     * @param homeTeamScore the new score for the home team (must be non-negative)
     * @param awayTeamScore the new score for the away team (must be non-negative)
     * @return the updated Match object
     * @throws IllegalStateException  if no match can be found between the specified teams
     * @throws IllegalArgumentException if either score is negative
     */
    public Match updateScore(Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore) {
        Match matchToUpdate = findMatch(homeTeam, awayTeam)
                .orElseThrow(() -> new IllegalStateException("Match not found"));
        try {
            matchToUpdate.updateScore(homeTeamScore, awayTeamScore);
        } catch (IllegalArgumentException e) {
            System.err.println("Error updating match score: " + e.getMessage());
            throw e;
        }
        return matchToUpdate;
    }

    /**
     * Finishes a match and removes it from the scoreboard.
     * The method identifies the match by the participating teams.
     *
     * @param homeTeam The home team of the match to finish
     * @param awayTeam The away team of the match to finish
     * @return The finished Match object (before removal from the scoreboard)
     * @throws IllegalStateException If no match is found with the specified teams
     */
    public Match finishMatch(Team homeTeam, Team awayTeam) {
        Match matchToFinish = findMatch(homeTeam, awayTeam)
                .orElseThrow(() -> new IllegalStateException("Match not found"));
        matches.remove(matchToFinish);
        return matchToFinish;
    }

    /**
     * Retrieves a summary of all matches currently in progress, ordered by:
     * <ol>
     *   <li>Total score (sum of both teams' scores) in descending order</li>
     *   <li>For matches with equal total score, the most recently started match first</li>
     * </ol>
     *
     * @return A sorted list of matches based on total score and start time
     */
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
