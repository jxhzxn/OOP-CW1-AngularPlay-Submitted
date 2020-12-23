package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entities.Person;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.ok;

public class PersonController {

    public Result createPerson(String name, int age){

        Person person = new Person(name,age);
        JsonNode jsonNode = Json.toJson(new AppSummary(person.getInfo()));
        return ok(jsonNode).as("application/json");
    }
}
