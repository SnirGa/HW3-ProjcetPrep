package Domain.ManagementSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class GameSchedulingPolicy2Games implements GameSchedulingPolicy{

    @Override
    public boolean ApplyGamePolicy(LeagueSeason leagueSeason) {
        //get all teams create game for each pair, for each game include date, hour, location, hometeam, awayteam, (Game obj) empty GameScore (obj) - by default on constructor
        //save game in leagueSeason
        ArrayList<Team> lstTeam = leagueSeason.getLstTeam();
        if (lstTeam != null) {
            LocalDate gameDate = leagueSeason.getStartDate();
            if (gameDate != null) {
                LocalTime gameTime = LocalTime.of(21,0,0,0);
                double nuOfTeams = lstTeam.size();
                for (int i = 0; i < nuOfTeams; i++) {
                    Team curr = lstTeam.get(i);
                    for (int j = i + 1; j < nuOfTeams; j++) {
                        Team team = lstTeam.get(j);
                        Game firstGame = new Game(gameDate, curr, team, gameTime, curr.getStadium(), leagueSeason);
                        leagueSeason.addGame(firstGame);
                        gameDate = gameDate.plusDays(1);
                        Game secondGame = new Game(gameDate, curr, team, gameTime, team.getStadium(), leagueSeason);
                        leagueSeason.addGame(secondGame);
                        gameDate = gameDate.plusDays(1);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
