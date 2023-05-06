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
    @Id
    private Integer league_table_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_name", nullable = false,referencedColumnName = "league_name")
    private League league_name;
//    @EmbeddedId
//    @GeneratedValue(strategy = GenerationType.AUTO)
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "team_name", nullable = false,referencedColumnName = "team_name")
//    private LeagueTableEmbeddedId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_name", nullable = false,referencedColumnName = "team_name")
//    @MapsId("team_name")
    private Team team_name ;
    @Column
    private Integer year_start;
    @Column
    private Integer year_end;
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
    public String getTeam_name() {
        return team_name.getTeam_name();
    }
    public void setTeam_name(String teamName) {
        Team team = new Team(teamName);
        this.team_name = team;
    }

    public LeagueTable(Integer league_table_id, String league_name, String team_name, Integer year_start, Integer year_end, Integer matches, Integer wins, Integer draws, Integer loses, Integer goals, Integer goalsAgainst, Integer pts, double xGoals, double npxGoals, double xGoalsAgainst, double npxGoalsAgainst, double npxGoalsDifference, double ppda, double oppda, double dc, double odc) {
        this.league_table_id = league_table_id;
        League league = new League(league_name);
        this.league_name = league;
        Team team = new Team(team_name);
        this.team_name = team;
        this.year_start = year_start;
        this.year_end = year_end;
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
    }

    @Override
    public String toString() {
        return "LeagueTable{" +
                "defensive_id=" + league_table_id +
                ", league_name=" + league_name.getLeague_name() +
                ", team_name=" + team_name.getTeam_name() +
                ", year_start=" + year_start +
                ", year_end=" + year_end +
                ", matches=" + matches +
                ", wins=" + wins +
                ", draws=" + draws +
                ", loses=" + loses +
                ", goals=" + goals +
                ", goalsAgainst=" + goalsAgainst +
                ", pts=" + pts +
                ", xGoals=" + xGoals +
                ", npxGoals=" + npxGoals +
                ", xGoalsAgainst=" + xGoalsAgainst +
                ", npxGoalsAgainst=" + npxGoalsAgainst +
                ", npxGoalsDifference=" + npxGoalsDifference +
                ", ppda=" + ppda +
                ", oppda=" + oppda +
                ", dc=" + dc +
                ", odc=" + odc +
                '}';
    }
}
