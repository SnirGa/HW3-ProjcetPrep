package AcceptanceTesting;

import Domain.Controllers.LeagueController;
import Domain.Controllers.UserController;
import Service.UnionRepresentiveApplication;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddRefTOSLUCTest {

    @Test
    public void AddRefTOSLAcceptanceTestSet() {
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        //Referee does not exist - assert false
        assertFalse(URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2"));
        //Referee exist, league exist - assert True
        assertTrue(URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
    }
}
