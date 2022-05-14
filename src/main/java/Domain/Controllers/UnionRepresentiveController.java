package Domain.Controllers;

import DataAccess.LeagueDaoMongoDB;
import Domain.ManagementSystem.*;

public class UnionRepresentiveController extends EnrollledUserController{
    LeagueDaoMongoDB leagueMDB;

    public void  addGameScore(){

    }
    @Override
    public void showScreen() {

    }

    public void addRefTOSL(LeagueSeason leagueSeason, Referee referee) {
    }

    public void ApplySchedulingPolicy(String League, int year, GameSchedulingPolicy gameSchedulingPolicy) {

    }

    public LeagueSeason getLeagueBySeason(String League, int year){
        if (leagueMDB.get(League).isPresent()){
            League league = (League)(Object)leagueMDB.get(League);
            return league.getLeagueSeasonByYear(year);
        }
        return null;
    }
}
