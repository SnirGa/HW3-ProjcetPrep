package AcceptanceTesting;
import Service.UnionRepresentiveApplication;
import SetUpDB.SetUp;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddRefTOSLUCTest {
    @Test
    public void AddRefTOSLAcceptanceTestSet() {
        SetUp.SetUpDB();
        UnionRepresentiveApplication URUser = new UnionRepresentiveApplication();
        //Referee does not exist - assert false
        assertEquals("Referee does not exist in DB", URUser.addRefereetoSL("ChampionLeague", 2022, "Yossi2"));
        //League does not exist - assert false
        assertEquals("League is not valid", URUser.addRefereetoSL("Champ", 2022, "YossiYossi"));
        //Referee exist, league exist - assert True
        assertEquals("Successful add referee", URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
        //refereeUserName = null
        assertEquals("refereeUserName have to be entered", URUser.addRefereetoSL("ChampionLeague", 2022, null));
        //Year = 0
        assertEquals("Year can't be 0", URUser.addRefereetoSL("ChampionLeague", 0, "YossiYossi"));
        //LeagueName = null
        assertEquals("LeagueName have to be entered", URUser.addRefereetoSL(null, 2022, "YossiYossi"));
        //LeagueSeason = null
        assertEquals("LeagueSeason does not exist in DB", URUser.addRefereetoSL("ChampionLeague", 1800, "YossiYossi"));
        //Referee exist, league exist - assert True
        assertEquals("Referee already exist in this LeagueSeason", URUser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
    }
}
