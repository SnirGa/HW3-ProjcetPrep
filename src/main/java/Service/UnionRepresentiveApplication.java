package Service;

import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.GameSchedulingPolicy;
import Domain.ManagementSystem.LeagueSeason;
import Domain.ManagementSystem.Referee;

public class UnionRepresentiveApplication {
    UnionRepresentiveController unionRepresentiveController=new UnionRepresentiveController();

    public boolean addRefereetoSL(String league, int year , Referee referee){
        //UC- add referee to league
        return unionRepresentiveController.addRefTOSL(league,year,referee);
    }

    public void AddSchedulingPolicy(String League, int year, GameSchedulingPolicy gameSchedulingPolicy){
        //The game scheduling policy is an option from close predefined policies list.
        unionRepresentiveController.ApplySchedulingPolicy(League, year,gameSchedulingPolicy);
    }
}
