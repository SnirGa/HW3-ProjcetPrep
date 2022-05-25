package UnitTesting;
import DataAccess.LeagueDaoMongoDBStub;
import DataAccess.RefereeDaoMongoDBStub;
import Domain.Controllers.UnionRepresentiveController;
import org.junit.jupiter.api.Test;
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
        // use UnionRepresentiveController(Dao lc, null) for constructur
    }

    @Test
    public void testGetLeagueBySeason(){
        // Daniel
        // create LeagueDaoMongoDBStub - lc
        // use UnionRepresentiveController(Dao lc, null) for constructur
    }
}
