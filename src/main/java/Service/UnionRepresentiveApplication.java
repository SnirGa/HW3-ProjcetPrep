package Service;

import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.GameSchedulingPolicy;

public class UnionRepresentiveApplication {
    UnionRepresentiveController unionRepresentiveController=new UnionRepresentiveController();

    public boolean addRefereetoSL(String league, int year , String refereeUserName){
        //UC- add referee to league
        try {
            return unionRepresentiveController.addRefTOSL(league, year, refereeUserName);
        }catch (Exception e){

        }
        return false;
    }

    public boolean AddSchedulingPolicy(String League, int year, GameSchedulingPolicy gameSchedulingPolicy){
        //The game scheduling policy is an option from close predefined policies list.
        return unionRepresentiveController.ApplySchedulingPolicy(League, year,gameSchedulingPolicy);
    }


}
