package UnitTesting;
import DataAccess.LeagueDaoMongoDBStub;
import DataAccess.RefereeDaoMongoDBStub;
import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.GameSchedulingPolicy1Game;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestUnionRepresentativeController {

    @Test
    public void testAddRefTOSL(){
        // create LeagueDaoMongoDBStub - lc and RefereeDaoMongoDBStub - rmdb
        LeagueDaoMongoDBStub lc = LeagueDaoMongoDBStub.getInstance();
        RefereeDaoMongoDBStub rmdb = RefereeDaoMongoDBStub.getInstance();
        UnionRepresentiveController urc = new UnionRepresentiveController(lc, rmdb);
        //False/True options
        try{
            //return true - League and Ref Exist:
            assertTrue(urc.addRefTOSL("Champion", 2022, "YossiYossi"));
            //return false - League Not Exist:
            assertFalse(urc.addRefTOSL("LeagueNotExist", 2022, "YossiYossi"));
        }catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }
        // check null for all arguments:
        // String leagueName == null
        try{
            urc.addRefTOSL(null, 2022, "YossiYossi");
        }catch (Exception e){
            assertEquals(e.getMessage(), "LeagueName have to be entered");
        }
        // int year < 1
        try{
            urc.addRefTOSL("Champion", 0, "YossiYossi");
        }catch (Exception e){
            assertEquals(e.getMessage(), "Year can't be 0");
        }
        // String refereeUserName == null
        try{
            urc.addRefTOSL("Champion", 2022, null);
        }catch (Exception e){
            assertEquals(e.getMessage(), "refereeUserName have to be entered");
        }
        //leagueSeason not exist
        try{
            urc.addRefTOSL("ChampionWithOutLeagueSeason", 2022, "YossiYossi");
        }catch (Exception e){
            assertEquals(e.getMessage(), "LeagueSeason does not exist in DB");
        }
        //Referee not exist
        try{
            urc.addRefTOSL("Champion", 2022, "YossiNotExist");
        }catch (Exception e){
            assertEquals(e.getMessage(), "Referee does not exist in DB");
        }
        //Referee already exist in LeagueSeason
        try{
            urc.addRefTOSL("Champion", 2022, "Yossi");
        }catch (Exception e){
            assertEquals(e.getMessage(), "Referee already exist in this LeagueSeason");
        }
        //Referee and LeagueSeason not exist
        try{
            urc.addRefTOSL("ChampionWithOutLeagueSeason", 2022, "YossiNotExist");
        }catch (Exception e){
            assertEquals(e.getMessage(), "LeagueSeason does not exist in DB");
        }
    }

    @Test
    public void testApplySchedulingPolicy(){
        // create LeagueDaoMongoDBStub - lc and use UnionRepresentiveController(Dao lc, null) for constructur
        LeagueDaoMongoDBStub lc2 = LeagueDaoMongoDBStub.getInstance();
        UnionRepresentiveController unionRepresentiveController = new UnionRepresentiveController(lc2,null);
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
