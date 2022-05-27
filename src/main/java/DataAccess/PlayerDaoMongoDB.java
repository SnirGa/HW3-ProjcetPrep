package DataAccess;

import Domain.ManagementSystem.Player;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class PlayerDaoMongoDB extends Dao<Player> {
    private MongoDatabase db;
    private MongoCollection col;

    private static final PlayerDaoMongoDB instance=new PlayerDaoMongoDB();

    private PlayerDaoMongoDB() {
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("Players"); //get the players collection from the database
    }

    public static PlayerDaoMongoDB getInstance(){return instance;}

    @Override
    public Optional get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            Player player = gson.fromJson(docJson, Player.class); //convert json to Player Object
            return Optional.of(player);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public ArrayList getAll() {
        ArrayList<Player> players=new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            Player player=gson.fromJson(docJson,Player.class);
            players.add(player);
        }
        return players;
    }

    @Override 
    public void save(Player player) {
        String jsonInString=gson.toJson(player);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }

    @Override
    public void update(Player player) {
        this.delete(player);
        this.save(player);

    }

    @Override
    public void delete(Player player) {
        Bson query = eq("userName",player.getUserName() );
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }


    }
}
