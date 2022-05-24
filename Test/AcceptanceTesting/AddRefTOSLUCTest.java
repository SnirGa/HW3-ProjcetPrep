package AcceptanceTesting;

import Domain.Controllers.LeagueController;
import Domain.Controllers.UserController;
import Service.UnionRepresentiveApplication;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddRefTOSLUCTest {

    @Test
    void AddRefTOSLAcceptanceTestSet() {
        UnionRepresentiveApplication URuser = new UnionRepresentiveApplication();
        //Referee exist, league exist - assert True
        assertTrue(URuser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
        //Referee does not exist - assert false
        assertFalse(URuser.addRefereetoSL("ChampionLeague", 2022, "Yossi2"));

    }
}
