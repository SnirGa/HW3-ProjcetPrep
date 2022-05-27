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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnionRepresentiveControllerTesting {

    @Test
    public void addRefTOSLTest() throws Exception {
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        //Referee does not exist - assert false
        String ret=URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2");
        Assert.assertEquals("league, year or refereeUserName are not valid",ret);
        //Referee exist, league exist - assert True
        ret=URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi");
        Assert.assertEquals("Successful add referee", ret);
    }

    @Test
    public void ApplySchedulingPolicy(){
        UnionRepresentiveController URUser = new UnionRepresentiveController();

//        URUser.ApplySchedulingPolicy("ChampionLeague",2022,)
    }
    }

