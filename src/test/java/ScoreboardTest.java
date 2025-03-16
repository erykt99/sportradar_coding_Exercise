import org.example.Match;
import org.example.Scoreboard;
import org.example.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardTest {
    private Scoreboard scoreboard;
    private Team homeTeam;
    private Team awayTeam;

    @BeforeEach
    public void setUp() {
        scoreboard = new Scoreboard();
        homeTeam = new Team("Togo");
        awayTeam = new Team("RPA");

    }

    @Test
    void finishMatchThatDoesntExistShouldReturnException() {
        Assertions.assertThrows(IllegalStateException.class, () -> scoreboard.finishMatch(homeTeam, awayTeam));
    }

    @Test
    void finishMatchShouldRemoveMatchFromList() {
        scoreboard.startMatch(homeTeam, awayTeam);
        scoreboard.finishMatch(homeTeam, awayTeam);
        Assertions.assertTrue(scoreboard.getRunningMatchesByTheirTotalScoreAndTime().isEmpty());
        Assertions.assertEquals(0, scoreboard.getRunningMatchesByTheirTotalScoreAndTime().size());

    }

    @Test
    void startMatchIfTheTeamPlayingShouldReturnException() {
        scoreboard.startMatch(homeTeam, awayTeam);
        Assertions.assertThrows(IllegalStateException.class, () -> scoreboard.startMatch(homeTeam, awayTeam));
        Assertions.assertThrows(IllegalStateException.class, () -> scoreboard.startMatch(awayTeam, homeTeam));
    }

    @Test
    void addTeamToMatchShouldAddTeamToMatches() {
        List<Match> matches = new ArrayList<>();
        matches.add(new Match(homeTeam, awayTeam));

        scoreboard.startMatch(homeTeam, awayTeam);
        Assertions.assertEquals(matches, scoreboard.getRunningMatchesByTheirTotalScoreAndTime());

    }

    @Test
    void getMatchesShouldReturnListOrderedByTheirScoreAndTime() {
        Scoreboard scoreboard = new Scoreboard();
        List<Match> matches = new ArrayList<>();

        Team homeTeam = new Team("Mexico");
        Team awayTeam = new Team("Canada");
        scoreboard.startMatch(homeTeam, awayTeam);
        scoreboard.updateScore(homeTeam, awayTeam, 2, 3);


        Team homeTeam2 = new Team("Spain");
        Team awayTeam2 = new Team("Brazil");
        scoreboard.startMatch(homeTeam2, awayTeam2);
        scoreboard.updateScore(homeTeam2, awayTeam2, 10, 2);

        Team homeTeam3 = new Team("Germany");
        Team awayTeam3 = new Team("France");
        scoreboard.startMatch(homeTeam3, awayTeam3);
        scoreboard.updateScore(homeTeam3, awayTeam3, 2, 2);

        Team homeTeam4 = new Team("Uruguay");
        Team awayTeam4 = new Team("Italy");
        scoreboard.startMatch(homeTeam4, awayTeam4);
        scoreboard.updateScore(homeTeam4, awayTeam4, 6, 6);


        Team homeTeam5 = new Team("Argentina");
        Team awayTeam5 = new Team("Australia");
        scoreboard.startMatch(homeTeam5, awayTeam5);
        scoreboard.updateScore(homeTeam5, awayTeam5, 3, 1);


        Team homeTeamOrderByTotalScore = new Team("Uruguay");
        Team awayTeamOrderByTotalScore = new Team("Italy");
        Match match = new Match(homeTeamOrderByTotalScore, awayTeamOrderByTotalScore);
        match.updateScore(6,6);
        matches.add(match);

        Team homeTeamOrderByTotalScore2 = new Team("Spain");
        Team awayTeamOrderByTotalScore2 = new Team("Brazil");
        Match match2 = new Match(homeTeamOrderByTotalScore2, awayTeamOrderByTotalScore2);
        match2.updateScore(10,2);
        matches.add(match2);

        Team homeTeamOrderByTotalScore3 = new Team("Mexico");
        Team awayTeamOrderByTotalScore3 = new Team("Canada");
        Match match3 = new Match(homeTeamOrderByTotalScore3, awayTeamOrderByTotalScore3);
        match3.updateScore(0,5);
        matches.add(match3);

        Team homeTeamOrderByTotalScore4 = new Team("Argentina");
        Team awayTeamOrderByTotalScore4 = new Team("Australia");
        Match match4 = new Match(homeTeamOrderByTotalScore4, awayTeamOrderByTotalScore4);
        match4.updateScore(3,1);
        matches.add(match4);

        Team homeTeamOrderByTotalScore5 = new Team("Germany");
        Team awayTeamOrderByTotalScore5 = new Team("France");
        Match match5 = new Match(homeTeamOrderByTotalScore5, awayTeamOrderByTotalScore5);
        match5.updateScore(2,2);
        matches.add(match5);

        Assertions.assertEquals(matches, scoreboard.getRunningMatchesByTheirTotalScoreAndTime());
    }

    @Test
    void updateScoreShouldReturnUpdatedMatchScore() {
        scoreboard.startMatch(homeTeam, awayTeam);
        Match match = scoreboard.updateScore(homeTeam, awayTeam, 2, 3);
        Assertions.assertEquals(2, match.getHomeTeamScore());
        Assertions.assertEquals(3, match.getAwayTeamScore());
        Assertions.assertEquals(5, match.getTotalScore());
    }

    @Test
    void updateScoreShouldReturnExceptionIfMatchDoesNotExist(){
        Assertions.assertThrows(IllegalStateException.class, () -> scoreboard.updateScore(homeTeam, awayTeam, 4, 5));
    }

    @Test
    void updateScoreShouldReturnExceptionIfScoresAreIncorrect() {
        Assertions.assertThrows(IllegalStateException.class, () -> scoreboard.updateScore(homeTeam, awayTeam, -1, 2));
    }
}
