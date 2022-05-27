package DataAccess;

import Domain.ManagementSystem.League;
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

public class LeagueDaoMongoDB extends Dao<League> {
    private MongoDatabase db;
    private MongoCollection col;

    private LeagueDaoMongoDB(){
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("Leagues"); //get the players collection from the database
    }

    private static final LeagueDaoMongoDB instance = new LeagueDaoMongoDB();


    public static LeagueDaoMongoDB getInstance(){return instance;}

    @Override
    public Optional<League> get(String leagueName) {
        Document doc = (Document) this.col.find(eq("name", leagueName)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            League league = gson.fromJson(docJson, League.class); //convert json to collection Object
            return Optional.of(league);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public ArrayList<League> getAll() {
        ArrayList<League> leagues = new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            League league=gson.fromJson(docJson,League.class);
            leagues.add(league);
        }
        return leagues;
    }

    @Override
    public void save(League league) {
        String jsonInString = gson.toJson(league);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }

    @Override
    public void update(League league) {
        this.delete(league);
        this.save(league);
    }

    @Override
    public void delete(League league) {
        Bson query = eq("name",league.getName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("name not found");
        }
    }
}
