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

    public Result addMatch(String clubName1, String clubName2, int goal1, int goal2,int day, int month, int year){  //method to add a match
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        MatchService ms = new MatchService();   //creating a new Match Service instance
        Date date = new Date(day,month,year);   //creating a Date Object

        Set<Match> result = ms.addMatch(clubName1,clubName2,goal1,goal2,date);  //getting the Added Match as a Set
        ObjectMapper mapper = new ObjectMapper();   //creating a new Object Mapper
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);    //Converting the created Match Object to a JSON Object
        return ok(ApplicationUtil.createResponse(jsonData, true));  //returning the JSON Object
    }

    public Result getAllMatches(){  //method to get all the matches
        MatchService ms = new MatchService();   //creating a new Match Service Instance
        Set<Match> result = ms.getAllMatches(); //Getting all the matches as a Set
        ObjectMapper mapper = new ObjectMapper();   //creating a new Object Mapper
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);    //Converting the Set to a JSON Object
        return ok(ApplicationUtil.createResponse(jsonData, true));  //returning the JSON Object
    }

    public Result getAllMatchesSorted(){    //method get all the sorted matches
        MatchService ms = new MatchService();   //creating a new Match Service instance
        Set<Match> result = ms.getAllMatchesSorted();   //getting all the sorted matches as a Set
        ObjectMapper mapper = new ObjectMapper();   // creating a new Object Mapper
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);    //converting the Set to a JSON Object
        return ok(ApplicationUtil.createResponse(jsonData, true));  //returning the JSON Object
    }

    public Result getAllMatchesByDate(int day, int month, int year){    //Method to get the Matches played on a specific Date
        MatchService ms = new MatchService();   //creating a new Match service Instance
        Set<Match> result = ms.getAllMatchesByDate(day,month,year); //Getting the Matches as a Set
        ObjectMapper mapper = new ObjectMapper();   //creating a new ObjectMapper
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);    //Converting the Set to a JSON Object
        return ok(ApplicationUtil.createResponse(jsonData, true));  //returning the JSON Object
    }

    public Result generateRandomMatch(){
        MatchService ms = new MatchService();   //creating a new Match Service Instance
        Match match = ms.generateRandomMatch(); //Getting the Generated Match Object
        ObjectMapper mapper = new ObjectMapper();   //creating a new ObjectMapper
        JsonNode jsonData = mapper.convertValue(match, JsonNode.class); //Converting the Match to a JSON Object
        return ok(ApplicationUtil.createResponse(jsonData, true));  //returning the JSON Object
    }
}
