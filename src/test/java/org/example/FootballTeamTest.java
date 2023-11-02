package org.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
@RunWith(JUnitParamsRunner.class)
public class FootballTeamTest

{
    private static final int THREE_GAMES_WON = 3;

    @Test
    public void testGamesWon() {
        FootballTeam team1 = new FootballTeam(THREE_GAMES_WON );

        assertEquals(THREE_GAMES_WON , team1.getGamesWon());
    }

    public Object[] numGamesWon() {
        return new Object[] {
                new Object[] {0},
                new Object[] {1},
                new Object[] {4}
        };
    }

    @Test
    @Parameters(method = "numGamesWon")
    public void constructorShouldSetGamesWon(int numGamesWon) {
        FootballTeam team2 = new FootballTeam(numGamesWon);

        assertEquals(numGamesWon, team2.getGamesWon());
    }

    public Object[] illegalNumGamesWon() {
        return new Object[] {
                new Object[] {-10},
                new Object[] {-1},
                new Object[] {-4}
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "illegalNumGamesWon")
    public void constructorThrowIllegalArgument(int illegalNumGamesWon) {
        FootballTeam team2 = new FootballTeam(illegalNumGamesWon);

        assertEquals(illegalNumGamesWon, team2.getGamesWon());

    }

    @Test
    public void shouldCompareTeams() {
        FootballTeam team2 = new FootballTeam(THREE_GAMES_WON);

        assertTrue(team2 instanceof Comparable);
    }

    @Test
    public void teamsWithMoreWinsShouldBeGreater() {
        FootballTeam team = new FootballTeam(2);
        FootballTeam team2 = new FootballTeam(3);

        assertTrue(team2.compareTo(team) > 0);
    }
}
