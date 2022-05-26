package DataAccess;

import Domain.ManagementSystem.League;

import com.google.gson.*;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;

public class LeagueDaoMongoDB implements Dao<League> {

    Gson gson;
    MongoDatabase db;
    MongoCollection col;
//    ObjectMapper objectMapper;
//    ObjectWriter objectMapperWriter;

    private static final LeagueDaoMongoDB instance = new LeagueDaoMongoDB();
    public  static LeagueDaoMongoDB getInstance(){return instance;}

    private LeagueDaoMongoDB(){
        // add default leagues
//        this.objectMapper = new ObjectMapper();
//        this.objectMapperWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();;
        //this.gson=new Gson(); //helps to convert from json to object and vice versa
        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db=client.getDatabase("ProjectPrep"); //get the project database
        this.col=db.getCollection("Leagues"); //get the players collection from the database
        createGsonBuilder();
    }

    private void createGsonBuilder(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(new TypeToken<LocalDate>(){}.getType(), new LocalDateJsonSerializer());
        builder.registerTypeAdapter(new TypeToken<LocalTime>(){}.getType(), new LocalTimeJsonSerializer());
        this.gson = builder.create();
    }

    private class LocalDateJsonSerializer implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate>{
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject LCJsonObject = new JsonObject();
            LCJsonObject.addProperty("year", src.getYear());
            LCJsonObject.addProperty("month", src.getMonthValue());
            LCJsonObject.addProperty("day", src.getDayOfMonth());
            return LCJsonObject;
        }

        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonArray LCJasonString = json.getAsJsonArray();
            return LocalDate.of(LCJasonString.get(0).getAsInt(),LCJasonString.get(1).getAsInt(),LCJasonString.get(2).getAsInt());
        }
    }

    private class LocalTimeJsonSerializer implements JsonSerializer<LocalTime>, JsonDeserializer<LocalTime>{
        public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject LTJsonObject = new JsonObject();
            LTJsonObject.addProperty("hour", src.getHour());
            LTJsonObject.addProperty("minute", src.getMinute());
            return LTJsonObject;
        }

        public LocalTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonArray LTJasonString = json.getAsJsonArray();
            return LocalTime.of(LTJasonString.get(0).getAsInt(),LTJasonString.get(1).getAsInt());
        }
    }



    @Override
    public Optional<League> get(String username) {
        Document doc = (Document) this.col.find(eq("userName", username)).first();
        try {
            String docJson = doc.toJson(); //json of the document
//            League league = objectMapper.readValue(docJson, League.class);
             League league = gson.fromJson(docJson, League.class); //convert json to collection Object
            return Optional.of(league);
        }
        catch (Exception e){
            return Optional.empty();
        }
    }

    @Override
    public ArrayList<League> getAll() {
        ArrayList<League> leagues=new ArrayList<>();
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
//        try {
//            String jsonInString = objectMapperWriter.writeValueAsString(league);
//            String jsonInString = objectMapper.writeValueAsString(league);
//            Document doc = Document.parse(jsonInString);
//            this.col.insertOne(doc);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
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
        Bson query = eq("userName",league.getName());
        try {
            DeleteResult result = this.col.deleteOne(query);
        } catch (MongoException me) {
            System.out.println("userName not found");
        }
    }

//    public static LeagueDaoMongoDB getInstance(){return instance;}
//
//    @Override
//    public Optional get(String name) {
//        Document doc = (Document) this.col.find(eq("userName", name)).first();
//        try {
//            String docJson = doc.toJson(); //json of the document
//            Player player = gson.fromJson(docJson, Player.class); //convert json to Player Object
//            return Optional.of(player);
//        }
//        catch (Exception e){
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    public ArrayList getAll() {
//        ArrayList<League> leagues = new ArrayList<>();
//        for (Object obj : col.find()) {
//            Document currDoc=(Document) obj;
//            String docJson=currDoc.toJson();
//            League league = gson.fromJson(docJson, League.class);
//            leagues.add(league);
//        }
//        return leagues;
//        return null;
//    }
//
//    @Override
//    public void save(Object o) {
//        League league = (League) o;
//        String jsonInString=gson.toJson(league);
//        Document doc = Document.parse(jsonInString);
//        this.col.insertOne(doc);
//    }
//
//    @Override
//    public void update(Object o) {
//        this.delete(o);
//        this.save(o);
//    }
//
//    @Override
//    public void delete(Object o) {
//        League league = (League) o;
//        Bson query = eq("userName", league.getUserName());
//        try {
//            DeleteResult result = this.col.deleteOne(query);
//        } catch (MongoException me) {
//            System.out.println("userName not found");
//        }
//    }
}
