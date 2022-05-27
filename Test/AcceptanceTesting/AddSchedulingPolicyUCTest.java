package AcceptanceTesting;

import Domain.ManagementSystem.*;
import Service.UnionRepresentiveApplication;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddSchedulingPolicyUCTest {

    @Test
    public void AddSchedulingPolicy2GameTestSet(){
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // League exist, without GameSchedulingPolicy - assert False
        assertEquals("gameSchedulingPolicy have to be entered", URUser.AddSchedulingPolicy("ChampionLeague",2022, null));
        // League exist, with  GameSchedulingPolicy2Games - assert True
        GameSchedulingPolicy2Games gameSchedulingPolicy2Games = new GameSchedulingPolicy2Games();
        assertEquals("Successful add Scheduling Policy", URUser.AddSchedulingPolicy("ChampionLeague",2022, gameSchedulingPolicy2Games));
    }

    @Test
    public void GameSchedulingPolicy1GameTestSet(){
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // League exist, without GameSchedulingPolicy - assert False
        assertEquals("gameSchedulingPolicy have to be entered", URUser.AddSchedulingPolicy("EuroLeague",2023, null));
        // League exist, with  GameSchedulingPolicy1Game - assert True
        GameSchedulingPolicy1Game gameSchedulingPolicy1Game = new GameSchedulingPolicy1Game();
        assertEquals("Successful add Scheduling Policy", URUser.AddSchedulingPolicy("EuroLeague",2023, gameSchedulingPolicy1Game));
    }



}
