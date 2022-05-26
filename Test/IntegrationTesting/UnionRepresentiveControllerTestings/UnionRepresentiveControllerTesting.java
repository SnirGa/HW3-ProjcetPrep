package IntegrationTesting.UnionRepresentiveControllerTestings;

import DataAccess.LeagueDaoMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.League;
import Domain.ManagementSystem.LeagueSeason;
import Domain.ManagementSystem.Referee;
import Domain.ManagementSystem.UnionRepresentative;
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
    public void getLeagueSeasonByYearTest(){
        League Exist=new League("Champs",new UnionRepresentative("sdcds","scsd","Sddcs"));
        LocalDate start=LocalDate.of(1200,2,1);
        LocalDate end=LocalDate.of(1200,2,1);
        LeagueSeason leagueSeason=new LeagueSeason(Exist,2020,start,end);
        Exist.addLeagueSeason(leagueSeason);
        UnionRepresentiveController unionRepresentiveController=new UnionRepresentiveController();

    }

    @Test
    public void addRefTOSLTest() throws Exception {
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        //Referee does not exist - assert false
        Assert.assertEquals("league, year or refereeUserName are not valid", URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2"));
        //Referee exist, league exist - assert True
        Assert.assertEquals("Successful add referee", URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
//        Referee referee=new Referee("Shahak123","123456","shsds","Scdsscd");
//        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
//        refereeDaoMongoDB.save(referee);
//        UnionRepresentiveController unionRepresentiveController=new UnionRepresentiveController();
//        League Exist=new League("Champs",new UnionRepresentative("sdcds","scsd","Sddcs"));
//        LocalDate start=LocalDate.of(1200,2,1);
//        LocalDate end=LocalDate.of(1200,2,1);
//        LeagueSeason leagueSeason=new LeagueSeason(Exist,2020,start,end);
//        Exist.addLeagueSeason(leagueSeason);
//        LeagueDaoMongoDB leagueDaoMongoDB=LeagueDaoMongoDB.getInstance();
//        leagueDaoMongoDB.save(Exist);
//        Optional<League> optionalLeague=leagueDaoMongoDB.get("Champs");
//        try {
//            unionRepresentiveController.addRefTOSL(Exist.getName(),2020,"Shahak123");
//            leagueDaoMongoDB.update(Exist);
//            optionalLeague=leagueDaoMongoDB.get("Champs");
//            assertTrue(optionalLeague.get().getLeagueSeasonByYear(2020).getLstReferee().get(0).getName().equals("Shahak123"));
//
//        } catch (Exception e) {
//            throw new Exception("There was an error during the process");
//        }
//        if (!optionalLeague.isEmpty()){
//            assertTrue(optionalLeague.get().getLeagueSeasonByYear(2020)!=null);
//            assertTrue(optionalLeague.get().getLeagueSeasonByYear(2021)==null);

        }
    }

