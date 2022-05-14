import java.util.Scanner;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main{
    public static void main(String[] args){

        MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        MongoDatabase db=client.getDatabase("sampleDB");
        MongoCollection col=db.getCollection("refr");
        Document sampleDoc=new Document("_id","1").append("name","john smith");
        col.insertOne(sampleDoc);
    }
}
