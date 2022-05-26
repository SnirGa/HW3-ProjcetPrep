package DataAccess;

import Domain.ManagementSystem.TeamManager;
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
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class TeamManagerDaoMongoDB extends Dao<TeamManager> {
//    Gson gson;
    MongoDatabase db;
    MongoCollection col;
    private static final TeamManagerDaoMongoDB instance = new TeamManagerDaoMongoDB();
    public  static TeamManagerDaoMongoDB getInstance(){return instance;}

    public TeamManagerDaoMongoDB() {
//        this.gson = new Gson(); //helps to convert from json to object and vice versa
        MongoClient client = MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db = client.getDatabase("ProjectPrep"); //get the project database
        this.col = db.getCollection("TeamManagers"); //get the team manager collection from the database
    }


    @Override
    public Optional<TeamManager> get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            TeamManager teamManager = gson.fromJson(docJson, TeamManager.class); //convert json to team manager Object
            return Optional.of(teamManager);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public ArrayList<TeamManager> getAll() {
        ArrayList<TeamManager> teamManagers = new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc = (Document) obj;
            String docJson = currDoc.toJson();
            TeamManager teamManager = gson.fromJson(docJson, TeamManager.class);
            teamManagers.add(teamManager);
        }
        return teamManagers;
    }

    @Override
    public void save(TeamManager teamManager) {
        String jsonInString = gson.toJson(teamManager);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }

    @Override
    public void update(TeamManager teamManager) {
        this.delete(teamManager);
        this.save(teamManager);

    }

    @Override
    public void delete(TeamManager teamManager) {
        Bson query = eq("userName", teamManager.getUserName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }
}
