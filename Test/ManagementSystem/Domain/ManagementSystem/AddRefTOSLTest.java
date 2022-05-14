package Domain.ManagementSystem;
import Domain.Controllers.LeagueController;
import Domain.Controllers.RefereeController;
import Domain.Controllers.UserController;
import Service.LeagueApplication;
import Service.UnionRepresentiveApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class AddRefTOSLTest {
    UnionRepresentiveApplication URuser;
    @BeforeEach
    void setUp() {
        URuser = new UnionRepresentiveApplication();
    }

    @Test
    void TestAddReferee(){
        //Referee exist, league exist - assert True
        assertTrue(URuser.addRefereetoSL("ChampionLeague", 2022, "YossiYossi"));
        //Referee does not exist - assert false
        assertFalse(URuser.addRefereetoSL("ChampionLeague", 2022, "Yossi2"));
        //Referee added to list - assert true
        assertTrue(LeagueController.getLeagueBySeason("ChampionLeague",2022).getLstReferee().contains(UserController.getUser("YossiYossi")));

    }


}
