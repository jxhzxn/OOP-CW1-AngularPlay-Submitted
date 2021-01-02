package service;

import entities.FootballClub;
import entities.PremierLeagueManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FootballClubService {

    public Set<FootballClub> getAllClubs() {    //Method to return all the Clubs as a Set
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        return new LinkedHashSet<>(plm.sortTable(plm.getClubsArray())); //Returning All the Clubs by default Sort as a LinkedHashSet
    }

    public HashSet getClub(String name) {   //Method to return a Club with the given Name
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        ArrayList<HashSet> array = new ArrayList<>();
        for(FootballClub club: plm.getClubsArray()){
            if(club.getClubName().equals(name)){
                HashSet<FootballClub> hashSet = new HashSet<>();    //creating a new HashSet
                hashSet.add(club);  //Adding the searched club to the HashSet
                array.add(hashSet);
            }
        }
        return array.get(0);
    }

}
