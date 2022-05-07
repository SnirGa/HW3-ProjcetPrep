package Service;

import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.GameSchedulingPolicy;
import Domain.ManagementSystem.League;
import Domain.ManagementSystem.LeagueSeason;
import Domain.ManagementSystem.Referee;

public class UnionRepresentiveApplication {
    UnionRepresentiveController unionRepresentiveController=new UnionRepresentiveController();

    public void addRefereetoSL(LeagueSeason leagueSeason, Referee referee){
        //UC- add referee to league
        unionRepresentiveController.addRefTOSL(leagueSeason,referee);
    }

    public void AddSchedulingPolicy(LeagueSeason leagueSeason, GameSchedulingPolicy gameSchedulingPolicy){
        //The game scheduling policy is an option from close predefined policies list.
        unionRepresentiveController.ApplySchedulingPolicy(leagueSeason,gameSchedulingPolicy);
    }
}
