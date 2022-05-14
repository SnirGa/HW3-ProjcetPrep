package DataAccess;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DB {
    public static final String URL = "jdbc:mysql://localhost:3306/projintro";
    public static final String USER = "newuser";
    public static final String PASS = "";

    private static final DB instance = new DB();
    MongoClient client;
    MongoDatabase db;
    public DB() {
        client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
         db=client.getDatabase("ProjectPrep");
    }

    public static DB getInstance(){
        return instance;
    }

    //public static Connection getConnection(){
    //}

    public MongoCollection getCollection(String collectionName){
        return db.getCollection(collectionName);
    }



}



