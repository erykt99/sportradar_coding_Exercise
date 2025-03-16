import org.example.Match;
import org.example.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class MatchTest {

    @Test
    void shouldCreateMatchWithInitialScoreZeroZero() {
        Team homeTeam = new Team("Brazil");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        Assertions.assertEquals(homeTeam, match.getHomeTeam());
        Assertions.assertEquals(awayTeam, match.getAwayTeam());
        Assertions.assertEquals(0, match.getHomeTeamScore());
        Assertions.assertEquals(0, match.getAwayTeamScore());
        Assertions.assertNotNull(match.getStartTime());
    }

    @Test
    void updateScoreShouldUpdateScores() {
        Team homeTeam = new Team("Brazil");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        match.updateScore(2, 3);

        Assertions.assertEquals(2, match.getHomeTeamScore());
        Assertions.assertEquals(3, match.getAwayTeamScore());
        Assertions.assertEquals(5, match.getTotalScore());
    }

    @Test
    void updateScoreShouldReturnExceptionForNegativeScores() {
        Team homeTeam = new Team("Brazil");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);

        assertThrows(IllegalArgumentException.class, () -> match.updateScore(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> match.updateScore(0, -1));
        assertThrows(IllegalArgumentException.class, () -> match.updateScore(-1, -1));
    }

    @Test
    void getTotalScoreShouldReturnTotalScore() {
        Team homeTeam = new Team("Brazil");
        Team awayTeam = new Team("Germany");
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(2, 3);
        Assertions.assertEquals(5, match.getTotalScore());
    }
}
