package entities;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //to test commit

        Scanner input = new Scanner(System.in);


        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
        PremierLeagueManager plm = premierLeagueManager.plmCheck();

        plm.consoleRun();

        int option = 9;

        try{
            while(option!=0){
                option = input.nextInt();
                if(option==1){
                    Scanner inputClub = new Scanner(System.in);
                    System.out.print("Name of the Club  :   ");
                    String clubName = inputClub.nextLine();
                    System.out.print("Location of the Club  :   ");
                    String location = inputClub.nextLine();
                    System.out.print("Homeground  :   ");
                    String homeground = inputClub.nextLine();
                    plm.createClub(clubName,location,homeground);
                    plm.saveInstance(plm);
                }else if(option==2){
                    Scanner sc = new Scanner(System.in);
                    System.out.println(" ");
                    System.out.print("Enter the Club Name to Delete   :   ");
                    String deleteThis = sc.nextLine();
                    plm.deleteClub(deleteThis);
                }else if(option==4){
                    plm.displayTable();
                }else if(option==5){
                    Scanner input1 = new Scanner(System.in);
                    Scanner input2 = new Scanner(System.in);
                    Scanner input3 = new Scanner(System.in);
                    System.out.println("Add a Match");
                    System.out.println("-------------------");
                    System.out.println("");
                    System.out.print("Enter the Day  :   ");
                    int day = input1.nextInt();
                    System.out.print("Enter the Month  :   ");
                    int month = input1.nextInt();
                    System.out.print("Enter the Year  :   ");
                    int year = input1.nextInt();
                    input1.nextLine();
                    Date matchDate = new Date(day,month,year);
                    System.out.print("Team 1    :   ");
                    String team1Name = input2.nextLine();
                    System.out.print("Team 2    :   ");
                    String team2Name = input3.nextLine();
                    System.out.print(team1Name+" Score    :   ");
                    int team1Score = input.nextInt();
                    System.out.print(team2Name+" Score    :   ");
                    int team2Score = input.nextInt();
                    plm.addMatch(team1Name,team2Name,team1Score,team2Score,matchDate);
                }else if(option==3){
                    plm.displayStats();
                }else if(option==0){
                    System.out.println("");
                    System.out.println("Byee...");
                    plm.saveInstance(plm);
                    System.exit(1);
                }else if(option==6){
                    System.out.println("Angular");
                }
                if(plm.decide().equals("x")){
                    System.out.println("");
                    System.out.println("Byee...");
                    plm.saveInstance(plm);
                    System.exit(1);
                }else{
                    plm.consoleRun();
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Input only Integers");
        }
        System.out.println("");
        System.out.println("Byee...");
        plm.saveInstance(plm);
        System.exit(1);
    }
}