import org.example.Team;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TeamTest {

    @Test
    void shouldCreateTeamWithName() {
        Team team = new Team("Brazil");
        assertEquals("Brazil", team.getTeamName());
    }

    @Test
    void shouldReturnErrorForNullOrEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Team(null));
        assertThrows(IllegalArgumentException.class, () -> new Team(""));
        assertThrows(IllegalArgumentException.class, () -> new Team("   "));
    }

    @Test
    void teamWithTheSameNameShouldBeEqual() {
        Team team1 = new Team("Brazil");
        Team team2 = new Team("Brazil");
        Team team3 = new Team("Germany");

        assertEquals(team1, team2);
        assertNotEquals(team1, team3);
        assertEquals(team1.hashCode(), team2.hashCode());
    }
}
