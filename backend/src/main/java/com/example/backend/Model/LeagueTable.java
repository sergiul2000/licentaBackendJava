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
//@AllArgsConstructor
@NoArgsConstructor
public class LeagueTable {
//    @Column
//    private String league_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_name", nullable = false,referencedColumnName = "league_name")
    private League league_name;
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_name", nullable = false,referencedColumnName = "team_name")
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







    public String getLeague_name() {
        return league_name.getLeague_name();
    }
    public void setLeague_name(String leagueName) {
        League league = new League(leagueName);
        this.league_name = league;
    }
//    public LeagueTableEmbeddedId getId(){
//        return LeagueTableEmbeddedId
//    }


    public LeagueTable(LeagueTableEmbeddedId id, Integer matches, Integer wins, Integer draws, Integer loses, Integer goals, Integer goalsAgainst, Integer pts, double xGoals, double npxGoals, double xGoalsAgainst, double npxGoalsAgainst, double npxGoalsDifference, double ppda, double oppda, double dc, double odc, League league_name) {
        this.id = new LeagueTableEmbeddedId(id.getTeam(),id.getYear_start(),id.getYear_end());
        this.matches = matches;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.goals = goals;
        this.goalsAgainst = goalsAgainst;
        this.pts = pts;
        this.xGoals = xGoals;
        this.npxGoals = npxGoals;
        this.xGoalsAgainst = xGoalsAgainst;
        this.npxGoalsAgainst = npxGoalsAgainst;
        this.npxGoalsDifference = npxGoalsDifference;
        this.ppda = ppda;
        this.oppda = oppda;
        this.dc = dc;
        this.odc = odc;
        this.league_name = league_name;
    }

}
