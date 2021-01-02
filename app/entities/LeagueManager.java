package entities;

public interface LeagueManager {
    public void createClub(String clubName, String location, String homeground);    //method to create a Club
    public void deleteClub(String clubName);    //method to delete a Club
    public void displayStats(); //method to display the stats
    public void displayTable(); //method to display the points Table
    public void addMatch(String team1Name,String team2Name, int team1Score, int team2Score, Date matchDate);//method to add a Match
}
