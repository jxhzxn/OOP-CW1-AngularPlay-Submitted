package entities;

public interface LeagueManager {
    public SportsClub createClub(String clubName,String location,String homeground);
    public void deleteClub(String clubName);
    public void displayStats();
    public void displayTable();
    public void addMatch(String team1Name,String team2Name, int team1Score, int team2Score, Date matchDate);
//    public void fileSave();
}
