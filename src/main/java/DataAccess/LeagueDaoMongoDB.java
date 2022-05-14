package DataAccess;

import java.util.ArrayList;
import java.util.Optional;

public class LeagueDaoMongoDB implements Dao{

    Gson gson;
    MongoDatabase db;
    MongoCollection col;

    private static final LeagueDaoMongoDB instance = new LeagueDaoMongoDB();

    private LeagueDaoMongoDB(){
        // add default leagues
        this.gson=new Gson(); //helps to convert from json to object and vice versa
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("Players"); //get the players collection from the database
    }

    public static LeagueDaoMongoDB getInstance(){return instance;}

    @Override
    public Optional get(String name) {
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
        ArrayList<League> leagues = new ArrayList<>();
        for (Object obj : col.find()) {
            Document currDoc=(Document) obj;
            String docJson=currDoc.toJson();
            League league = gson.fromJson(docJson, League.class);
            leagues.add(league);
        }
        return leagues;
        return null;
    }

    @Override
    public void save(Object o) {
        League league = (League) o;
        String jsonInString=gson.toJson(league);
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
        League league = (League) o;
        Bson query = eq("userName", league.getUserName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }
}

