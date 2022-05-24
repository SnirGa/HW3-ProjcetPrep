package Domain.Controllers;

import DataAccess.Dao;
import DataAccess.LeagueDaoMongoDB;
//import DataAccess.UnionRepresentiveMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.ManagementSystem.*;

public class UnionRepresentiveController extends EnrollledUserController{
    Dao rMDB;
    Dao leagueMDB;

    public UnionRepresentiveController() {
        rMDB = RefereeDaoMongoDB.getInstance();
        leagueMDB = LeagueDaoMongoDB.getInstance();
    }

    public UnionRepresentiveController(Dao lc, Dao rmdb) {
        if(rMDB == null){
            rMDB = RefereeDaoMongoDB.getInstance();
        }
        else {
            rMDB = rmdb;
        }
        if(lc == null){
            leagueMDB = LeagueDaoMongoDB.getInstance();
        }
        else{
            leagueMDB = lc;
        }
    }

    public void  addGameScore(){
    }
    @Override
    public void showScreen() {
    }

    public boolean addRefTOSL(String league, int year, String refereeUserName) {
        LeagueSeason leagueSeason = getLeagueBySeason(league, year);
        Referee referee = (Referee)(Object)rMDB.get(refereeUserName);
        if (leagueSeason != null && referee != null){
            if(leagueSeason.getLstReferee().contains(referee)){
                return false;
            }
            leagueSeason.addReferee(referee);
            return true;
        }
        return false;
    }

    public boolean ApplySchedulingPolicy(String League, int year, GameSchedulingPolicy gameSchedulingPolicy) {
        LeagueSeason leagueSeason = getLeagueBySeason(League, year);
        if (leagueSeason != null){
            leagueSeason.setGameSchedulingPolicy(gameSchedulingPolicy);
            return gameSchedulingPolicy.ApplyGamePolicy(leagueSeason);
        }
        return false;
    }


    private LeagueSeason getLeagueBySeason(String League, int year){
        if (leagueMDB.get(League).isPresent()){
            League league = (League)(Object)leagueMDB.get(League);
            return league.getLeagueSeasonByYear(year);
        }
        return null;
    }

}
