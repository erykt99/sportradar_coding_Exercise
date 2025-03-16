import org.example.Match;
import org.example.Scoreboard;
import org.example.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardTest {

    @Test
    void finishMatchThatDoesntExistShouldReturnException() {}

    @Test
    void finishMatchShouldRemoveMatchFromList() {}

    @Test
    void addTeamToMatchIfTheTeamPlayingShouldReturnException() {}

    @Test
    void addTeamToMatchShouldAddTeamToMatches() {}

    @Test
    void getMatchesShouldReturnListOrderedByTheirScoreAndTime() {}

    @Test
    void updateScoreShouldReturnUpdatedMatch() {}

    @Test
    void updateScoreShouldReturnExceptionIfMatchDoesNotExist(){}

    @Test
    void updateScoreShouldReturnExceptionIfScoresAreIncorrect() {}

    @Test
    void exerciseTestExample() {
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

        Assertions.assertEquals(matches, scoreboard.getSummaryOfMatches());


    }
}
