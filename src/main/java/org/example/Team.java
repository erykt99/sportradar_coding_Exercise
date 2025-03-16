package org.example;

import java.util.Objects;

public class Team {
    private final String teamName;


    public Team(String teamName) {
        if (teamName == null ||  teamName.isBlank()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }
        this.teamName = teamName;
    }

    public String getTeamName() {return teamName;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }
}
