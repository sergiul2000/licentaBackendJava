package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "fixtures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fixtures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer match_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team_name", nullable = false,referencedColumnName = "team_name")
//    @Column
    private Team home_team;
//    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team_name", nullable = false,referencedColumnName = "team_name")
    private Team away_team;
    @Column
    private Integer home_goals;
    @Column
    private Integer away_goals;
    @Column
    private Date datetime;

    public String getHome_team() {
        return home_team.getTeam_name();
    }

    public void setHome_team(String home_team) {
        Team team = new Team(home_team);
        this.home_team = team;
    }

    public String getAway_team() {
        return away_team.getTeam_name();
    }

    public void setAway_team(String away_team) {
        Team team = new Team(away_team);
        this.away_team = team;
    }
}
