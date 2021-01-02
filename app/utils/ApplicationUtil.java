package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

public class ApplicationUtil {

    //Method to create a Response
    public static ObjectNode createResponse(Object response, boolean ok){
        ObjectNode result = Json.newObject();   //Creating a new Object Node
        result.put("status",ok);
        if(response instanceof String){
            result.put("response",(String) response);
        }else{
            result.set("response",(JsonNode) response);
        }
        return result;  //returning the Result
    }
}
