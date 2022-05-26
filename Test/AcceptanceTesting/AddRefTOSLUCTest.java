package AcceptanceTesting;

import DataAccess.LeagueDaoMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.ManagementSystem.League;
import Domain.ManagementSystem.LeagueSeason;
import Domain.ManagementSystem.Referee;
import Domain.ManagementSystem.UnionRepresentative;
import java.time.LocalDate;

import Service.UnionRepresentiveApplication;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddRefTOSLUCTest {
//    private void setUp(){
//        // Get league and referee mongodb classes
//        LeagueDaoMongoDB leagueDaoMongoDB = LeagueDaoMongoDB.getInstance();
//        RefereeDaoMongoDB refereeDaoMongoDB = RefereeDaoMongoDB.getInstance();
//        // Create Union Representative for the league
//        UnionRepresentative user = new UnionRepresentative("ChampionLeagueUR", "Admin1","ChampionLeagueUR");
//        // Create League
//        League league = new League("ChampionLeague", user);
//        LocalDate startDate = LocalDate.of(2022, 1,1);
//        LocalDate finishDate = LocalDate.of(2022, 4,1);
//        LeagueSeason leagueSeason = new LeagueSeason(league,2022, startDate, finishDate);
//        league.addLeagueSeason(leagueSeason);
//        leagueDaoMongoDB.save(league);
//        // Create new Referee to add
//        Referee referee = new Referee("YossiYossi", "123456", "Yossile", "mainReferee");
//        refereeDaoMongoDB.save(referee);
//    }

    @Test
    public void AddRefTOSLAcceptanceTestSet() {
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        //Referee does not exist - assert false
        assertEquals("league, year or refereeUserName are not valid", URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2"));
        //Referee exist, league exist - assert True
        assertEquals("Successful add referee", URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
    }
}
