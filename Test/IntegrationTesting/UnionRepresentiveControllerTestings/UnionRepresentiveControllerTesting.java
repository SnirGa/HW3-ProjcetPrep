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

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class UnionRepresentiveControllerTesting {

    @Test
    public void addRefTOSLTest(){
        UnionRepresentiveController UrUser = new UnionRepresentiveController();
        //Referee does not exist - assert false
        try{
            UrUser.addRefTOSL("ChampionLeague", 2022, "Yossi2");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Referee does not exist in DB"));
        }
        //Referee exist, league exist - assert True
        try{
            UrUser.addRefTOSL("ChampionLeague", 2022, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Successful add referee"));
        }
        //refereeUserName = null
        try{
            UrUser.addRefTOSL("ChampionLeague", 2022, null);
        }catch (Exception e){
            assertTrue(e.getMessage().contains("refereeUserName have to be entered"));
        }
        //Year = 0
        try{
            UrUser.addRefTOSL("ChampionLeague", 0, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Year can't be 0"));
        }
        //LeagueName = null
        try{
            UrUser.addRefTOSL(null, 2022, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("LeagueName have to be entered"));
        }
        //LeagueSeason = null
        try{
            UrUser.addRefTOSL("ChampionLeague", 1800, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("LeagueSeason does not exist in DB"));
        }
        //Referee already exist
        try{
            UrUser.addRefTOSL("ChampionLeague", 2022, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Referee already exist in this LeagueSeason"));
        }
        //League does not exist - assert false
        try {
            assertFalse(UrUser.addRefTOSL("Champ", 2022, "YossiYossi"));
        }
        catch (Exception e){

    }

//        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
//        //Referee does not exist - assert false
//        String ret = URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2");
//        Assert.assertEquals("Referee does not exist in DB", ret);
//        //Referee exist, league exist - assert True
//        ret = URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi");
//        Assert.assertEquals("Successful add referee", ret);
//        ret = URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi");
//        Assert.assertEquals("league, year or refereeUserName are not valid", ret);
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
            boolean bool = URUser.ApplySchedulingPolicy("Non-Exist", 2022, gameSchedulingPolicy1);
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

