import org.example.Match;
import org.example.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class MatchTest {
    private Team homeTeam;
    private Team awayTeam;


    @BeforeEach
    void setUp() {
        homeTeam = new Team("Brazil");
        awayTeam = new Team("Germany");
    }

    @Test
    void shouldCreateMatchWithInitialScoreZeroZero() {
        Match match = new Match(homeTeam, awayTeam);

        Assertions.assertEquals(homeTeam, match.getHomeTeam());
        Assertions.assertEquals(awayTeam, match.getAwayTeam());
        Assertions.assertEquals(0, match.getHomeTeamScore());
        Assertions.assertEquals(0, match.getAwayTeamScore());
        Assertions.assertNotNull(match.getStartTime());
    }

    @Test
    void updateScoreShouldUpdateScores() {
        Match match = new Match(homeTeam, awayTeam);

        match.updateScore(2, 3);

        Assertions.assertEquals(2, match.getHomeTeamScore());
        Assertions.assertEquals(3, match.getAwayTeamScore());
        Assertions.assertEquals(5, match.getTotalScore());
    }

    @Test
    void updateScoreShouldReturnExceptionForNegativeScores() {
        Match match = new Match(homeTeam, awayTeam);

        assertThrows(IllegalArgumentException.class, () -> match.updateScore(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> match.updateScore(0, -1));
        assertThrows(IllegalArgumentException.class, () -> match.updateScore(-1, -1));
    }

    @Test
    void getTotalScoreShouldReturnTotalScore() {
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(2, 3);
        Assertions.assertEquals(5, match.getTotalScore());
    }

    @Test
    void toStringShouldReturnFormattedString() {
        Match match = new Match(homeTeam, awayTeam);
        match.updateScore(2, 3);

        Assertions.assertEquals("Brazil 2 - Germany 3", match.toString());
    }
}
