package DataAccess;

import Domain.ManagementSystem.TeamOwner;
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

public class TeamOwnerDaoMongoDB extends Dao<TeamOwner> {
//    Gson gson;
    MongoDatabase db;
    MongoCollection col;
    private static final TeamOwnerDaoMongoDB instance=new TeamOwnerDaoMongoDB();

    public  static TeamOwnerDaoMongoDB getInstance(){return instance;}

    public TeamOwnerDaoMongoDB() {
//        this.gson=new Gson(); //helps to convert from json to object and vice versa
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("TeamOwners"); //get the team owner collection from the database
    }



    @Override
    public Optional get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            TeamOwner teamOwner = gson.fromJson(docJson, TeamOwner.class); //convert json to teamOwner Object
            return Optional.of(teamOwner);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public ArrayList getAll() {
        ArrayList<TeamOwner> teamOwners=new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            TeamOwner teamOwner=gson.fromJson(docJson,TeamOwner.class);
            teamOwners.add(teamOwner);
        }
        return teamOwners;
    }

    @Override
    public void save(TeamOwner teamOwner) {
        String jsonInString=gson.toJson(teamOwner);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }

    @Override
    public void update(TeamOwner teamOwner) {
        this.delete(teamOwner);
        this.save(teamOwner);
    }

    @Override
    public void delete(TeamOwner teamOwner) {
        Bson query = eq("userName",teamOwner.getUserName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }
}
