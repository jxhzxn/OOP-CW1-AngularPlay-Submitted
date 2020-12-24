package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.FootballClub;
import entities.Person;
import entities.PremierLeagueManager;
import play.libs.Json;
import play.mvc.Result;
import service.FootballClubService;
import utils.ApplicationUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import static play.mvc.Results.created;
import static play.mvc.Results.ok;

public class FootballClubController{

    public Result createFootballClub(String location, String clubName, String homeGround){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();

        FootballClub footballClub = new FootballClub(clubName,location,homeGround,0,0,0,0,0,0,0);
        plm.getClubsArray().add(footballClub);
        plm.saveInstance(plm);

        JsonNode clubJason = Json.toJson(footballClub);

        JsonNode jsonNode = Json.toJson(new AppSummary(String.valueOf(plm.getClubsArray().size())));
        return ok(jsonNode).as("application/json");
    }

    public Result getClub(){
//        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
//        PremierLeagueManager plm = premierLeagueManager.plmCheck();
//        JsonNode clubJson = Json.toJson(plm.getClubsArray().get(1));
//        return ok(ApplicationUtil.createResponse(clubJson,true));

        FootballClubService fcs = new FootballClubService();

        Set<FootballClub> result = fcs.getAllEmployees();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

    public Result getNofClubs(){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        JsonNode jsonNode = Json.toJson(new AppSummary(String.valueOf(plm.getClubsArray().size())));
        return ok(jsonNode).as("application/json");

    }



}
