package service;

import entities.Date;
import entities.FootballClub;
import entities.Match;
import entities.PremierLeagueManager;

import java.util.LinkedHashSet;
import java.util.Set;

public class MatchService {
    public Set<Match> addMatch(String team1Name, String team2Name, int team1Score, int team2Score, Date matchDate){

        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();

        String teamWon = null;

        if(team1Score==team2Score){

        }else if(team1Score>team2Score){
            teamWon = team1Name;
        }else{
            teamWon = team2Name;
        }

        FootballClub team1 = plm.getClub(team1Name);
        FootballClub team2 = plm.getClub(team2Name);


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
        plm.getPlayedMatches().add(match);
        plm.saveInstance(plm);
        return new LinkedHashSet<>(plm.getPlayedMatches());
    }

    public Set<Match> getAllMatches() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        return new LinkedHashSet<>(plm.getPlayedMatches());
    }

    public Set<Match> getAllMatchesSorted() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        return new LinkedHashSet<>(plm.sortTableDate(plm.getPlayedMatches()));
    }

    public Set<Match> getAllMatchesByDate(int day, int month, int year) {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        return new LinkedHashSet<>(plm.getFilteredMatches(day,month,year));
    }

    public Match generateRandomMatch(){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        plm.generateRandomMatch();
        plm.saveInstance(plm);
        return plm.getLastMatch();
    }
}
