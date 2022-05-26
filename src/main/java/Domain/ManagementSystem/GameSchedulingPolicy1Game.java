package Domain.ManagementSystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class GameSchedulingPolicy1Game implements GameSchedulingPolicy, Serializable {

    @Override
    public boolean ApplyGamePolicy(LeagueSeason leagueSeason){
        ArrayList<Team> teams = leagueSeason.getLstTeam();
        if (teams == null) return false;
        LocalDate date = leagueSeason.getStartDate();

        if (date == null) return false;
        LocalTime time = LocalTime.of(21,0,0,0);
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
