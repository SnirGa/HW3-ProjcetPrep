package IntegrationTesting.UnionRepresentiveControllerTestings;

import DataAccess.RefereeDaoMongoDB;
import Domain.ManagementSystem.Referee;
import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefereeMongoDB {
    @Test
    public void SaveAndGetTestingAndDelete(){
        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
        Referee referee=new Referee("Kobkob123","123456","Kobi Kobi","main");
        refereeDaoMongoDB.save(referee);
        Optional<Referee> optional=refereeDaoMongoDB.get(referee.getUserName());
        Optional<Referee> NotExist=refereeDaoMongoDB.get("NotExist");
        assertTrue(referee.getPassword().equals(optional.get().getPassword())); //checks save and get
        assertTrue(NotExist.isEmpty()); //check get of notexist item
        refereeDaoMongoDB.delete(optional.get());
        assertTrue(NotExist.isEmpty()); //check get of notexist item

    }
    @Test
    public void updateTesting(){
        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
        Referee referee=new Referee("Kobkob123","123456","Kobi Kobi","main");
        refereeDaoMongoDB.save(referee);
        referee.setUserName("rs");
        refereeDaoMongoDB.update(referee);
        Optional<Referee> optional=refereeDaoMongoDB.get("rs");
        assertTrue(referee.getPassword().equals(optional.get().getPassword()));

    }
}
