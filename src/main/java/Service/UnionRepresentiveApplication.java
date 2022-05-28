package Service;

import Domain.Controllers.UnionRepresentiveController;
import Domain.ManagementSystem.GameSchedulingPolicy;

public class UnionRepresentiveApplication {
    UnionRepresentiveController unionRepresentiveController = new UnionRepresentiveController();

    public String addRefereetoSL(String league, int year , String refereeUserName){
        //UC- add referee to league
        try {
//            return unionRepresentiveController.addRefTOSL(league, year, refereeUserName);
            if(unionRepresentiveController.addRefTOSL(league, year, refereeUserName))
                return("Successful add referee");
            else{
                return("League is not valid");
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public String AddSchedulingPolicy(String League, int year, GameSchedulingPolicy gameSchedulingPolicy){
        //The game scheduling policy is an option from close predefined policies list.
        try {
            if(unionRepresentiveController.ApplySchedulingPolicy(League, year,gameSchedulingPolicy)){
                return("Successful add Scheduling Policy");
            }
            else{
                return("League is not valid");
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }


}
