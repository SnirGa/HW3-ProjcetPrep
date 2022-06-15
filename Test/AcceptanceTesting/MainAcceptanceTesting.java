package AcceptanceTesting;
import UnitTesting.TestUnionRepresentativeController;
import UnitTesting.TestUserController;
import org.junit.Test;

public class MainAcceptanceTesting {
    @Test
    public void mainAcceptanceTesting(){
        LoginUCTest loginUCTest = new LoginUCTest();
        loginUCTest.loginAcceptanceTestSet();
        AddRefTOSLUCTest addRefTOSLUCTest = new AddRefTOSLUCTest();
        addRefTOSLUCTest.AddRefTOSLAcceptanceTestSet();
        AddSchedulingPolicyUCTest addSchedulingPolicyUCTest = new AddSchedulingPolicyUCTest();
        addSchedulingPolicyUCTest.AddSchedulingPolicy2GameTestSet();
        addSchedulingPolicyUCTest.GameSchedulingPolicy1GameTestSet();
    }
}
