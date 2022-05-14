import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import DataAccess.PlayerDao;
import DataAccess.PlayerDaoMongoDB;
import Domain.ManagementSystem.Player;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static Domain.ManagementSystem.FilledRole.GoalKeeper;

public class Main{
    public static void main(String[] args){

        //MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        //MongoDatabase db=client.getDatabase("sampleDB");
        //MongoCollection col=db.getCollection("refr");
        //Document sampleDoc=new Document("_id","1").append("name","john smith");
        //col.insertOne(sampleDoc);


        PlayerDaoMongoDB playerDaoMongoDB=PlayerDaoMongoDB.getInstance();
        Player player=new Player("Roni123","123456","Roni Ronaldo",new Date(),GoalKeeper);
        //playerDaoMongoDB.save(player);
        player.setName("Roni Gu");
        playerDaoMongoDB.update(player);
        ArrayList<Player> players=playerDaoMongoDB.getAll();
    }
}
