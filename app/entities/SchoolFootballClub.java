package entities;

import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClub extends FootballClub implements Serializable {

    private String schoolName;

//    public SchoolFootballClub(){
//
//    }
//
//    public SchoolFootballClub(String location, String clubName, String homeGround, int nofWins, int nofDraws, int nofDefeats, int nofGoalsReceived, int nofGoalsScored, int nofPoints, int nofMatches, String schoolName) {
//        super(location, clubName, homeGround, nofWins, nofDraws, nofDefeats, nofGoalsReceived, nofGoalsScored, nofPoints, nofMatches);
//        this.schoolName = schoolName;
//    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SchoolFootballClub that = (SchoolFootballClub) o;
        return Objects.equals(schoolName, that.schoolName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName);
    }
}
