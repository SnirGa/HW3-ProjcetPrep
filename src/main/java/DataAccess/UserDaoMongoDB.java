package DataAccess;

import Domain.ManagementSystem.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Optional;


public class UserDaoMongoDB extends Dao<User> {
    private MongoDatabase db;
    private MongoCollection col;
    private TeamOwnerDaoMongoDB teamOwnerDaoMongoDB;
    private TeamManagerDaoMongoDB teamManagerDaoMongoDB;
    private CoachDaoMongoDB coachDaoMongoDB;
    private PlayerDaoMongoDB playerDaoMongoDB;
    private RefereeDaoMongoDB refereeDaoMongoDB;
    private UnionRepDaoMongoDB unionRepDaoMongoDB;
    private FanDaoMongoDB fanDaoMongoDB;
    private static final UserDaoMongoDB instance = new UserDaoMongoDB();

    private UserDaoMongoDB(){
        // add default users
        MongoClient client = MongoClients.create("mongodb+srv://user:user123456user@cluster0.g7msc.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        this.db = client.getDatabase("ProjectPrep"); //get the project database
        this.col = db.getCollection("Users"); //get the players collection from the database
        this.teamOwnerDaoMongoDB = TeamOwnerDaoMongoDB.getInstance();
        this.teamManagerDaoMongoDB = TeamManagerDaoMongoDB.getInstance();
        this.coachDaoMongoDB = CoachDaoMongoDB.getInstance();
        this.playerDaoMongoDB = PlayerDaoMongoDB.getInstance();
        this.refereeDaoMongoDB = RefereeDaoMongoDB.getInstance();
        this.unionRepDaoMongoDB = UnionRepDaoMongoDB.getInstance();
        this.fanDaoMongoDB = FanDaoMongoDB.getInstance();
    }

    public static UserDaoMongoDB getInstance(){
        return instance;
    }

    @Override
    public Optional get(String username) {
        Optional<User> teamOwner = this.teamOwnerDaoMongoDB.get(username);
        Optional<User> teamManager = this.teamManagerDaoMongoDB.get(username);
        Optional<User> coach = this.coachDaoMongoDB.get(username);
        Optional<User> player = this.playerDaoMongoDB.get(username);
        Optional<Referee> referee = this.refereeDaoMongoDB.get(username);
        Optional<User> uniononRep = this.unionRepDaoMongoDB.get(username);
        Optional<User> fan = this.fanDaoMongoDB.get(username);

        if (!teamOwner.isEmpty()){
            return teamOwner;
        }
        else if (!teamManager.isEmpty()){
            return teamManager;
        }
         else if (!coach.isEmpty()){
            return coach;
        }
        else if (!player.isEmpty()){
            return player;
        }
        else if (!referee.isEmpty()){
            return referee;
        }
        else if (!uniononRep.isEmpty()){
            return uniononRep;
        }
        else if (!fan.isEmpty()){
            return fan;
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> allUsers = new ArrayList<>();
        ArrayList<TeamOwner> teamOwners = this.teamOwnerDaoMongoDB.getAll();
        ArrayList<TeamManager> teamManagers = this.teamManagerDaoMongoDB.getAll();
        ArrayList<Coach> coaches = this.coachDaoMongoDB.getAll();
        ArrayList<Player> players = this.playerDaoMongoDB.getAll();
        ArrayList<Referee> referees = this.refereeDaoMongoDB.getAll();
        ArrayList<UnionRepresentative> uniononReps = this.unionRepDaoMongoDB.getAll();;
        ArrayList<Fan> fans = this.fanDaoMongoDB.getAll();

        for (int i=0;i<teamOwners.size();i++){
            User cast=(User)teamOwners.get(i);
            allUsers.add(cast);
        }

        for (int i=0;i<teamManagers.size();i++){
            User cast=(User)teamManagers.get(i);
            allUsers.add(cast);
        }

        for (int i=0;i<coaches.size();i++){
            User cast=(User)coaches.get(i);
            allUsers.add(cast);
        }

        for (int i=0;i<players.size();i++){
            User cast=(User)players.get(i);
            allUsers.add(cast);
        }

        for (int i=0;i<referees.size();i++){
            User cast=(User)referees.get(i);
            allUsers.add(cast);
        }

        for (int i=0;i<uniononReps.size();i++){
            User cast=(User)uniononReps.get(i);
            allUsers.add(cast);
        }
        for (int i=0;i<fans.size();i++){
            User cast=(User)fans.get(i);
            allUsers.add(cast);
        }
        return allUsers;
    }

    @Override
    public void save(User user) {
        if (user instanceof TeamOwner){
            this.teamOwnerDaoMongoDB.save((TeamOwner) user);
        }
        else if (user instanceof TeamManager){
            this.teamManagerDaoMongoDB.save((TeamManager) user);
        }
        else if (user instanceof Coach){
            this.coachDaoMongoDB.save((Coach) user);
        }
        else if (user instanceof Player){
            this.playerDaoMongoDB.save((Player) user);
        }
        else if (user instanceof Referee){
            this.refereeDaoMongoDB.save((Referee) user);
        }
        else if (user instanceof UnionRepresentative){
            this.unionRepDaoMongoDB.save((UnionRepresentative) user);
        }
        else if (user instanceof Fan){
            this.fanDaoMongoDB.save((Fan) user);
        }
    }

    @Override
    public void update(User user) {
        this.delete(user);
        this.save(user);
    }

    @Override
    public void delete(User user) {
        if (user instanceof TeamOwner){
            this.teamOwnerDaoMongoDB.delete((TeamOwner) user);
        }
        else if (user instanceof TeamManager){
            this.teamManagerDaoMongoDB.delete((TeamManager) user);
        }
        else if (user instanceof Coach){
            this.coachDaoMongoDB.delete((Coach) user);
        }
        else if (user instanceof Player){
            this.playerDaoMongoDB.delete((Player) user);
        }
        else if (user instanceof Referee){
            this.refereeDaoMongoDB.delete((Referee) user);
        }
        else if (user instanceof UnionRepresentative){
            this.unionRepDaoMongoDB.delete((UnionRepresentative) user);
        }
        else if (user instanceof Fan){
            this.fanDaoMongoDB.delete((Fan) user);
        }

    }
}
