package DataAccess;
import Domain.ManagementSystem.Player;
import Domain.ManagementSystem.Referee;
import com.google.gson.Gson;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;

import static com.mongodb.client.model.Filters.eq;

public class RefereeDaoMongoDB implements Dao {
    Gson gson;
    MongoDatabase db;
    List referees;
    MongoCollection col;
    private static final RefereeDaoMongoDB instance=new RefereeDaoMongoDB();

    public RefereeDaoMongoDB() {
        this.gson=new Gson();
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep");
        this.col=db.getCollection("Referees");
    }
    @Override
    public Optional get(String username) {
        org.bson.Document doc = (Document) this.col.find(eq("userName", username)).first();
        String docJson = doc.toJson();
        Referee referee = gson.fromJson(docJson,Referee.class);
        return Optional.of(referee);
    }

    @Override
    public ArrayList getAll() {
        ArrayList<Referee> referees =new ArrayList<>();
        for (Object obj : col.find()) {
            // do something
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            Referee referee =gson.fromJson(docJson,Referee.class);
            referees.add(referee);
        }
        return referees;
    }

    @Override
    public void save(Object objRef) {
        Referee referee=(Referee)objRef;
        String jsonInString=gson.toJson(referee);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }

    @Override
    public void update(Object o) {
        this.delete(o);
        this.save(o);
    }

    @Override
    public void delete(Object o) {
        Referee referee=(Referee) o;
        Bson query = eq("userName", referee.getUserName() );
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }
}
