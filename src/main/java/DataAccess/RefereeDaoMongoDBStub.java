package DataAccess;

import Domain.ManagementSystem.Game;
import Domain.ManagementSystem.Referee;
import Domain.ManagementSystem.UnionRepresentive;

import java.util.ArrayList;
import java.util.Optional;

public class RefereeDaoMongoDBStub implements Dao{

    private static final RefereeDaoMongoDBStub instance = new RefereeDaoMongoDBStub();

    private RefereeDaoMongoDBStub(){}

    public static RefereeDaoMongoDBStub getInstance(){ return instance;}

    public ArrayList<Referee> referees = new ArrayList();


    public void addReferee(Referee referee){
        referees.add(referee);
    }
    @Override
    public Optional get(String username) {

        if (username.equals("YossiYossi")){
            Referee referee = new Referee("YossiYossi", "Yossi1", "yossiyossi","1");
            return Optional.of(referee);
        }
        else if (username.equals("Yossi")){
//            Referee refereeInLeagueSeason = new Referee("Yossi", "Yossi", "yossi","1");
            return Optional.of(referees.get(referees.size()-1));
        }
        return Optional.empty();
//        return null;
    }


    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }
}
