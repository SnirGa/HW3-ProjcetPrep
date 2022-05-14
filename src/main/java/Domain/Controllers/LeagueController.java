package Domain.Controllers;

import Domain.ManagementSystem.League;
import DataAccess.LeagueDaoMongoDB;
import Domain.ManagementSystem.LeagueSeason;

public class LeagueController {
    static LeagueDaoMongoDB leagueMDB;

    public static LeagueSeason getLeagueBySeason(String League, int year){
        if (leagueMDB.get(League).isPresent()){
            League league = (League)(Object)leagueMDB.get(League);
            return league.getLeagueSeasonByYear(year);
        }
        return null;
    }
}
