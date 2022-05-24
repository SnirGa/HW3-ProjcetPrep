import java.util.ArrayList;
import java.util.Date;

import DataAccess.GameDaoMongoDB;
import DataAccess.PlayerDaoMongoDB;
import DataAccess.RefereeDaoMongoDB;
import DataAccess.UserDaoMongoDB;
import Domain.ManagementSystem.*;

import static Domain.ManagementSystem.FilledRole.GoalKeeper;

public class Main{
    public static void main(String[] args) throws Exception {

        //MongoClient client= MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        //MongoDatabase db=client.getDatabase("sampleDB");
        //MongoCollection col=db.getCollection("refr");
        //Document sampleDoc=new Document("_id","1").append("name","john smith");
        //col.insertOne(sampleDoc);

        Player player=new Player("Hodaya123","123","hodaya",new Date(), GoalKeeper);
        PlayerDaoMongoDB playerDaoMongoDB=PlayerDaoMongoDB.getInstance();
        playerDaoMongoDB.save(player);
        Referee ref=new Referee("mor123","123456","mor","mkmk");
        RefereeDaoMongoDB refereeDaoMongoDB=RefereeDaoMongoDB.getInstance();
        refereeDaoMongoDB.save(ref);
        UserDaoMongoDB userDaoMongoDB=UserDaoMongoDB.getInstance();
        ArrayList<User> users=userDaoMongoDB.getAll();
        int x=3;
    }
}
