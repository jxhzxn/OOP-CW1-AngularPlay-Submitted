package entities;

import java.io.Serializable;

public class Match implements Serializable {
    private Date date;
    private FootballClub team1;
    private FootballClub team2;
    private int team1Score;
    private int team2Score;

    public Match(Date date, FootballClub team1, FootballClub team2, int team1Score, int team2Score) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
    }

    public Date getDate() {
        return date;
    }

    public String getDatePrint() {
        return date.getDay()+"-"+date.getMonth()+"-"+date.getYear();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public FootballClub getTeam1() {
        return team1;
    }

    public String getTeam1Name() {
        return team1.getClubName();
    }

    public void setTeam1(FootballClub team1) {
        this.team1 = team1;
    }

    public FootballClub getTeam2() {
        return team2;
    }

    public String getTeam2Name() {
        return team2.getClubName();
    }

    public void setTeam2(FootballClub team2) {
        this.team2 = team2;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

}
