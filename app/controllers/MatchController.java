package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Date;
import entities.FootballClub;
import entities.Match;
import entities.PremierLeagueManager;
import play.libs.Json;
import play.mvc.Result;
import service.FootballClubService;
import service.MatchService;
import utils.ApplicationUtil;

import java.util.Set;

import static play.mvc.Results.ok;

public class MatchController {
//    public Result addMatch(String clubName1, String clubName2, int goal1, int goal2){
//        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
//        PremierLeagueManager plm = premierLeagueManager.plmCheck();
//        MatchService ms = new MatchService();
//        Date date = new Date(20,12,2020);
//        ms.addMatch(clubName1,clubName2,goal1,goal2,date);
//
//        JsonNode jsonNode = Json.toJson(new AppSummary(plm.getPlayedMatches().get(plm.getPlayedMatches().size()-1).getTeam1Name()));
//        return ok(jsonNode).as("application/json");
//    }

    public Result addMatch(String clubName1, String clubName2, int goal1, int goal2,int day, int month, int year){
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        MatchService ms = new MatchService();
        Date date = new Date(day,month,year);
//        ms.addMatch("Sri Lanka","Australia",2,1,date);

        Set<Match> result = ms.addMatch(clubName1,clubName2,goal1,goal2,date);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

//        JsonNode jsonNode = Json.toJson(new AppSummary(plm.getPlayedMatches().get(plm.getPlayedMatches().size()-1).getTeam1Name()));
//        return ok(jsonNode).as("application/json");
    }

    public Result getAllMatches(){

        MatchService ms = new MatchService();
        Set<Match> result = ms.getAllMatches();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

    public Result getAllMatchesSorted(){
        MatchService ms = new MatchService();
        Set<Match> result = ms.getAllMatchesSorted();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }
}
