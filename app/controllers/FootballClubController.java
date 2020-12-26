package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.FootballClub;
import entities.PremierLeagueManager;
import play.libs.Json;
import play.mvc.Result;
import service.FootballClubService;
import utils.ApplicationUtil;

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

    public Result getAllClubs(){
//        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
//        PremierLeagueManager plm = premierLeagueManager.plmCheck();
//        JsonNode clubJson = Json.toJson(plm.getClubsArray().get(1));
//        return ok(ApplicationUtil.createResponse(clubJson,true));

        FootballClubService fcs = new FootballClubService();

        Set<FootballClub> result = fcs.getAllClubs();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
//        return ok(jsonData);
    }

    public Result getClub(String name){
        FootballClubService fcs = new FootballClubService();

        Set<FootballClub> result = fcs.getClub(name);
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
