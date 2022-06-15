import AcceptanceTesting.MainAcceptanceTesting;
import IntegrationTesting.MainIntegrationTesting;
import UnitTesting.MainUnitTesting;
import org.junit.Test;

public class MainTesting {
    @Test
    public void mainTesting(){
        MainUnitTesting mainUnitTesting = new MainUnitTesting();
        mainUnitTesting.mainUnitTesting();
        MainAcceptanceTesting mainAcceptanceTesting = new MainAcceptanceTesting();
        mainAcceptanceTesting.mainAcceptanceTesting();
        MainIntegrationTesting mainIntegrationTesting = new MainIntegrationTesting();
        mainIntegrationTesting.mainIntegrationTesting();
    }
}
