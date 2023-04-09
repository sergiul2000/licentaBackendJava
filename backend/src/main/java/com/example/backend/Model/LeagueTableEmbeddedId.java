package com.example.backend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueTableEmbeddedId implements Serializable {

//    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_name", nullable = false,referencedColumnName = "team_name")
    @MapsId("team_name")
    private Team team_name;
//    private String team_name;
//    private String team_name;
    private Integer year_start;
    private Integer year_end;

    String getTeam_name() {
        return team_name.getTeam_name();
    }
    public void setTeam_name(String teamName) {
        Team team = new Team(teamName);
        this.team_name = team;
    }
    @JsonProperty("team_name")
    public String getTeam() {
        return team_name.getTeam_name();
    }

    public LeagueTableEmbeddedId(String team_name, Integer year_start, Integer year_end) {
        Team team = new Team(team_name);
        this.team_name = team;
        this.year_start = year_start;
        this.year_end = year_end;
    }

//    @Override
//    public String toString() {
//        return "LeagueTableEmbeddedId{" +
//                "team_name=" + team_name +
//                ", year_start=" + year_start +
//                ", year_end=" + year_end +
//                '}';
//    }
    //    public String getTeam_name() {
//        return team_name.getTeam_name();
//    }
//
//    public void setTeam_name(String team_name) {
////        Team team = new Team(team_name);
//        this.team_name = team_name;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeagueTableEmbeddedId that)) return false;
        return Objects.equals(getTeam_name(), that.getTeam_name()) && Objects.equals(getYear_start(), that.getYear_start()) && Objects.equals(getYear_end(), that.getYear_end());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeam_name(), getYear_start(), getYear_end());
    }
}
