package DataAccess;

import Domain.ManagementSystem.Coach;

import java.util.*;

public class CoachDao implements Dao<Coach> {
    private ArrayList<Coach> coaches;

    public CoachDao() {
        this.coaches=new ArrayList<>();
    }

    @Override


    public Optional<Coach> get(String username) {
        for (int i=0;i<this.coaches.size(); i++){
            Coach iterateCoach=this.coaches.get(i);
            if (iterateCoach.getUserName()==username){
                return Optional.of(iterateCoach);
            }
            }
        return null;
        }


    @Override
    public ArrayList<Coach> getAll() {
        return this.coaches;
    }

    @Override
    public void save(Coach coach) {
        this.coaches.add(coach);
    }

    @Override
    public void update(Coach coach) {

    }

    @Override
    public void delete(Coach coach) {

    }
}
