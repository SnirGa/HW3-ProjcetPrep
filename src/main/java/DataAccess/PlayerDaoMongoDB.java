package DataAccess;

import Domain.ManagementSystem.Player;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class PlayerDaoMongoDB implements Dao {
    Gson gson;
    MongoDatabase db;
    MongoCollection col;

    private static final PlayerDao instance=new PlayerDao();

    public  static PlayerDao getInstance(){return instance;}
    public PlayerDaoMongoDB() {
        this.gson=new Gson();
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep");
        this.col=db.getCollection("Players");
    }

    @Override
    public Optional get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();

        return Optional.empty();

    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    @Override
    public void save(Object o) {
        Player player=(Player)o;
        String jsonInString=gson.toJson(player);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }

    @Override
    public void update(Object o, String[] params) {

    }

    @Override
    public void delete(Object o) {

    }
}
