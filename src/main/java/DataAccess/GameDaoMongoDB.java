package DataAccess;

import Domain.ManagementSystem.Game;
import Domain.ManagementSystem.Player;
import com.google.gson.Gson;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class GameDaoMongoDB extends Dao<Game>{
//    Gson gson;
    MongoDatabase db;
    MongoCollection col;

    private static final GameDaoMongoDB instance=new GameDaoMongoDB();


    public  static GameDaoMongoDB getInstance(){return instance;}

    private GameDaoMongoDB() {
//        this.gson=new Gson(); //helps to convert from json to object and vice versa
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("Game"); //get the players collection from the database
    }

    @Override
    //change to id?
    public Optional<Game> get(String date) {
        Document doc = (Document) this.col.find(eq("date", date)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            Game game = gson.fromJson(docJson, Game.class); //convert json to Player Object
            return Optional.of(game);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    public Optional<Game> get(Date date) {
        Document doc = (Document) this.col.find(eq("date", date)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            Game game = gson.fromJson(docJson, Game.class); //convert json to Player Object
            return Optional.of(game);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
    @Override
    public ArrayList<Game> getAll() {
        ArrayList<Game> games=new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            Game game=gson.fromJson(docJson,Game.class);
            games.add(game);
        }
        return games;
    }

    @Override
    public void save(Game game) {
        String jsonInString=gson.toJson(game);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);

    }

    @Override
    public void update(Game game) {
        this.delete(game);
        this.save(game);

    }

    @Override
    public void delete(Game game) {
        Bson query = eq("date",game.getDate());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }
}
