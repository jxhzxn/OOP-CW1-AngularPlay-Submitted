package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import entities.FootballClub;
import entities.Person;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.ok;

public class FootballClubController{

    public Result createFootballClub(String location, String clubName, String homeGround){
        FootballClub footballClub = new FootballClub(clubName,location,homeGround,0,0,0,0,0,0,0);
        JsonNode jsonNode = Json.toJson(new AppSummary(footballClub.getInfo()));
        return ok(jsonNode).as("application/json");

    }

}
