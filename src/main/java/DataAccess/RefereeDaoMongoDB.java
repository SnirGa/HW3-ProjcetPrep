package DataAccess;

import Domain.ManagementSystem.Referee;
import com.mongodb.client.MongoCollection;

import javax.swing.text.Document;
import java.util.*;

public class RefereeDaoMongoDB implements Dao {
    DB db;
    List referees;
    MongoCollection mongoCollection;
    public RefereeDaoMongoDB(){
        this.db=new DB();
        this.mongoCollection=db.getCollection("Referees");
        this.referees= Arrays.asList(mongoCollection.find().into(new ArrayList<Referee>()).toArray());
    }
    @Override
    public Optional get(long id) {
        return Optional.of(3); //c
    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void save(Object referee) {

    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
