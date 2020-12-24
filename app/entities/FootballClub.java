package entities;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable {
    private String homeGround;
    private int nofMatches;
    private int nofGoalsScored;
    private int nofGoalsReceived;
    private int nofWins;
    private int nofDraws;
    private int nofDefeats;
    private int nofPoints;



    public FootballClub(){
    }

    public FootballClub(String location, String clubName, String homeGround, int nofWins, int nofDraws, int nofDefeats, int nofGoalsReceived, int nofGoalsScored, int nofPoints, int nofMatches) {
        super(clubName, location);
        this.homeGround = homeGround;
        this.nofWins = nofWins;
        this.nofDraws = nofDraws;
        this.nofDefeats = nofDefeats;
        this.nofGoalsReceived = nofGoalsReceived;
        this.nofGoalsScored = nofGoalsScored;
        this.nofPoints = nofPoints;
        this.nofMatches = nofMatches;
    }

    public String getHomeGround() {
        return homeGround;
    }

    public void setHomeGround(String homeGround) {
        this.homeGround = homeGround;
    }

    public int getNofWins() {
        return nofWins;
    }

    public void setNofWins(int nofWins) {
        this.nofWins = nofWins;
    }

    public int getNofDraws() {
        return nofDraws;
    }

    public void setNofDraws(int nofDraws) {
        this.nofDraws = nofDraws;
    }

    public int getNofDefeats() {
        return nofDefeats;
    }

    public void setNofDefeats(int nofDefeats) {
        this.nofDefeats = nofDefeats;
    }

    public int getNofGoalsReceived() {
        return nofGoalsReceived;
    }

    public void setNofGoalsReceived(int nofGoalsReceived) {
        this.nofGoalsReceived = nofGoalsReceived;
    }

    public int getNofGoalsScored() {
        return nofGoalsScored;
    }

    public void setNofGoalsScored(int nofGoalsScored) {
        this.nofGoalsScored = nofGoalsScored;
    }

    public int getNofPoints() {
        return nofPoints;
    }

    public void setNofPoints(int nofPoints) {
        this.nofPoints = nofPoints;
    }

    public int getNofMatches() {
        return nofMatches;
    }

    public void setNofMatches(int nofMatches) {
        this.nofMatches = nofMatches;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballClub that = (FootballClub) o;
        return nofWins == that.nofWins &&
                nofDraws == that.nofDraws &&
                nofDefeats == that.nofDefeats &&
                nofGoalsReceived == that.nofGoalsReceived &&
                nofGoalsScored == that.nofGoalsScored &&
                nofPoints == that.nofPoints &&
                nofMatches == that.nofMatches &&
                Objects.equals(homeGround, that.homeGround);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeGround, nofWins, nofDraws, nofDefeats, nofGoalsReceived, nofGoalsScored, nofPoints, nofMatches);
    }

    @Override
    public String toString() {
        return "FootballClub{" +
                "homeGround='" + homeGround + '\'' +
                ", nofWins=" + nofWins +
                ", nofDraws=" + nofDraws +
                ", nofDefeats=" + nofDefeats +
                ", nofGoalsReceived=" + nofGoalsReceived +
                ", nofGoalsScored=" + nofGoalsScored +
                ", nofPoints=" + nofPoints +
                ", nofMatches=" + nofMatches +
                '}';
    }
}