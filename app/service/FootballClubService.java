package service;

import entities.FootballClub;
import entities.PremierLeagueManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FootballClubService {

    public Set<FootballClub> getAllClubs() {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        return new LinkedHashSet<>(plm.sortTable(plm.getClubsArray()));
    }

    public HashSet getClub(String name) {
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        ArrayList<HashSet> array = new ArrayList<>();
        for(FootballClub club: plm.getClubsArray()){
            if(club.getClubName().equals(name)){
                HashSet<FootballClub> hashSet = new HashSet<>();
                hashSet.add(club);
                array.add(hashSet);
            }
        }
        return array.get(0);
    }

}
