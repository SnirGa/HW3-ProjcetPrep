package AcceptanceTesting;

import Domain.ManagementSystem.GameSchedulingPolicy1Game;
import Domain.ManagementSystem.GameSchedulingPolicy2Games;
import Service.UnionRepresentiveApplication;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddSchedulingPolicyUCTest {

    @Test
    public void AddSchedulingPolicy2GameTestSet(){
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // League exist, without GameSchedulingPolicy - assert False
        assertFalse(URUser.AddSchedulingPolicy("ChampionLeague",2022, null));
        // League exist, with  GameSchedulingPolicy2Games - assert True
        assertTrue(URUser.AddSchedulingPolicy("ChampionLeague",2022, new GameSchedulingPolicy2Games()));
    }

    @Test
    public void GameSchedulingPolicy1GameTestSet(){
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        // League exist, without GameSchedulingPolicy - assert False
        assertFalse(URUser.AddSchedulingPolicy("EuroLeague",2022, null));
        // League exist, with  GameSchedulingPolicy1Game - assert True
        assertTrue(URUser.AddSchedulingPolicy("EuroLeague",2022, new GameSchedulingPolicy1Game()));
    }



}
