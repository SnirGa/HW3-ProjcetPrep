package DataAccess;

import Domain.ManagementSystem.Player;
import com.google.gson.Gson;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class PlayerDaoMongoDB implements Dao {
    Gson gson;
    MongoDatabase db;
    MongoCollection col;

    private static final PlayerDaoMongoDB instance=new PlayerDaoMongoDB();

    public  static PlayerDaoMongoDB getInstance(){return instance;}
    public PlayerDaoMongoDB() {
        this.gson=new Gson();
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep");
        this.col=db.getCollection("Players");
    }

    @Override
    public Optional get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        String docJson=doc.toJson();
        Player player=gson.fromJson(docJson,Player.class);
        return Optional.of(player);
    }

    @Override
    public ArrayList getAll() {
        ArrayList<Player> players=new ArrayList<>();
        for (Object obj : col.find()) {
            // do something
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            Player player=gson.fromJson(docJson,Player.class);
            players.add(player);
        }
        return players;
    }

    @Override
    public void save(Object o) {
        Player player=(Player)o;
        String jsonInString=gson.toJson(player);
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
        Player player=(Player) o;
        Bson query = eq("userName",player.getUserName() );
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }


    }
}
