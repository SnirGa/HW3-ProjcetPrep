package UnitTesting;
import DataAccess.LeagueDaoMongoDBStub;
import DataAccess.RefereeDaoMongoDBStub;
import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.GameSchedulingPolicy;
import Domain.ManagementSystem.GameSchedulingPolicy1Game;
import Domain.ManagementSystem.LeagueSeason;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestUnionRepresentiveController {

    @Test
    public void testAddRefTOSL(){
        // Roni
        // create LeagueDaoMongoDBStub - lc and RefereeDaoMongoDBStub - rmdb
        LeagueDaoMongoDBStub lc = LeagueDaoMongoDBStub.getInstance();
        RefereeDaoMongoDBStub rmdb = RefereeDaoMongoDBStub.getInstance();
        UnionRepresentiveController urc = new UnionRepresentiveController(lc, rmdb);
        //leagueSeason != null && referee != null
        //return true:
        assertTrue(urc.addRefTOSL("Champion", 2022, "YossiYossi" ));
        //return false:
        urc = new UnionRepresentiveController(LeagueDaoMongoDBStub.getInstance(), RefereeDaoMongoDBStub.getInstance());
        assertFalse(urc.addRefTOSL("Champion", 2022, "Yossi" ));
        //leagueSeason == null && referee == null
        assertFalse(urc.addRefTOSL("ChampionWithOutLeagueSeason", 2022, "YossiNotExist" ));
        //leagueSeason == null && referee != null
        assertFalse(urc.addRefTOSL("ChampionWithOutLeagueSeason", 2022, "YossiYossi" ));
        //leagueSeason != null && referee == null
        assertFalse(urc.addRefTOSL("Champion", 2022, "YossiNotExist" ));
        //unValid input(name)
        assertFalse(urc.addRefTOSL("Champion", 2022, "Yossi2" ));


    }

    @Test
    public void testApplySchedulingPolicy(){
        // Daniel
        // create LeagueDaoMongoDBStub - lc
        LeagueDaoMongoDBStub lc2 = LeagueDaoMongoDBStub.getInstance();
        UnionRepresentiveController unionRepresentiveController = new UnionRepresentiveController(lc2,null);
        // use UnionRepresentiveController(Dao lc, null) for constructur
        //leageSeason == null:
        GameSchedulingPolicy1Game gameSchedulingPolicy = new GameSchedulingPolicy1Game();
        assertFalse(unionRepresentiveController.ApplySchedulingPolicy("ChampionWithOutLeagueSeason",2022,gameSchedulingPolicy));
        //league != null:
        assertTrue(unionRepresentiveController.ApplySchedulingPolicy("Champion",2022,gameSchedulingPolicy));
        //there is no league schedulingPolicy:
        assertFalse(unionRepresentiveController.ApplySchedulingPolicy("Champion",2022,null));


    }

    @Test
    public void testGetLeagueBySeason(){
        // Daniel
        // create LeagueDaoMongoDBStub - lc
        // use UnionRepresentiveController(Dao lc, null) for constructor
        LeagueDaoMongoDBStub lc = LeagueDaoMongoDBStub.getInstance();
        RefereeDaoMongoDBStub rmdb = RefereeDaoMongoDBStub.getInstance();
        UnionRepresentiveController urc = new UnionRepresentiveController(lc, rmdb);
        LeagueSeason ls = urc.getLeagueBySeason("Spain",2000);
        //league does not exist
        assertTrue(ls == null);
        ls = urc.getLeagueBySeason("Champion",2022);
        //league exist
        assertTrue(ls != null);


    }
}
