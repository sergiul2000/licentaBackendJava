package com.example.backend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column
    private String league_name;
    @Id
    private String team_name;
    @Id
    private Integer year_start;
    @Id
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
    private Integer goals_against;
    @Column
    private Integer points;
    @Column
    private double xgoals;
    @Column
    private double npx_goals;
    @Column
    private double xassists;
    @Column
    private double npx_goals_against;
    @Column
    private double npx_goals_difference;
    @Column
    private double ppda;
    @Column
    private double oppda;

    @Column
    private double dc;
    @Column
    private double odc;


}
