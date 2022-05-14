package Domain.Controllers;
import DataAccess.UnionRepresentiveMongoDB;
import Domain.ManagementSystem.*;

public class UnionRepresentiveController extends EnrollledUserController{
    UnionRepresentiveMongoDB urMDB;

    public UnionRepresentiveController() {
        urMDB = UnionRepresentiveMongoDB.getInstance();
    }

    public void  addGameScore(){
    }
    @Override
    public void showScreen() {
    }

    public boolean addRefTOSL(String league, int year, Referee referee) {
        leagueSeason = getLeagueBySeason(league, year);
        if (leagueSeason != null && referee != null){
            if (leagueSeason.getLstReferee.contains(referee)){
                return false;
            }
            leagueSeason.addReferee(referee);
            return true;
        }
        return false;
    }

    public void ApplySchedulingPolicy(LeagueSeason leagueSeason, GameSchedulingPolicy gameSchedulingPolicy) {
    }

}
