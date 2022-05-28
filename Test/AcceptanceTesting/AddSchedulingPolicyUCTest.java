package AcceptanceTesting;

import Domain.ManagementSystem.GameSchedulingPolicy1Game;
import Domain.ManagementSystem.GameSchedulingPolicy2Games;
import Service.UnionRepresentiveApplication;
import org.junit.Test;
import SetUpDB.*;

import static org.junit.Assert.assertEquals;

public class AddSchedulingPolicyUCTest {

    @Test
    public void AddSchedulingPolicy2GameTestSet(){
        SetUp.SetUpDB();
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // Year = 0
        assertEquals("Year can't be 0", URUser.AddSchedulingPolicy("ChampionLeague",0, null));
        // League = null
        assertEquals("LeagueName have to be entered", URUser.AddSchedulingPolicy(null,2022, null));
        // League exist, without GameSchedulingPolicy - assert False
        assertEquals("gameSchedulingPolicy have to be entered", URUser.AddSchedulingPolicy("ChampionLeague",2022, null));
        GameSchedulingPolicy2Games gameSchedulingPolicy2Games = new GameSchedulingPolicy2Games();
        // League does not exist
        assertEquals("League is not valid", URUser.AddSchedulingPolicy("Champ",2022, gameSchedulingPolicy2Games));
        // LeagueSeason does not exist in DB
        assertEquals("LeagueSeason does not exist in DB", URUser.AddSchedulingPolicy("ChampionLeague",1800, gameSchedulingPolicy2Games));
        // League exist, with  GameSchedulingPolicy2Games - assert True
        assertEquals("Successful add Scheduling Policy", URUser.AddSchedulingPolicy("ChampionLeague",2022, gameSchedulingPolicy2Games));
    }

    @Test
    public void GameSchedulingPolicy1GameTestSet(){
        SetUp.SetUpDB();
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // Year = 0
        assertEquals("Year can't be 0", URUser.AddSchedulingPolicy("EuroLeague",0, null));
        // League = null
        assertEquals("LeagueName have to be entered", URUser.AddSchedulingPolicy(null,2023, null));
        // League exist, without GameSchedulingPolicy - assert False
        assertEquals("gameSchedulingPolicy have to be entered", URUser.AddSchedulingPolicy("EuroLeague",2023, null));
        GameSchedulingPolicy1Game gameSchedulingPolicy1Game = new GameSchedulingPolicy1Game();
        // League does not exist
        assertEquals("League is not valid", URUser.AddSchedulingPolicy("Champ",2023, gameSchedulingPolicy1Game));
        // LeagueSeason does not exist in DB
        assertEquals("LeagueSeason does not exist in DB", URUser.AddSchedulingPolicy("EuroLeague",1800, gameSchedulingPolicy1Game));
        // League exist, with  GameSchedulingPolicy1Game - assert True
        assertEquals("Successful add Scheduling Policy", URUser.AddSchedulingPolicy("EuroLeague",2023, gameSchedulingPolicy1Game));
    }



}
