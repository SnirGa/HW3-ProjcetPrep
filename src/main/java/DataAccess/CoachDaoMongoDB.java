package DataAccess;

import Domain.ManagementSystem.Coach;
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

public class CoachDaoMongoDB implements Dao<Coach>
{
    Gson gson;
    MongoDatabase db;
    MongoCollection col;
    private static final CoachDaoMongoDB instance=new CoachDaoMongoDB();
    public static CoachDaoMongoDB getInstance(){return instance;}


    public CoachDaoMongoDB() {
        this.gson=new Gson(); //helps to convert from json to object and vice versa
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("Coaches"); //get the coach collection from the database
    }
    @Override
    public Optional get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            Coach coach = gson.fromJson(docJson, Coach.class); //convert json to collection Object
            return Optional.of(coach);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }
    @Override
    public ArrayList<Coach> getAll() {
        ArrayList<Coach> coaches=new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            Coach coach=gson.fromJson(docJson,Coach.class);
            coaches.add(coach);
        }
        return coaches;
    }

    @Override
    public void save(Coach coach) {
        String jsonInString=gson.toJson(coach);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }


    @Override
    public void update(Coach coach) {
        this.delete(coach);
        this.save(coach);
    }

    @Override
    public void delete(Coach coach) {
        Bson query = eq("userName",coach.getUserName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }

}
