package service;

import entities.FootballClub;
import entities.PremierLeagueManager;

import java.util.HashSet;
import java.util.Set;

public class FootballClubService {

    public Set<FootballClub> getAllEmployees() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        return new HashSet<>(plm.getClubsArray());
    }

}
