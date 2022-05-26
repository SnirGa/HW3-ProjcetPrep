package DataAccess;

import Domain.ManagementSystem.Fan;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class FanDaoMongoDB extends Dao<Fan> {
    private MongoDatabase db;
    private MongoCollection col;
    private static final FanDaoMongoDB instance = new FanDaoMongoDB();

    public FanDaoMongoDB() {
        MongoClient client = MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db = client.getDatabase("ProjectPrep"); //get the project database
        this.col = db.getCollection("Fans"); //get the fan collection from the database
    }

    public static FanDaoMongoDB getInstance(){return instance;}

    @Override
    public Optional get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            Fan fan = gson.fromJson(docJson, Fan.class); //convert json to fan Object
            return Optional.of(fan);
        } catch (Exception e) {
            return Optional.empty();
        }    }

    @Override
    public ArrayList<Fan> getAll() {
        ArrayList<Fan> fans = new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc = (Document) obj;
            String docJson = currDoc.toJson();
            Fan fan = gson.fromJson(docJson, Fan.class);
            fans.add(fan);
        }
        return fans;
    }

    @Override
    public void save(Fan fan) {
        String jsonInString = gson.toJson(fan);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);

    }

    @Override
    public void update(Fan fan) {
        this.delete(fan);
        this.save(fan);
    }

    @Override
    public void delete(Fan fan) {
        Bson query = eq("userName", fan.getUserName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }

    }
}
