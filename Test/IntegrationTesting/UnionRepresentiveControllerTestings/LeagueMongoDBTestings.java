package IntegrationTesting.UnionRepresentiveControllerTestings;
import DataAccess.*;
import Domain.ManagementSystem.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class LeagueMongoDBTestings {
    LeagueDaoMongoDB leagueDaoMongoDB = LeagueDaoMongoDB.getInstance();
    UserDaoMongoDB userDaoMongoDB = UserDaoMongoDB.getInstance();

    @Test
    public void SaveGetDeleteLeague(){
        UnionRepresentative unionUser1 = new UnionRepresentative("TestLeagueUR", "Admin1","ChampionLeagueUR");

        // Create and Save League
        League TestLeague = new League("TestLeague",unionUser1);
        leagueDaoMongoDB.save(TestLeague);


        //Test Get League
        Optional getTestLeagueOptional = leagueDaoMongoDB.get("TestLeague");
        assertFalse(getTestLeagueOptional.isEmpty());
        League getTestLeague = (League)getTestLeagueOptional.get();

        // Test Update League
        LocalDate startDateChampionLeague = LocalDate.of(2022, 1,1);
        LocalDate finishDateChampionLeague = LocalDate.of(2022, 4,1);
        LeagueSeason TestLeagueSeason = new LeagueSeason(TestLeague,2022, startDateChampionLeague, finishDateChampionLeague);
        for (int i = 0; i<7; i++){
            Team t = new Team(true, "team" + i , null );
            TestLeagueSeason.addTeam(t);
        }
        getTestLeague.addLeagueSeason(TestLeagueSeason);
        leagueDaoMongoDB.update(getTestLeague);
        Optional getTestLeagueAfterUpdateOptional = leagueDaoMongoDB.get("TestLeague");
        assertFalse(getTestLeagueAfterUpdateOptional.isEmpty());
        League getTestLeagueAfterUpdate = (League)getTestLeagueAfterUpdateOptional.get();
        assertNotNull(getTestLeagueAfterUpdate.getLeagueSeasonByYear(2022));

        //Test Delete League
        leagueDaoMongoDB.delete(getTestLeagueAfterUpdate);
        Optional getTestLeagueAfterDelete = leagueDaoMongoDB.get("TestLeague");
        assertTrue(getTestLeagueAfterDelete.isEmpty());

    }
}
