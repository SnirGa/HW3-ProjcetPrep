package AcceptanceTesting;

import Service.UnionRepresentiveApplication;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddRefTOSLUCTest {

    @Test
    public void AddRefTOSLAcceptanceTestSet() {
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        //Referee does not exist - assert false
        assertEquals("league, year or refereeUserName are not valid", URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2"));
        //Referee exist, league exist - assert True
        assertEquals("Successful add referee", URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
    }
}
