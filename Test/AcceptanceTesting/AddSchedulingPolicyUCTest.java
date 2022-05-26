package AcceptanceTesting;

import java.time.LocalDate;
import DataAccess.LeagueDaoMongoDB;
import DataAccess.RefereeDaoMongoDB;

import Domain.ManagementSystem.*;
import Service.UnionRepresentiveApplication;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddSchedulingPolicyUCTest {
//    private void setUp(){
//        // Get referee mongodb classes
//        LeagueDaoMongoDB leagueDaoMongoDB = LeagueDaoMongoDB.getInstance();
//        // Create Union Representative for the league
//        UnionRepresentative user = new UnionRepresentative("EuroLeagueUR", "Admin1","EuroLeagueUR");
//        // Create League
//        League league = new League("EuroLeague", user);
//        LocalDate startDate = LocalDate.of(2023, 1,1);
//        LocalDate finishDate = LocalDate.of(2023, 4,1);
//        LeagueSeason leagueSeason = new LeagueSeason(league,2023, startDate, finishDate);
//        league.addLeagueSeason(leagueSeason);
//        leagueDaoMongoDB.save(league);
//    }

    @Test
    public void AddSchedulingPolicy2GameTestSet(){
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // League exist, without GameSchedulingPolicy - assert False
        assertEquals("league, year or gameSchedulingPolicy are not valid", URUser.AddSchedulingPolicy("ChampionLeague",2022, null));
        // League exist, with  GameSchedulingPolicy2Games - assert True
        assertEquals("Successful add Scheduling Policy", URUser.AddSchedulingPolicy("ChampionLeague",2022, new GameSchedulingPolicy2Games()));
    }

    @Test
    public void GameSchedulingPolicy1GameTestSet(){
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // League exist, without GameSchedulingPolicy - assert False
        assertEquals("gameSchedulingPolicy have to be entered", URUser.AddSchedulingPolicy("EuroLeague",2023, null));
        // League exist, with  GameSchedulingPolicy1Game - assert True
        GameSchedulingPolicy1Game gameSchedulingPolicy1Game = new GameSchedulingPolicy1Game();
        URUser.AddSchedulingPolicy("EuroLeague",2023, gameSchedulingPolicy1Game);
        assertEquals("Successful add Scheduling Policy", URUser.AddSchedulingPolicy("EuroLeague",2023, new GameSchedulingPolicy1Game()));
    }



}
