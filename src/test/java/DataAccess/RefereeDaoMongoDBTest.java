package DataAccess;

import Domain.ManagementSystem.FilledRole;
import Domain.ManagementSystem.Referee;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RefereeDaoMongoDBTest {

    @Test
    void get() {
        Referee referee=new Referee("Hodaya123","123456","Hodaya Messi", "high");
        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
        refereeDaoMongoDB.save(referee);
        Optional<Referee> fromdb=refereeDaoMongoDB.get(referee.getUserName());
        assertNotNull(fromdb.get());
        Optional<Referee> fromdb2=refereeDaoMongoDB.get("notExist");
        assertTrue(fromdb2.isEmpty());
//        refereeDaoMongoDB.delete(referee);

    }
    @Test
    void getAll() {
        Referee referee1=new Referee("Hodaya123","123456","Hodaya Messi", "high");
        Referee referee2=new Referee("Roni123","123456","Roni Ronaldo", "high");

        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
        refereeDaoMongoDB.save(referee1);
        ArrayList<Referee> referees=refereeDaoMongoDB.getAll();
        refereeDaoMongoDB.save(referee2);
        referees=refereeDaoMongoDB.getAll();
        assertTrue(referees.size()==2);
//        refereeDaoMongoDB.delete(referee1);
//        refereeDaoMongoDB.delete(referee2);
    }

    @Test
    void save() {
        Referee referee1=new Referee("Hodaya123","123456","Hodaya Messi", "high");
        Referee referee2=new Referee("Roni123","123456","Roni Ronaldo", "high");

        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
        refereeDaoMongoDB.save(referee1);
        refereeDaoMongoDB.save(referee2);

        Optional optional1=refereeDaoMongoDB.get("Hodaya123");
        Optional optional2=refereeDaoMongoDB.get("Roni123");
        assertNotNull(optional1.get());
        assertNotNull(optional2.get());
//        refereeDaoMongoDB.delete(referee1);
//        refereeDaoMongoDB.delete(referee2);

    }

    @Test
    void update() {
        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
        Referee referee=new Referee("Hodaya123","123456","Hodaya Messi", "high");
        referee.setName("Hodaya Taka");
        refereeDaoMongoDB.update(referee);
        Optional<Referee> op=refereeDaoMongoDB.get(referee.getUserName());
        assertTrue(referee.getName().equals(op.get().getName()));
//        refereeDaoMongoDB.delete(referee);
    }

//    @Test
//    void delete() {
//        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
//        Referee referee=new Referee("Hodaya123","123456","Hodaya Messi", "high");
//        refereeDaoMongoDB.save(referee);
//        ArrayList<Referee> referees=refereeDaoMongoDB.getAll();
//        refereeDaoMongoDB.delete(referee);
//        referees=refereeDaoMongoDB.getAll();
//        assertTrue(referees.size()==0);
//


//    }
}