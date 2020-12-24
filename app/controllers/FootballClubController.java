package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import entities.FootballClub;
import entities.Person;
import entities.PremierLeagueManager;
import play.libs.Json;
import play.mvc.Result;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static play.mvc.Results.ok;

public class FootballClubController{

    public Result createFootballClub(String location, String clubName, String homeGround){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();

        FootballClub footballClub = new FootballClub(clubName,location,homeGround,0,0,0,0,0,0,0);
        plm.getClubsArray().add(footballClub);
        plm.saveInstance(plm);
        JsonNode jsonNode = Json.toJson(new AppSummary(String.valueOf(plm.getClubsArray().size())));
        return ok(jsonNode).as("application/json");
    }

}
