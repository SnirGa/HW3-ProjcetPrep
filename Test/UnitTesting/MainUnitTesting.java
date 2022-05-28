package UnitTesting;
import org.junit.Test;

public class MainUnitTesting {
    @Test
    public void mainUnitTesting(){
        TestUserController testUserController = new TestUserController();
        testUserController.testUserControllerLogin();
        TestUnionRepresentativeController testUnionRepresentativeController = new TestUnionRepresentativeController();
        testUnionRepresentativeController.testAddRefTOSL();
        testUnionRepresentativeController.testApplySchedulingPolicy();
    }
}
