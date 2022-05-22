package Domain.ManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GameSchedulingPolicy2Games implements GameSchedulingPolicy{

    @Override
    public boolean ApplyGamePolicy(LeagueSeason leagueSeason) {
        //get all teams create game for each pair, for each game include date, hour, location, hometeam, awayteam, (Game obj) empty GameScore (obj) - by default on constructor
        //save game in leagueseason
        ArrayList<Team> lstTeam = leagueSeason.getLstTeam();
        int year = leagueSeason.getYear();
        LocalDate startMonth = leagueSeason.getStartDate();
        LocalDate finishMonth = leagueSeason.getFinishDate();
        long NumberOfDAys = ChronoUnit.DAYS.between(startMonth, finishMonth);
        double nuOfTeams =  lstTeam.size();
        double MaxGames = 2 * Math.pow(2, nuOfTeams);
        double gamesPerDay = MaxGames/NumberOfDAys;
        ArrayList<Game> lstGames = new ArrayList<>();
        for (int i=0; i< nuOfTeams; i++) {
            Team curr = lstTeam.get(i);
            for (int j=i+1; j< nuOfTeams; j++) {
                Team team = lstTeam.get(j);
                Game firstGame = new Game(null, curr, team, null, leagueSeason);
                Game secondGame = new Game(null, curr, team, null, leagueSeason);
                lstGames.add(firstGame);
                lstGames.add(secondGame);
            }
        }
        return false;
    }
}
