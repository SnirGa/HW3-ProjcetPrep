package AcceptanceTesting;

import Domain.ManagementSystem.GameSchedulingPolicy1Game;
import Domain.ManagementSystem.GameSchedulingPolicy2Games;
import Service.UnionRepresentiveApplication;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddSchedulingPolicyUCTest {

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
        assertEquals("gameSchedulingPolicy have to be entered", URUser.AddSchedulingPolicy("EuroLeague",2022, null));
        // League exist, with  GameSchedulingPolicy1Game - assert True
        assertEquals("Successful add Scheduling Policy", URUser.AddSchedulingPolicy("EuroLeague",2022, new GameSchedulingPolicy1Game()));
    }



}
