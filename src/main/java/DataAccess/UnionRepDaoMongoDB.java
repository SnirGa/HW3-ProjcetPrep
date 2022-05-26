package DataAccess;

import Domain.ManagementSystem.UnionRepresentative;
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

public class UnionRepDaoMongoDB implements Dao<UnionRepresentative> {
    Gson gson;
    MongoDatabase db;
    MongoCollection col;
    private static final UnionRepDaoMongoDB instance=new UnionRepDaoMongoDB();

    public  static UnionRepDaoMongoDB getInstance(){return instance;}

    public UnionRepDaoMongoDB() {
        this.gson=new Gson(); //helps to convert from json to object and vice versa
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("UnionReps"); //get the team owner collection from the database
    }

    @Override
    public Optional get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        try {
            String docJson = doc.toJson(); //json of the document
            UnionRepresentative unionRepresentative = gson.fromJson(docJson, UnionRepresentative.class); //convert json to teamOwner Object
            return Optional.of(unionRepresentative);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public ArrayList<UnionRepresentative> getAll() {
        ArrayList<UnionRepresentative> unionRepresentatives =new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            UnionRepresentative unionRepresentative =gson.fromJson(docJson, UnionRepresentative.class);
            unionRepresentatives.add(unionRepresentative);
        }
        return unionRepresentatives;
    }

    @Override
    public void save(UnionRepresentative unionRepresentative) {
        String jsonInString=gson.toJson(unionRepresentative);
        Document doc = Document.parse(jsonInString);
        this.col.insertOne(doc);
    }

    @Override
    public void update(UnionRepresentative unionRepresentative) {
        this.delete(unionRepresentative);
        this.save(unionRepresentative);
    }

    @Override
    public void delete(UnionRepresentative unionRepresentative) {
        Bson query = eq("userName", unionRepresentative.getUserName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }
}
