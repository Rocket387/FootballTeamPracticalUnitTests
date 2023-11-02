package org.example;

/**
 * Hello world!
 *
 */
public class FootballTeam implements Comparable<FootballTeam>
{
    private int gamesWon;
    //String team;
    public FootballTeam(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesWon() throws IllegalArgumentException {
        if (gamesWon < 0) {
            throw new IllegalArgumentException ("Cannot be minus");
        } else {
            return gamesWon;
        }
    }

    @Override
    public int compareTo(FootballTeam o) {
        if (gamesWon > o.getGamesWon()) {
            return 1;
        }
        return 0;
    }

}
