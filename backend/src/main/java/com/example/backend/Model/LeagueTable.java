package com.example.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "league_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeagueTable {
//    @Column
//    private String league_name;

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LeagueTableEmbeddedId id;

    @Column
    private Integer matches;
    @Column
    private Integer wins;
    @Column
    private Integer draws;
    @Column
    private Integer loses;

    @Column
    private Integer goals;
    @Column
    private Integer goalsAgainst;
    @Column
    private Integer pts;
    @Column
    private double xGoals;
    @Column
    private double npxGoals;
    @Column
    private double xGoalsAgainst;
    @Column
    private double npxGoalsAgainst;
    @Column
    private double npxGoalsDifference;
    @Column
    private double ppda;
    @Column
    private double oppda;

    @Column
    private double dc;
    @Column
    private double odc;

//    @MapsId("league_name")
//    @JsonIgnoreProperties

//    @JsonIgnoreProperties
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_name", nullable = false,referencedColumnName = "league_name")
    private League league_name;

    public String getLeague_name() {
        return league_name.getLeague_name();
    }
    public void setLeague_name(String leagueName) {
        League league = new League(leagueName);
        this.league_name = league;
    }
}
