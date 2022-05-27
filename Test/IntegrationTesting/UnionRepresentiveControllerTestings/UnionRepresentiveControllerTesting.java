package IntegrationTesting.UnionRepresentiveControllerTestings;

import DataAccess.LeagueDaoMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.*;
import Service.UnionRepresentiveApplication;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Ref;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UnionRepresentiveControllerTesting {

    @Test
    public void addRefTOSLTest() throws Exception {
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        //Referee does not exist - assert false
        String ret = URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2");
        Assert.assertEquals("league, year or refereeUserName are not valid", ret);
        //Referee exist, league exist - assert True
        ret = URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi");
        Assert.assertEquals("Successful add referee", ret);
    }

    @Test
    public void ApplySchedulingPolicy() {
        LeagueDaoMongoDB leagueDaoMongoDB=LeagueDaoMongoDB.getInstance();
        UnionRepresentiveController URUser = new UnionRepresentiveController();
        GameSchedulingPolicy gameSchedulingPolicy1 = new GameSchedulingPolicy1Game();
        League league=new League("SomeLeague",new UnionRepresentative("Shahak123","123456","Shahak"));
        LocalDate start=LocalDate.of(2020,2,1);
        LocalDate end=LocalDate.of(2020,2,1);
        LeagueSeason leagueSeason=new LeagueSeason(league,2023,start,end);
        league.addLeagueSeason(leagueSeason);
        leagueDaoMongoDB.save(league);
        try {
            //League-Season without a policy
            boolean bool = URUser.ApplySchedulingPolicy("SomeLeague", 2023, gameSchedulingPolicy1);
            assertTrue(bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
        leagueDaoMongoDB.delete(league);
        //Non-exist League-Season

        try {
            boolean bool = URUser.ApplySchedulingPolicy("ChampionLeague", 2022, gameSchedulingPolicy1);
            assertFalse(bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //League-Season already with policy
        try {
            boolean bool = URUser.ApplySchedulingPolicy("ChampionLeague", 1999, gameSchedulingPolicy1);
            assertFalse(bool);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

