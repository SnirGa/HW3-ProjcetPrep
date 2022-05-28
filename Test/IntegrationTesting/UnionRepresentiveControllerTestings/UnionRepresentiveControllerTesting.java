package IntegrationTesting.UnionRepresentiveControllerTestings;

import DataAccess.LeagueDaoMongoDB;
import DataAccess.LeagueDaoMongoDBStub;
import DataAccess.RefereeDaoMongoDB;
import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.*;
import Service.UnionRepresentiveApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

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
        LocalDate startDate = LocalDate.of(2022,1,1);
        LocalDate endDate = LocalDate.of(2022,12,1);

        UnionRepresentative ur = new UnionRepresentative("SnirTheKing", "123456", "SnirGa");


        League leagueWithOutStartDate = new League("ChampionWithOutStartDate", ur);
        LeagueSeason leagueSeason = new LeagueSeason(leagueWithOutStartDate, 2022, null, endDate);
        leagueSeason.addTeam(new Team(true,"Team1",null));
        leagueSeason.addTeam(new Team(true,"Team2",null));
        leagueWithOutStartDate.addLeagueSeason(leagueSeason);

        League leagueWithOutTeamsAndStartDate = new League("ChampionWithOutTeamsAndStartDate", ur);
        LeagueSeason leagueSeason2 = new LeagueSeason(leagueWithOutTeamsAndStartDate, 2022, null, endDate);
        leagueWithOutTeamsAndStartDate.addLeagueSeason(leagueSeason2);

        League leagueWithOutTeams = new League("ChampionWithOutTeams", ur);
        LeagueSeason leagueSeason1 = new LeagueSeason(leagueWithOutTeams, 2022, startDate, endDate);
        leagueWithOutTeams.addLeagueSeason(leagueSeason1);

        leagueDaoMongoDB.save(leagueWithOutStartDate);
        leagueDaoMongoDB.save(leagueWithOutTeamsAndStartDate);
        leagueDaoMongoDB.save(leagueWithOutTeams);
//        LeagueDaoMongoDB leagueDaoMongoDB = LeagueDaoMongoDB.getInstance();
        UnionRepresentiveController unionRepresentiveController = new UnionRepresentiveController();
        GameSchedulingPolicy1Game gameSchedulingPolicy = new GameSchedulingPolicy1Game();

        try{
            //return true - League exist without a schedule policy:
            assertTrue(unionRepresentiveController.ApplySchedulingPolicy("ChampionLeague", 2022, gameSchedulingPolicy));

            //return false - League Not Exist:
            assertFalse(unionRepresentiveController.ApplySchedulingPolicy("LeagueNotExist", 2022, gameSchedulingPolicy));
        }catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }
        // int year < 1
        try{
            unionRepresentiveController.ApplySchedulingPolicy("ChampionLeague", 0, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "Year can't be 0");
        }



        //leagueSeason not exist
        try {
            unionRepresentiveController.ApplySchedulingPolicy("ChampionLeague", 2026, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason does not exist in DB");
        }

        //leagueSeason applied Game Scheduling Policy
        try {
            unionRepresentiveController.ApplySchedulingPolicy("ChampionLeague", 2022, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason already have applied Game Scheduling Policy");
        }
        //leagueSeason without teams and without a start date
        try {
            unionRepresentiveController.ApplySchedulingPolicy("ChampionWithOutTeamsAndStartDate", 2022, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason must have teams and startDate");
        }
        //leagueSeason without teams
        try {
            unionRepresentiveController.ApplySchedulingPolicy("ChampionWithOutTeams", 2022, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason must have teams and startDate");
        }
        //leagueSeason without startDate
        try {
            unionRepresentiveController.ApplySchedulingPolicy("ChampionWithOutStartDate", 2022, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason must have teams and startDate");
        }

        leagueDaoMongoDB.delete(leagueWithOutStartDate);
        leagueDaoMongoDB.delete(leagueWithOutTeamsAndStartDate);
        leagueDaoMongoDB.delete(leagueWithOutTeams);




//        LeagueDaoMongoDB leagueDaoMongoDB=LeagueDaoMongoDB.getInstance();
//        UnionRepresentiveController URUser = new UnionRepresentiveController();
//        GameSchedulingPolicy gameSchedulingPolicy1 = new GameSchedulingPolicy1Game();
//        League league=new League("SomeLeague",new UnionRepresentative("Shahak123","123456","Shahak"));
//        LocalDate start=LocalDate.of(2020,2,1);
//        LocalDate end=LocalDate.of(2020,2,1);
//        LeagueSeason leagueSeason=new LeagueSeason(league,2023,start,end);
//        league.addLeagueSeason(leagueSeason);
//        leagueDaoMongoDB.save(league);
//
//        //LeagueSeason not exist
//        try {
//            //League-Season without a policy
//            boolean bool = URUser.ApplySchedulingPolicy("SomeLeague", 2023, gameSchedulingPolicy1);
//            assertTrue(bool);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            //League-Season without a policy
//            boolean bool = URUser.ApplySchedulingPolicy("SomeLeague", 2023, gameSchedulingPolicy1);
//            assertTrue(bool);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        leagueDaoMongoDB.delete(league);
//        //Non-exist League
//        try {
//            boolean bool = URUser.ApplySchedulingPolicy("Non-Exist", 2022, gameSchedulingPolicy1);
//            assertFalse(bool);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //League-Season already with policy
//        try {
//            boolean bool = URUser.ApplySchedulingPolicy("ChampionLeague", 1999, gameSchedulingPolicy1);
//            assertFalse(bool);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

