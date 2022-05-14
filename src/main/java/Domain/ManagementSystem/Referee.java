package Domain.ManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Referee extends EnrolledUser {
    private String qualification;
    private ArrayList<Game> games;
    private ArrayList<GameEventSet> gameEventSets;
    private ArrayList<LeagueSeason> leagueSeasons;


    public Referee(String userName, String password, String name, String qualification) {
        super(userName, password, name);
        this.qualification = qualification;
        this.games = new ArrayList<>();
        this.gameEventSets = new ArrayList<>();
        this.leagueSeasons = new ArrayList<>();
    }

    public String getQualification() {
        return qualification;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public ArrayList<GameEventSet> getGameEventSets() {
        return gameEventSets;
    }

    public ArrayList<LeagueSeason> getLeagueSeasons() {
        return leagueSeasons;
    }

    public void setGameEventSets(ArrayList<GameEventSet> gameEventSets) {
        this.gameEventSets = gameEventSets;
    }

    public void setLeagueSeasons(ArrayList<LeagueSeason> leagueSeasons) {
        this.leagueSeasons = leagueSeasons;
    }

    private void setQualification(String Qualification) {
        this.qualification = Qualification;
    }
    public void editPersonalInformation(){
        Scanner input = new Scanner(System.in);
        System.out.println(this.viewInformation());
        System.out.print("Enter userName and qualification, please press 'Enter' after any insertion.");
        String newUserName = input.nextLine();
        String newQualification = input.nextLine();
        //to add check fot the inputs
        setUserName(newUserName);
        setQualification(newQualification);
        System.out.println("your personal information has been updated successfully");
    }
    public void viewGames(){
        getGames();
    }
    public void lockGameLog(){
        Scanner inputGame = new Scanner(System.in);
        System.out.println(this.viewInformation());
        System.out.print("Please choose the game");
        String game = inputGame.nextLine();
        //to lock the GameLog !!
    }
}
