package entities;


import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {
    private String universityName;

//    public UniversityFootballClub(){
//    }
//
//    public UniversityFootballClub(String location, String clubName, String homeGround, int nofWins, int nofDraws, int nofDefeats, int nofGoalsReceived, int nofGoalsScored, int nofPoints, int nofMatches, String universityName) {
//        super(location, clubName, homeGround, nofWins, nofDraws, nofDefeats, nofGoalsReceived, nofGoalsScored, nofPoints, nofMatches);
//        this.universityName = universityName;
//    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UniversityFootballClub that = (UniversityFootballClub) o;
        return Objects.equals(universityName, that.universityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), universityName);
    }
}
