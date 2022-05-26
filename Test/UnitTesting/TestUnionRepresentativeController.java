package UnitTesting;
import DataAccess.LeagueDaoMongoDBStub;
import DataAccess.RefereeDaoMongoDBStub;
import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.GameSchedulingPolicy;
import Domain.ManagementSystem.GameSchedulingPolicy1Game;
import Domain.ManagementSystem.League;
import Domain.ManagementSystem.LeagueSeason;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestUnionRepresentativeController {

    @Test
    public void testAddRefTOSL(){
        // Roni
        // create LeagueDaoMongoDBStub - lc and RefereeDaoMongoDBStub - rmdb
        LeagueDaoMongoDBStub lc = LeagueDaoMongoDBStub.getInstance();
        RefereeDaoMongoDBStub rmdb = RefereeDaoMongoDBStub.getInstance();
        UnionRepresentiveController urc = new UnionRepresentiveController(lc, rmdb);
        try {
            //leagueSeason != null && referee != null
            //return true:
            assertTrue(urc.addRefTOSL("Champion", 2022, "YossiYossi"));
            //return false:
            urc = new UnionRepresentiveController(LeagueDaoMongoDBStub.getInstance(), RefereeDaoMongoDBStub.getInstance());
            assertFalse(urc.addRefTOSL("Champion", 2022, "Yossi"));
            //leagueSeason == null && referee == null
            assertFalse(urc.addRefTOSL("ChampionWithOutLeagueSeason", 2022, "YossiNotExist"));
            //leagueSeason == null && referee != null
            assertFalse(urc.addRefTOSL("ChampionWithOutLeagueSeason", 2022, "YossiYossi"));
            //leagueSeason != null && referee == null
            assertFalse(urc.addRefTOSL("Champion", 2022, "YossiNotExist"));
            //unValid input(name)
            assertFalse(urc.addRefTOSL("Champion", 2022, "Yossi2"));
        }catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }

        try{
            urc.addRefTOSL("Champion", 2022, null);
        }catch (Exception e){
            assertTrue(e.getMessage().contains("refereeUserName"));
        }

        try{
            urc.addRefTOSL("Champion", 0, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("0"));
        }

        try{
            urc.addRefTOSL(null, 2022, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("LeagueName"));
        }
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
        try {
            assertFalse(unionRepresentiveController.ApplySchedulingPolicy("ChampionWithOutLeagueSeason", 2022, gameSchedulingPolicy));
            //league != null:
            assertTrue(unionRepresentiveController.ApplySchedulingPolicy("Champion", 2022, gameSchedulingPolicy));
            //there is no league schedulingPolicy:
//            assertFalse(unionRepresentiveController.ApplySchedulingPolicy("Champion", 2022, null));
        }catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }

        try{
            assertTrue(unionRepresentiveController.ApplySchedulingPolicy(null, 2022, gameSchedulingPolicy));
        }catch (Exception e){
            assertTrue(e.getMessage().contains("LeagueName"));
        }

        try{
            assertTrue(unionRepresentiveController.ApplySchedulingPolicy("Champion", 0, gameSchedulingPolicy));
        }catch (Exception e){
            assertTrue(e.getMessage().contains("0"));
        }

        try{
            assertTrue(unionRepresentiveController.ApplySchedulingPolicy("Champion", 2022, null));
        }catch (Exception e){
            assertTrue(e.getMessage().contains("gameSchedulingPolicy"));
        }
    }

}