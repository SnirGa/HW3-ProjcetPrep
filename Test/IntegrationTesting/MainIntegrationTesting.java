package IntegrationTesting;
import IntegrationTesting.UnionRepresentiveControllerTestings.LeagueMongoDBTestings;
import IntegrationTesting.UnionRepresentiveControllerTestings.UnionRepresentiveControllerTesting;
import IntegrationTesting.UserControllerTestings.UserControllerTestings;
import IntegrationTesting.UserControllerTestings.UserMongoDBTestings;
import org.junit.Test;

public class MainIntegrationTesting {
    @Test
    public void mainIntegrationTesting(){
        LeagueMongoDBTestings leagueMongoDBTestings=new LeagueMongoDBTestings();
        leagueMongoDBTestings.SaveGetDeleteLeague();
        UnionRepresentiveControllerTesting unionRepresentiveControllerTesting=new UnionRepresentiveControllerTesting();
        unionRepresentiveControllerTesting.addRefTOSLTest();
        unionRepresentiveControllerTesting.ApplySchedulingPolicy();
        UserControllerTestings userControllerTestings=new UserControllerTestings();
        userControllerTestings.loginTesting();
        UserMongoDBTestings userMongoDBTestings=new UserMongoDBTestings();
        userMongoDBTestings.SaveGetDeleteAllUser();


    }
}
