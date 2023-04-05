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
    @Column
    private String league_name;
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

//    @MapsId("league_name")
//    @JsonIgnoreProperties
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "league_name", nullable = false)
//    private League league_name;
}
