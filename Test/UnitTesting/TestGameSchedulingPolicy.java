package UnitTesting;
import Domain.ManagementSystem.GameSchedulingPolicy1Game;
import Domain.ManagementSystem.League;
import Domain.ManagementSystem.LeagueSeason;
import Domain.ManagementSystem.Team;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestGameSchedulingPolicy {

    @Test
    public void testGameSchedulingPolicy1Game(){
        // create leagueSeason with the relevant methods
        // Test ApplyGamePolicy Method
        League league = new League();
        LocalDate start_date = null;
        LocalDate finish_date = LocalDate.of(1992,6,1);
        LeagueSeason league_season = new LeagueSeason(league,1992,start_date,finish_date);
        GameSchedulingPolicy1Game GP1G = new GameSchedulingPolicy1Game();
        // date null
        assertFalse(GP1G.ApplyGamePolicy(league_season));
        // all ok
        start_date = LocalDate.of(1992,1,1);
        league_season.setStartDate(start_date);
        assertTrue(GP1G.ApplyGamePolicy(league_season));
        // number of games is ok
        ArrayList<Team> teams = league_season.getLstTeam();
        assertEquals(league_season.getLstGame().size(), (teams.size() * (teams.size() - 1) / 2));
        // check if all dates are different
        boolean flag = true;
        for (int i=0; i < league_season.getLstGame().size(); i++){
            for (int j=0; j < league_season.getLstGame().size(); j++){
                if (i == j) continue;
                if (league_season.getLstGame().get(i).getDate().isEqual(league_season.getLstGame().get(j).getDate())) flag = false;
            }
        }
        assertTrue(flag);
        // The lstTeam is null
        league_season.setLstTeam(null);
        assertFalse(GP1G.ApplyGamePolicy(league_season));
    }

    @Test
    public void testGameSchedulingPolicy2Games(){
        // create leagueSeason with the relevant methods
        // Test ApplyGamePolicy Method
        League league = new League();
        LocalDate start_date = null;
        LocalDate finish_date = LocalDate.of(1992,6,1);
        LeagueSeason league_season = new LeagueSeason(league,1992,start_date,finish_date);
        GameSchedulingPolicy1Game GP1G = new GameSchedulingPolicy1Game();
        // date null
        assertFalse(GP1G.ApplyGamePolicy(league_season));
        // all ok
        start_date = LocalDate.of(1992,1,1);
        league_season.setStartDate(start_date);
        assertTrue(GP1G.ApplyGamePolicy(league_season));
        // number of games is ok
        ArrayList<Team> teams = league_season.getLstTeam();
        assertEquals(league_season.getLstGame().size(), (2 * teams.size() * (teams.size() - 1) / 2));
        // check if all dates are different
        boolean flag = true;
        for (int i=0; i < league_season.getLstGame().size(); i++){
            for (int j=0; j < league_season.getLstGame().size(); j++){
                if (i == j) continue;
                if (league_season.getLstGame().get(i).getDate().isEqual(league_season.getLstGame().get(j).getDate())) flag = false;
            }
        }
        assertTrue(flag);
        // The lstTeam is null
        league_season.setLstTeam(null);
        assertFalse(GP1G.ApplyGamePolicy(league_season));
    }

}
