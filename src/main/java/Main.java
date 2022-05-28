import java.time.LocalDate;
import java.util.ArrayList;
import DataAccess.*;
import Domain.ManagementSystem.*;

public class Main{
    // Get mongodb classes
    private static LeagueDaoMongoDB leagueDaoMongoDB = LeagueDaoMongoDB.getInstance();
    private static UserDaoMongoDB userDaoMongoDB = UserDaoMongoDB.getInstance();
    private static ArrayList<User> allUsers = new ArrayList<>();
    private static ArrayList<League> allLeague = new ArrayList<>();
    private static ArrayList<Team> ChampionLeagueTeams = new ArrayList<>();
    private static ArrayList<Team> EuroLeagueTeams = new ArrayList<>();
    private static LeagueSeason ChampionLeagueSeason;
    private static LeagueSeason EuroLeagueSeason;

    public static void main(String[] args){
        deleteAllTables();
        setUpAll();
    }

    private static void deleteAllTables(){
        // Delete all users
        ArrayList<User> allUsers = userDaoMongoDB.getAll();
        for(User user: allUsers) userDaoMongoDB.delete(user);
        // Delete all leagues
        ArrayList<League> allLeagues = leagueDaoMongoDB.getAll();
        for(League league: allLeagues) leagueDaoMongoDB.delete(league);
    }

    private static void setUpAll(){
        setUpUsers();
        setUpLeague();
        setUpLeagueSeasons();
    }

    private static void setUpUsers(){
        // Create all users Representatives
        UnionRepresentative unionUser1 = new UnionRepresentative("ChampionLeagueUR", "Admin1","ChampionLeagueUR");
        userDaoMongoDB.save(unionUser1);
        allUsers.add(unionUser1);
        UnionRepresentative unionUser2 = new UnionRepresentative("EuroLeagueUR", "Admin1","EuroLeagueUR");
        userDaoMongoDB.save(unionUser2);
        allUsers.add(unionUser2);
        UnionRepresentative unionUser3 = new UnionRepresentative("Admin", "Admin1","AdminosBalev");
        userDaoMongoDB.save(unionUser3);
        allUsers.add(unionUser3);
        Referee referee = new Referee("YossiYossi", "123456", "Yossile", "mainReferee");
        userDaoMongoDB.save(referee);
        allUsers.add(referee);
    }

    private static void setUpLeague(){
        // Create All Leagues
        League ChampionLeague = new League("ChampionLeague", (UnionRepresentative)allUsers.get(0));
        leagueDaoMongoDB.save(ChampionLeague);
        allLeague.add(ChampionLeague);

        League EuroLeague = new League("EuroLeague",  (UnionRepresentative)allUsers.get(2));
        leagueDaoMongoDB.save(EuroLeague);
        allLeague.add(EuroLeague);
    }

    private static void setUpLeagueSeasons(){
        League ChampionLeague = allLeague.get(0);
        LocalDate startDateChampionLeague = LocalDate.of(2022, 1,1);
        LocalDate finishDateChampionLeague = LocalDate.of(2022, 4,1);
        ChampionLeagueSeason = new LeagueSeason(ChampionLeague,2022, startDateChampionLeague, finishDateChampionLeague);
        setUpTeams(ChampionLeagueSeason, 0 , 7);
        ChampionLeague.addLeagueSeason(ChampionLeagueSeason);
        leagueDaoMongoDB.update(ChampionLeague);

        League EuroLeague = allLeague.get(1);
        LocalDate leagueEuroLeagueStartDate = LocalDate.of(2023, 1,1);
        LocalDate leagueEuroLeagueFinishDate = LocalDate.of(2023, 4,1);
        EuroLeagueSeason = new LeagueSeason(EuroLeague,2023, leagueEuroLeagueStartDate, leagueEuroLeagueFinishDate);
        setUpTeams(EuroLeagueSeason, 7 , 13);
        EuroLeague.addLeagueSeason(EuroLeagueSeason);
        leagueDaoMongoDB.update(EuroLeague);
    }

    private static void setUpTeams(LeagueSeason ls, int start, int end) {
        // LeagueTeams
        for (int i = start; i<end; i++){
            Team t = new Team(true, "team" + i , null );
            ls.addTeam(t);
        }
    }

}
