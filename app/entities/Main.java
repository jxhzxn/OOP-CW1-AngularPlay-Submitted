package entities;

import java.io.*;
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
                    plm = premierLeagueManager.plmCheck();
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
                    plm = premierLeagueManager.plmCheck();
                    Scanner sc = new Scanner(System.in);
                    System.out.println(" ");
                    System.out.print("Enter the Club Name to Delete   :   ");
                    String deleteThis = sc.nextLine();
                    plm.deleteClub(deleteThis);
                    plm.saveInstance(plm);
                }else if(option==4){
                    plm = premierLeagueManager.plmCheck();
                    plm.displayTable();
                }else if(option==5){
                    plm = premierLeagueManager.plmCheck();
                    if(plm.getClubsArray().size()<=1){
                        System.out.println("");
                        System.out.print("Add More Clubs to add Matches");
                        System.out.println("");
                    }else{
                        Scanner input1 = new Scanner(System.in);
                        Scanner input2 = new Scanner(System.in);
                        Scanner input3 = new Scanner(System.in);
                        System.out.println("");
                        System.out.println("Add a Match");
                        System.out.println("");
                        System.out.println("01/10/2020 - 31/12/2020");
                        System.out.println("-------------------");
                        System.out.println("");
                        System.out.print("Enter the Day  :   ");
                        int day = input1.nextInt();
                        System.out.print("Enter the Month  :   ");
                        int month = input1.nextInt();
                        System.out.print("Enter the Year  :   ");
                        int year = input1.nextInt();
                        input1.nextLine();
                        if(day<1 || day>31 || month<10 || month>12 || year!=2020){
                            System.out.println("");
                            System.out.println("Add a Valid Date within the Range");
                            System.out.println("");
                        }else{
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
                            plm.saveInstance(plm);
                        }

                    }
                }else if(option==3){
                    plm = premierLeagueManager.plmCheck();
                    plm.displayStats();
                }else if(option==0){
                    plm = premierLeagueManager.plmCheck();
                    System.out.println("");
                    System.out.println("Byee...");
                    plm.saveInstance(plm);
                    System.exit(1);
                }else if(option==6){
//                    String command = "sbt run";
//                    try {
//                        Process poc = Runtime.getRuntime().exec(command);
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(poc.getInputStream()));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("");
//                    System.out.print("Opening the GUI in Browser");
//                    System.out.print(".");
//                    System.out.print(".");
//                    System.out.print(".");
//                    System.out.println("");
                }
                if(plm.decide().equals("x")){
                    plm = premierLeagueManager.plmCheck();
                    System.out.println("");
                    System.out.println("Byee...");
                    plm.saveInstance(plm);
                    System.exit(1);
                }else{
                    plm = premierLeagueManager.plmCheck();
                    plm.consoleRun();
                }
            }
        }catch (InputMismatchException e){
            System.out.println("Input only Integers");
            plm.consoleRun();
        }
        plm = premierLeagueManager.plmCheck();
        System.out.println("");
        System.out.println("Byee...");
        plm.saveInstance(plm);
        System.exit(1);
    }
}