import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import DataAccess.*;
import Domain.ManagementSystem.*;

import static Domain.ManagementSystem.FilledRole.GoalKeeper;

public class Main{
    // Get mongodb classes
    private static LeagueDaoMongoDB leagueDaoMongoDB = LeagueDaoMongoDB.getInstance();
    private static UserDaoMongoDB userDaoMongoDB = UserDaoMongoDB.getInstance();
    private static ArrayList<User> allUsers = new ArrayList<>();
    private static ArrayList<League> allLeague = new ArrayList<>();
    private static ArrayList<Team> ChampionLeagueTeams = new ArrayList<>();
    private static ArrayList<Team> EuroLeagueTeams = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        setUp();
    }

    private static void setUp(){
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

        // ChampionLeagueTeams
        Team CLt1 = new Team(null,null,null);
        Team CLt2 = new Team(null,null,null);
        Team CLt3 = new Team(null,null,null);
        Team CLt4 = new Team(null,null,null);
        Team CLt5 = new Team(null,null,null);
        Team CLt6 = new Team(null,null,null);
        ChampionLeagueTeams = new ArrayList<>();
        ChampionLeagueTeams.add(CLt1);
        ChampionLeagueTeams.add(CLt2);
        ChampionLeagueTeams.add(CLt3);
        ChampionLeagueTeams.add(CLt4);
        ChampionLeagueTeams.add(CLt5);
        ChampionLeagueTeams.add(CLt6);

        // EuroLeagueTeams
        Team ELt1 = new Team(null,null,null);
        Team ELt2 = new Team(null,null,null);
        Team ELt3 = new Team(null,null,null);
        Team ELt4 = new Team(null,null,null);
        Team ELt5 = new Team(null,null,null);
        Team ELt6 = new Team(null,null,null);
        EuroLeagueTeams = new ArrayList<>();
        EuroLeagueTeams.add(ELt1);
        EuroLeagueTeams.add(ELt2);
        EuroLeagueTeams.add(ELt3);
        EuroLeagueTeams.add(ELt4);
        EuroLeagueTeams.add(ELt5);
        EuroLeagueTeams.add(ELt6);

        // Create All League
        League ChampionLeague = new League("ChampionLeague", unionUser1);
        LocalDate startDateChampionLeague = LocalDate.of(2022, 1,1);
        LocalDate finishDateChampionLeague = LocalDate.of(2022, 4,1);
        LeagueSeason ChampionLeagueSeason = new LeagueSeason(ChampionLeague,2022, startDateChampionLeague, finishDateChampionLeague);
        ChampionLeagueSeason.setLstTeam(ChampionLeagueTeams);
        ChampionLeague.addLeagueSeason(ChampionLeagueSeason);
        leagueDaoMongoDB.save(ChampionLeague);
        allLeague.add(ChampionLeague);

        League EuroLeague = new League("EuroLeague", unionUser2);
        LocalDate leagueEuroLeagueStartDate = LocalDate.of(2023, 1,1);
        LocalDate leagueEuroLeagueFinishDate = LocalDate.of(2023, 4,1);
        LeagueSeason EuroLeagueSeason = new LeagueSeason(EuroLeague,2023, leagueEuroLeagueStartDate, leagueEuroLeagueFinishDate);
        ChampionLeagueSeason.setLstTeam(EuroLeagueTeams);
        EuroLeague.addLeagueSeason(EuroLeagueSeason);
        leagueDaoMongoDB.save(EuroLeague);
        allLeague.add(EuroLeague);
    }


}
