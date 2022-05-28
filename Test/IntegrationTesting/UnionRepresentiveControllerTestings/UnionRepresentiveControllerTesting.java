package IntegrationTesting.UnionRepresentiveControllerTestings;

import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import SetUpDB.*;

public class UnionRepresentiveControllerTesting {

    @Test
    public void addRefTOSLTest(){
        SetUp.SetUpDB();
        UnionRepresentiveController UrUser = new UnionRepresentiveController();
        //LeagueName = null
        try{
            UrUser.addRefTOSL(null, 2022, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("LeagueName have to be entered"));
        }
        //Year = 0
        try{
            UrUser.addRefTOSL("ChampionLeague", 0, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Year can't be 0"));
        }
        //refereeUserName = null
        try{
            UrUser.addRefTOSL("ChampionLeague", 2022, null);
        }catch (Exception e){
            assertTrue(e.getMessage().contains("refereeUserName have to be entered"));
        }
        //False/True Check
        try {
            //League does not exist - assert false
            assertFalse(UrUser.addRefTOSL("Champ", 2022, "YossiYossi"));
            //Referee exist, league exist - assert True
            assertTrue(UrUser.addRefTOSL("ChampionLeague", 2022, "YossiYossi"));
        } catch (Exception e){
            assertFalse(e.getMessage().length() > 0);
        }
        //LeagueSeason == null
        try{
            UrUser.addRefTOSL("ChampionLeague", 1800, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("LeagueSeason does not exist in DB"));
        }
        //Referee does not exist - assert false
        try{
            UrUser.addRefTOSL("ChampionLeague", 2022, "Yossi2");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Referee does not exist in DB"));
        }
        //Referee already exist
        try{
            UrUser.addRefTOSL("ChampionLeague", 2022, "YossiYossi");
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Referee already exist in this LeagueSeason"));
        }
    }

    @Test
    public void ApplySchedulingPolicy() {
        SetUp.SetUpDB();
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
            unionRepresentiveController.ApplySchedulingPolicy("LeagueWithOutTeamsAndStartDate", 2022, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason must have teams and startDate");
        }
        //leagueSeason without teams
        try {
            unionRepresentiveController.ApplySchedulingPolicy("LeagueWithOutTeams", 2022, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason must have teams and startDate");
        }
        //leagueSeason without startDate
        try {
            unionRepresentiveController.ApplySchedulingPolicy("LeagueWithOutStartDate", 2022, gameSchedulingPolicy);
        }catch (Exception e){
            Assertions.assertEquals(e.getMessage(), "LeagueSeason must have teams and startDate");
        }
    }
}

