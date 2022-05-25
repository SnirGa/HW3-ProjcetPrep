package UnitTesting;
import Domain.ManagementSystem.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestGameSchedulingPolicy {

    @Test
    public void testGameSchedulingPolicy1Game(){
        // create leagueSeason with the relevant methods
        // Test ApplyGamePolicy Method
        UnionRepresentive ur = new UnionRepresentive("SnirTheKing", "123456", "SnirGa");
        League league = new League("England", ur);
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
        // check if all dates are different
        Team t1 = new Team(null,null,null);
        Team t2 = new Team(null,null,null);
        Team t3 = new Team(null,null,null);
        Team t4 = new Team(null,null,null);
        Team t5 = new Team(null,null,null);
        Team t6 = new Team(null,null,null);
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t4);
        teams.add(t5);
        teams.add(t6);
        league_season.setLstTeam(teams);
        assertNotEquals(league_season.getLstTeam().size(), 0);
        assertTrue(GP1G.ApplyGamePolicy(league_season));
        boolean flag = true;
        for (int i=0; i < league_season.getLstGame().size(); i++){
            for (int j=0; j < league_season.getLstGame().size(); j++){
                if (i == j) continue;
                if (league_season.getLstGame().get(i).getDate().isEqual(league_season.getLstGame().get(j).getDate())) flag = false;
            }
        }
        assertTrue(flag);
        // number of games is ok
        assertEquals(league_season.getLstGame().size(), (teams.size() * (teams.size() - 1) / 2));
        // The lstTeam is null
        league_season.setLstTeam(null);
        assertFalse(GP1G.ApplyGamePolicy(league_season));
    }

    @Test
    public void testGameSchedulingPolicy2Games(){
        // create leagueSeason with the relevant methods
        // Test ApplyGamePolicy Method
        UnionRepresentive ur = new UnionRepresentive("SnirTheKing", "123456", "SnirGa");
        League league = new League("England", ur);
        LocalDate start_date = null;
        LocalDate finish_date = LocalDate.of(1992,6,1);
        LeagueSeason league_season = new LeagueSeason(league,1992,start_date,finish_date);
        GameSchedulingPolicy2Games GP2G = new GameSchedulingPolicy2Games();
        // date null
        assertFalse(GP2G.ApplyGamePolicy(league_season));
        // all ok
        start_date = LocalDate.of(1992,1,1);
        league_season.setStartDate(start_date);
        assertTrue(GP2G.ApplyGamePolicy(league_season));
        // check if all dates are different
        Team t1 = new Team(null,null,null);
        Team t2 = new Team(null,null,null);
        Team t3 = new Team(null,null,null);
        Team t4 = new Team(null,null,null);
        Team t5 = new Team(null,null,null);
        Team t6 = new Team(null,null,null);
        ArrayList<Team> teams = new ArrayList<>();
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);
        teams.add(t4);
        teams.add(t5);
        teams.add(t6);
        league_season.setLstTeam(teams);
        assertNotEquals(league_season.getLstTeam().size(), 0);
        assertTrue(GP2G.ApplyGamePolicy(league_season));
        boolean flag = true;
        for (int i=0; i < league_season.getLstGame().size(); i++){
            for (int j=0; j < league_season.getLstGame().size(); j++){
                if (i == j) continue;
                if (league_season.getLstGame().get(i).getDate().isEqual(league_season.getLstGame().get(j).getDate())) flag = false;
            }
        }
        assertTrue(flag);
        // number of games is ok
        assertEquals(league_season.getLstGame().size(), 2*(teams.size() * (teams.size() - 1) / 2));
        // The lstTeam is null
        league_season.setLstTeam(null);
        assertFalse(GP2G.ApplyGamePolicy(league_season));
    }

}
