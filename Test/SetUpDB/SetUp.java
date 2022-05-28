package SetUpDB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import DataAccess.*;
import Domain.ManagementSystem.*;

public class SetUp {
    // Get mongodb classes
    private static final LeagueDaoMongoDB leagueDaoMongoDB = LeagueDaoMongoDB.getInstance();
    private static final UserDaoMongoDB userDaoMongoDB = UserDaoMongoDB.getInstance();
    private static final ArrayList<User> allUsers = new ArrayList<>();
    private static final ArrayList<League> allLeague = new ArrayList<>();

    public static void SetUpDB(){
        deleteAllTables();
        setUpAll();
    }

    public static void deleteAllTables(){
        // Delete all users
        ArrayList<User> allUsers = userDaoMongoDB.getAll();
        for(User user: allUsers) userDaoMongoDB.delete(user);
        // Delete all leagues
        ArrayList<League> allLeagues = leagueDaoMongoDB.getAll();
        for(League league: allLeagues) leagueDaoMongoDB.delete(league);
    }

    public static void setUpAll(){
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
        UnionRepresentative unionUser3 = new UnionRepresentative("AllOtherLeagueUR", "Admin1","AllOtherLeagueUR");
        userDaoMongoDB.save(unionUser3);
        allUsers.add(unionUser3);
        UnionRepresentative unionUser4 = new UnionRepresentative("Admin", "Admin1","AdminosBalev");
        userDaoMongoDB.save(unionUser4);
        allUsers.add(unionUser4);
        Referee referee = new Referee("YossiYossi", "123456", "Yossile", "mainReferee");
        userDaoMongoDB.save(referee);
        allUsers.add(referee);
        Player player=new Player("someName","123456","some name",new Date(), FilledRole.Defender);
        userDaoMongoDB.save(player);
        allUsers.add(player);
    }

    private static void setUpLeague(){
        // Create All Leagues
        League ChampionLeague = new League("ChampionLeague", (UnionRepresentative)allUsers.get(0));
        leagueDaoMongoDB.save(ChampionLeague);
        allLeague.add(ChampionLeague);

        League EuroLeague = new League("EuroLeague",  (UnionRepresentative)allUsers.get(1));
        leagueDaoMongoDB.save(EuroLeague);
        allLeague.add(EuroLeague);

        League leagueWithOutStartDate = new League("LeagueWithOutStartDate", (UnionRepresentative)allUsers.get(2));
        leagueDaoMongoDB.save(leagueWithOutStartDate);
        allLeague.add(leagueWithOutStartDate);

        League leagueWithOutTeamsAndStartDate = new League("LeagueWithOutTeamsAndStartDate", (UnionRepresentative)allUsers.get(2));
        leagueDaoMongoDB.save(leagueWithOutTeamsAndStartDate);
        allLeague.add(leagueWithOutTeamsAndStartDate);

        League leagueWithOutTeams = new League("LeagueWithOutTeams", (UnionRepresentative)allUsers.get(2));
        leagueDaoMongoDB.save(leagueWithOutTeams);
        allLeague.add(leagueWithOutTeams);
    }

    private static void setUpLeagueSeasons(){
        League ChampionLeague = allLeague.get(0);
        LocalDate startDateChampionLeague = LocalDate.of(2022, 1,1);
        LocalDate finishDateChampionLeague = LocalDate.of(2022, 4,1);
        LeagueSeason ChampionLeagueSeason = new LeagueSeason(ChampionLeague,2022, startDateChampionLeague, finishDateChampionLeague);
        setUpTeams(ChampionLeagueSeason, 0 , 7);
        ChampionLeague.addLeagueSeason(ChampionLeagueSeason);
        leagueDaoMongoDB.update(ChampionLeague);

        League EuroLeague = allLeague.get(1);
        LocalDate leagueEuroLeagueStartDate = LocalDate.of(2023, 1,1);
        LocalDate leagueEuroLeagueFinishDate = LocalDate.of(2023, 4,1);
        LeagueSeason EuroLeagueSeason = new LeagueSeason(EuroLeague,2023, leagueEuroLeagueStartDate, leagueEuroLeagueFinishDate);
        setUpTeams(EuroLeagueSeason, 7 , 13);
        EuroLeague.addLeagueSeason(EuroLeagueSeason);
        leagueDaoMongoDB.update(EuroLeague);

        League leagueWithOutStartDate = allLeague.get(2);
        LocalDate leagueWithOutStartDateFinishDate = LocalDate.of(2023, 4,1);
        LeagueSeason leagueSeasonWithOutStartDate = new LeagueSeason(leagueWithOutStartDate, 2022, null, leagueWithOutStartDateFinishDate);
        setUpTeams(leagueSeasonWithOutStartDate, 14 , 16);
        leagueWithOutStartDate.addLeagueSeason(leagueSeasonWithOutStartDate);
        leagueDaoMongoDB.update(leagueWithOutStartDate);

        League leagueWithOutTeamsAndStartDate = allLeague.get(3);
        LocalDate leagueWithOutTeamsAndStartDateFinishDate = LocalDate.of(2023, 4,1);
        LeagueSeason leagueSeasonWithOutTeamsAndStartDate = new LeagueSeason(leagueWithOutTeamsAndStartDate, 2022, null, leagueWithOutTeamsAndStartDateFinishDate);
        leagueWithOutTeamsAndStartDate.addLeagueSeason(leagueSeasonWithOutTeamsAndStartDate);
        leagueDaoMongoDB.update(leagueWithOutTeamsAndStartDate);

        League leagueWithOutTeams= allLeague.get(4);
        LocalDate leagueWithOutTeamsStartDate = LocalDate.of(2023, 4,1);
        LocalDate leagueWithOutTeamsFinishDate = LocalDate.of(2023, 4,1);
        LeagueSeason leagueSeasonWithOutTeams = new LeagueSeason(leagueWithOutTeams, 2022, leagueWithOutTeamsStartDate, leagueWithOutTeamsFinishDate);
        leagueWithOutTeams.addLeagueSeason(leagueSeasonWithOutTeams);
        leagueDaoMongoDB.update(leagueWithOutTeams);
    }

    private static void setUpTeams(LeagueSeason ls, int start, int end) {
        // LeagueTeams
        for (int i = start; i<end; i++){
            Team t = new Team(true, "team" + i , null );
            ls.addTeam(t);
        }
    }

}
