package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "extended_pythagorean")
@Getter
@Setter
@NoArgsConstructor
public class ExtendedPythagorean {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer extended_pythagorean_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_name", nullable = false,referencedColumnName = "league_name")
    private League league_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_name", nullable = false,referencedColumnName = "team_name")
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
    private Integer goals_scored;
    @Column
    private Integer goals_received;
    @Column
    private Integer pts;
    @Column
    private double estimated_Wins;
    @Column
    private double estimated_Draws;
    @Column
    private double estimated_Loses;
    @Column
    private double estimated_Points_Extended;
    @Column
    private double delta_Points_Extended;


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

    public ExtendedPythagorean(Integer extended_pythagorean_id, String league_name, String team_name, Integer year_start, Integer year_end, Integer matches, Integer wins, Integer draws, Integer loses, Integer goals_scored, Integer goals_received, Integer pts, double estimated_Wins, double estimated_Draws, double estimated_Loses, double estimated_Points_Extended, double delta_Points_Extended) {
        this.extended_pythagorean_id = extended_pythagorean_id;
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
        this.goals_scored = goals_scored;
        this.goals_received = goals_received;
        this.pts = pts;
        this.estimated_Wins = estimated_Wins;
        this.estimated_Draws = estimated_Draws;
        this.estimated_Loses = estimated_Loses;
        this.estimated_Points_Extended = estimated_Points_Extended;
        this.delta_Points_Extended = delta_Points_Extended;
    }
}
