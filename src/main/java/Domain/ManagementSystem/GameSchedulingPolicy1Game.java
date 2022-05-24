package Domain.ManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class GameSchedulingPolicy1Game implements GameSchedulingPolicy {

    @Override
    public boolean ApplyGamePolicy(LeagueSeason leagueSeason){
        //create game for each pair, for each game include date, hour, location, hometeam, awayteam, (Game obj) empty GameScore (obj) - by default on constructor
        //save game in leagueseason
//        int TeamOptions = (int) Math.pow(2, teams.size()); //Number of games
//        LocalDate Start_date = leagueSeason.getStartDate();
//        LocalDate Finish_date = leagueSeason.getFinishDate();
//        int NumberOfDays = (int) ChronoUnit.DAYS.between(Start_date, Finish_date);
        ArrayList<Team> teams = leagueSeason.getLstTeam();
        if (teams == null) return false;
        LocalDate date = leagueSeason.getStartDate();
        if (date == null) return false;
        Time time = null;
        try {
            time = new Time(21,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(time == null) return false;
        for (int i = 0; i < teams.size(); i++){
            for (int j = i+1; j < teams.size(); j++){
                Game game = new Game(date, teams.get(i), teams.get(j), time, teams.get(i).getStadium() ,leagueSeason);
                leagueSeason.addGame(game);
                date = date.plusDays(1);
            }

        }
        return true;
    }
}
