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

    public Result createFootballClub(String location, String clubName, String homeGround){ //method to create a new Football Club
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck(); //triggering the method to get the last saved PLM instance

        FootballClub footballClub = new FootballClub(clubName,location,homeGround,0,0,0,0,0,0,0); //creating a new Football Club
        plm.getClubsArray().add(footballClub);  //adding the newly created Football Club to the array
        plm.saveInstance(plm);  //saving the current PLM instance

        JsonNode clubJason = Json.toJson(footballClub);

        JsonNode jsonNode = Json.toJson(new AppSummary(String.valueOf(plm.getClubsArray().size())));    //converting the current no of clubs to a JSON object
        return ok(jsonNode).as("application/json"); // returning the JSON object
    }

    public Result getAllClubs(){ //method to get all the FootballClubs
        FootballClubService fcs = new FootballClubService();    //creating a new Instance of FootballClubService

        Set<FootballClub> result = fcs.getAllClubs();   //getting all the Clubs as a Set
        ObjectMapper mapper = new ObjectMapper();   //creating a new ObjectMapper
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);    //Converting the Club Set to a JSON Object
        return ok(ApplicationUtil.createResponse(jsonData, true));  //returning the JSON Object
    }

    public Result getClub(String name){ //method to get a specific club
        FootballClubService fcs = new FootballClubService();    //Creating an instance of FootballClubService

        Set<FootballClub> result = fcs.getClub(name);   //Getting the Club as a Set
        ObjectMapper mapper = new ObjectMapper();   //creating a new ObjectMapper
        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);    //Converting the Club to a JSON Object
        return ok(ApplicationUtil.createResponse(jsonData, true));  //returning the JSON Object
    }

    public Result getNofClubs(){    // method to get the no of Clubs Registered
        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();
        JsonNode jsonNode = Json.toJson(new AppSummary(String.valueOf(plm.getClubsArray().size())));    //Getting the no of Clubs Available and converting it to a JSON Object
        return ok(jsonNode).as("application/json"); //returning the JSON Object
    }



}
