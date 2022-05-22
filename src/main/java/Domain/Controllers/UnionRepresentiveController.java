package Domain.Controllers;

import DataAccess.LeagueDaoMongoDB;
//import DataAccess.UnionRepresentiveMongoDB;
import DataAccess.RefereeDaoMongoDB;
import Domain.ManagementSystem.*;

public class UnionRepresentiveController extends EnrollledUserController{
    LeagueDaoMongoDB leagueMDB;
    //UnionRepresentiveMongoDB urMDB;
    RefereeDaoMongoDB rMDB;

    public UnionRepresentiveController() {
        //urMDB = UnionRepresentiveMongoDB.getInstance();
        rMDB = RefereeDaoMongoDB.getInstance();
    }

    public void  addGameScore(){
    }
    @Override
    public void showScreen() {
    }

    public boolean addRefTOSL(String league, int year, String refereeUserName) {
        LeagueSeason leagueSeason = LeagueController.getLeagueBySeason(league, year);
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
        LeagueSeason leagueSeason = LeagueController.getLeagueBySeason(League, year);
        if (leagueSeason != null){
            leagueSeason.setGameSchedulingPolicy(gameSchedulingPolicy);
            if (gameSchedulingPolicy.ApplyGamePolicy(leagueSeason)){
                return true;
            }
        }
        return false;
    }

}
