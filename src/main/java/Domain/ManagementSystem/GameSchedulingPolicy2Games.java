package Domain.ManagementSystem;

import java.util.ArrayList;

public class GameSchedulingPolicy2Games implements GameSchedulingPolicy{

    @Override
    public boolean ApplyGamePolicy(LeagueSeason leagueSeason) {
        //get all teams create game for each pair, for each game include date, hour, location, hometeam, awayteam, (Game obj) empty GameScore (obj) - by default on constructor
        //save game in leagueseason
        ArrayList<Team> lstTeam = leagueSeason.getLstTeam();


        return false;
    }
}
