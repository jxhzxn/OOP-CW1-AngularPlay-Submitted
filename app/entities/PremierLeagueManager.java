package entities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PremierLeagueManager implements Serializable,LeagueManager {

    private ArrayList<FootballClub> clubsArray = new ArrayList<>();
    private ArrayList<Match> playedMatches = new ArrayList<>();

    @Override
    public void createClub(String clubName, String location, String homeground) {
        ArrayList<SportsClub> toReturn = new ArrayList<>();
        for(FootballClub club: getClubsArray()){
            if(club.getClubName().equals(clubName)){
                System.out.println("");
                System.out.println("Club Already exists");
                System.out.println("");
                return;
            }
        }
        FootballClub newClub = new FootballClub(location,clubName,homeground,0,0,0,0,0,0,0);

        clubsArray.add(newClub);
        System.out.println("");
        System.out.println("Club Registered");
        System.out.println("");
        System.out.println("[[ Registered Clubs    :   "+clubsArray.size()+" ]]");
        System.out.println("");
    }

    @Override
    public void deleteClub(String clubName) {
        if (clubsArray.isEmpty()) {
            System.out.println("No Clubs added yet");
        } else {
            for (FootballClub club : clubsArray) {
                if (club.getClubName().equals(clubName)) {
                    clubsArray.remove(club);
                    System.out.println("club removed");
                    break;
                }
            }
            System.out.println("");
            System.out.println(clubName+" doesn't exist");
            System.out.println("");
        }
    }


    public void consoleRun(){
        System.out.println("");
        System.out.println("[[ Premiere League Manager ]]");
        System.out.println("");
        System.out.println("1   :   Create a New Football Club");
        System.out.println("2   :   Delete an existing club");
        System.out.println("3   :   Display Statistics");
        System.out.println("4   :   Display Premier League Table");
        System.out.println("5   :   Add a match");
        System.out.println("6   :   Open GUI");
        System.out.println("0   :   To Exit");
        System.out.println(" ");
        System.out.print("Enter your choice : ");
    }

    @Override
    public void displayTable(){

        sortTable(getClubsArray());

        System.out.println("");
        System.out.println("[[ Points Table ]]");
        System.out.println("");
        System.out.printf("%-20s%-15s%-15s%-10s%-15s%-18s%-8s%-10s%-10s%-10s\n", "Name of the Club","Location","HomeGround","Matches","GoalsScored","GoalsReceived","Wins","Draws","Defeats","Points");
        System.out.printf("%-20s%-15s%-15s%-10s%-15s%-18s%-8s%-10s%-10s%-10s\n", "----------------","--------","----------","-------","------------","--------------","----","-----","-------","------");
        for(FootballClub club : clubsArray){
            System.out.printf("%-20s%-15s%-15s%-10d%-15d%-18d%-8d%-10d%-10d%-10d\n",club.getClubName(),club.getLocation(),club.getHomeGround(),club.getNofMatches(),club.getNofGoalsScored(),club.getNofGoalsReceived(),club.getNofWins(),club.getNofDraws(),club.getNofDefeats(),club.getNofPoints());
        }
        System.out.println("");
    }

    @Override
    public void addMatch(String team1Name,String team2Name, int team1Score, int team2Score, Date matchDate){

        ArrayList<String> checkArray = new ArrayList<>();

        for(FootballClub club: getClubsArray()){
            if(team1Name.equals(club.getClubName())){
                checkArray.add("xx");
            }
            if(team2Name.equals(club.getClubName())){
                checkArray.add("xx");
            }
        }

        if(checkArray.size()<2){
            System.out.println("");
            System.out.println("Add Match of Registered Clubs");
            System.out.println("");
            return;
        }

        String teamWon = null;

        if(team1Score==team2Score){

        }else if(team1Score>team2Score){
            teamWon = team1Name;
        }else{
            teamWon = team2Name;
        }

        FootballClub team1 = getClub(team1Name);
        FootballClub team2 = getClub(team2Name);


        //Updating the Team Statistics
        team1.setNofGoalsScored(team1.getNofGoalsScored()+team1Score);  //updating team 1 goals scored
        team2.setNofGoalsScored(team2.getNofGoalsScored()+team2Score);  //updating team 2 goals scored

        team1.setNofGoalsReceived(team1.getNofGoalsReceived()+team2Score);  //updating team 1 goals received
        team2.setNofGoalsReceived(team2.getNofGoalsReceived()+team1Score);  //updating team 2 goals received

        team1.setNofMatches(team1.getNofMatches()+1);   //updating team 1 nof matches played
        team2.setNofMatches(team2.getNofMatches()+1);   //updating team2 nof matches played

        if(team1Name.equals(teamWon)){
            team1.setNofWins(team1.getNofWins()+1);         //updating team 1 nof wins
            team1.setNofPoints(team1.getNofPoints()+2);     //updating team1 points
            team2.setNofDefeats(team2.getNofDefeats()+1);   //updating team 2 nof defeats
        }else if(team2Name.equals(teamWon)){
            team2.setNofWins(team2.getNofWins()+1);         //updating team 2 nof wins
            team2.setNofPoints(team2.getNofPoints()+2);     //updating team2 points
            team1.setNofDefeats(team1.getNofDefeats()+1);   //updating team1 nof defeats
        }else{
            team1.setNofDraws(team1.getNofDraws()+1);       //updating team1 nof draws
            team2.setNofDraws(team2.getNofDraws()+1);       //updating team2 nof draws
            team1.setNofPoints(team1.getNofPoints()+1);     //updating team1 points
            team2.setNofPoints(team2.getNofPoints()+1);     //updating team2 points
        }


        Match match = new Match(matchDate,team1,team2,team1Score,team2Score);
        playedMatches.add(match);


        System.out.println("");
        System.out.println("Match Added Successfully");
        System.out.println("");
        System.out.println("match Details");
        System.out.println("--------------");
        System.out.println("");
        System.out.println("Match Played on :   "+match.getDate().getDay()+" - "+match.getDate().getMonth()+" - "+match.getDate().getYear());
        System.out.println(team1.getClubName()+" vs "+team2.getClubName());
        System.out.println(team1.getClubName()+" Scored "+match.getTeam1Score());
        System.out.println(team2.getClubName()+" Scored "+match.getTeam2Score());
        if(teamWon==null){
            System.out.println("Match was Drawn");
        }else{
            FootballClub winningTeam = getClub(teamWon);
            System.out.println(winningTeam.getClubName()+" won the Game");
        }
        System.out.println("");
        System.out.println("");
    }

    public FootballClub getClub(String teamName) {
        ArrayList<FootballClub> selected = new ArrayList<>();
        for (FootballClub club : clubsArray) {
            if (club.getClubName().equals(teamName)) {
                selected.add(club);
            }
        }
        return selected.get(0);
    }

    @Override
    public void displayStats(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Club name :   ");
        String selected = input.nextLine();
        ArrayList<String> array = new ArrayList<>();
        for(FootballClub club: getClubsArray()){
            if(club.getClubName().equals(selected)){
                array.add("xx");
            }
        }
        if(array.size()==0){
            System.out.println("");
            System.out.println(selected+" doesn't exist");
        }else{
            FootballClub clubb = getClub(selected);
            System.out.println("");
            System.out.println("[[ Statistics of "+clubb.getClubName()+" ]]");
            System.out.println("");
            System.out.printf("%-20s%-10s%-15s%-18s%-8s%-10s%-10s%-10s\n", "Club","Matches","GoalsScored","GoalsReceived","Wins","Draws","Defeats","Points");
            System.out.printf("%-20s%-10s%-15s%-18s%-8s%-10s%-10s%-10s\n", "----","-------","------------","--------------","----","-----","-------","------");
            System.out.printf("%-20s%-10d%-15d%-18d%-8d%-10d%-10d%-10d\n",clubb.getClubName(),clubb.getNofMatches(),clubb.getNofGoalsScored(),clubb.getNofGoalsReceived(),clubb.getNofWins(),clubb.getNofDraws(),clubb.getNofDefeats(),clubb.getNofPoints());
        }


    }

    public String decide(){
        System.out.println("");
        System.out.print("Press any key to continue .... (Press 'x' to Exit)  :   ");
        Scanner input = new Scanner(System.in);
        String option = input.nextLine();
        System.out.println("");
        return option;
    }

    public ArrayList<FootballClub> sortTable(ArrayList<FootballClub> toSort){
        ArrayList<ArrayList<FootballClub>> toReturn = new ArrayList<>();
        if(toSort.size()==1){
            toReturn.add(toSort);
        }else {
            for (int y = 1; y <= toSort.size() - 1; y++) {
                for (int j = 1; j <= toSort.size() - 1; j++) {
                    for (int x = 1; x <= toSort.size() - 1; x++) {
                        if (toSort.get(x).getNofPoints() > toSort.get(x - 1).getNofPoints()) {
                            Collections.swap(toSort, x, x - 1);
                        } else if (toSort.get(x).getNofPoints() == toSort.get(x - 1).getNofPoints()) {
                            if (toSort.get(x).getNofGoalsScored() > toSort.get(x - 1).getNofGoalsScored()) {
                                Collections.swap(toSort, x, x - 1);
                            }
                        }
                    }
                }
            }
            toReturn.add(toSort);
        }
        return toReturn.get(0);
    }

    public void saveInstance(PremierLeagueManager plm){
        try{
            FileOutputStream fileStream = new FileOutputStream("plm.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(plm);
            os.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public PremierLeagueManager getInstance(){
        ArrayList<PremierLeagueManager> plmArray = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream("plm.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            PremierLeagueManager plm = (PremierLeagueManager) ois.readObject();
            plmArray.add(plm);
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return plmArray.get(0);
    }




    @Override
    public String toString() {
        return "PremierLeagueManager{" +
                "clubsArray=" + clubsArray +
                '}';
    }

    public ArrayList<Match> getFilteredMatches(int day,int month, int year){
        ArrayList<Match> matches = getPlayedMatches();
        ArrayList<Match> sorted = new ArrayList<>();
        for(Match match : matches){
            if(match.getDate().getDay()==day && match.getDate().getMonth()==month && match.getDate().getYear()==year){
                sorted.add(match);
            }
        }
        return sorted;
    }

    public ArrayList<Match> sortTableDate(ArrayList<Match> matchesArray){
        ArrayList<ArrayList<Match>> toReturn = new ArrayList<>();
        if(matchesArray.size()==1){
            toReturn.add(matchesArray);
        }else {
            for (int y = 1; y <= matchesArray.size() - 1; y++) {
                for (int x = 1; x <= matchesArray.size() - 1; x++) {
                    if (matchesArray.get(x).getDate().getYear() < matchesArray.get(x - 1).getDate().getYear()) {
                        Collections.swap(matchesArray, x, x - 1);
                    }if(matchesArray.get(x).getDate().getYear() == matchesArray.get(x - 1).getDate().getYear()) {
                        if (matchesArray.get(x).getDate().getMonth() < matchesArray.get(x - 1).getDate().getMonth()) {
                            Collections.swap(matchesArray, x, x - 1);
                        }
                    }if(matchesArray.get(x).getDate().getYear() == matchesArray.get(x - 1).getDate().getYear() && matchesArray.get(x).getDate().getMonth() == matchesArray.get(x - 1).getDate().getMonth()){
                        if (matchesArray.get(x).getDate().getDay() < matchesArray.get(x - 1).getDate().getDay()) {
                            Collections.swap(matchesArray, x, x - 1);
                        }
                    }
                }
            }
            toReturn.add(matchesArray);
        }
        return toReturn.get(0);
    }

    public PremierLeagueManager plmCheck(){
        Path filePath = Paths.get("./plm.ser");

        PremierLeagueManager plm = new PremierLeagueManager();

        if(Files.exists(filePath)){
            plm = plm.getInstance();
        }else {
            plm = new PremierLeagueManager();
        }
        return plm;
    }

    public void generateRandomMatch(){
        int team1Name = ThreadLocalRandom.current().nextInt(0, getClubsArray().size());
        int team2Name = ThreadLocalRandom.current().nextInt(0, getClubsArray().size());
        int team1Score = ThreadLocalRandom.current().nextInt(0, 6);
        int team2Score = ThreadLocalRandom.current().nextInt(0, 6);
        int day = ThreadLocalRandom.current().nextInt(1, 31);
        int month = ThreadLocalRandom.current().nextInt(10, 13);
//            int year = ThreadLocalRandom.current().nextInt(20, 32);

        Date randomDate = new Date(day,month,2020);

        while(team1Name==team2Name){
            team2Name = ThreadLocalRandom.current().nextInt(0, getClubsArray().size());
        }

        addMatch(getClubsArray().get(team1Name).getClubName(),getClubsArray().get(team2Name).getClubName(),team1Score,team2Score,randomDate);
    }

    public Match getLastMatch(){
        return getPlayedMatches().get(getPlayedMatches().size()-1);
    }



    public ArrayList<FootballClub> getClubsArray() {
        return clubsArray;
    }

    private void setClubsArray(ArrayList<FootballClub> clubsArray) {
        this.clubsArray = clubsArray;
    }

    public ArrayList<Match> getPlayedMatches() {
        return playedMatches;
    }

    private void setPlayedMatches(ArrayList<Match> playedMatches) {
        this.playedMatches = playedMatches;
    }
}
