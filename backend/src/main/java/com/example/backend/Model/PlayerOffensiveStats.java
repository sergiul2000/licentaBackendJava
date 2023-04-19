package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_offensive_stats")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class PlayerOffensiveStats {
    @Id
//    @Column(name = "defensive_id")
//    @GeneratedValue
    private Integer offensive_id;
    @Column
    private String team_name;
    @Column
    private Integer id_player;
    @Column
    private Integer year_start;
    @Column
    private Integer year_end;
    @Column
    private double dribbles_per_game;
    @Column
    private double fouled_per_game;
    @Column
    private double offsides_per_game;
    @Column
    private double dispossessed_per_game;
    @Column
    private double bad_control_per_game;


    //    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_roster")
//    @PrimaryKeyJoinColumn
//    @MapsId
    private Rosters id_roster;


    public Integer getId_roster() {
        return id_roster.getId_roster();
    }

    public void setId_roster(Integer rostersFK) {
        Rosters rosters = new Rosters(rostersFK);
        this.id_roster = rosters;
    }

    public PlayerOffensiveStats(Integer offensive_id, String team_name, Integer id_player, Integer year_start, Integer year_end, double dribbles_per_game, double fouled_per_game, double offsides_per_game, double dispossessed_per_game, double bad_control_per_game, Integer id_roster) {
        this.offensive_id = offensive_id;
        this.team_name = team_name;
        this.id_player = id_player;
        this.year_start = year_start;
        this.year_end = year_end;
        this.dribbles_per_game = dribbles_per_game;
        this.fouled_per_game = fouled_per_game;
        this.offsides_per_game = offsides_per_game;
        this.dispossessed_per_game = dispossessed_per_game;
        this.bad_control_per_game = bad_control_per_game;
        Rosters rosters = new Rosters(id_roster);
        this.id_roster = rosters;
    }

    @Override
    public String toString() {
        return "PlayerOffensiveStats{" +
                "offensive_id=" + offensive_id +
                ", team_name='" + team_name + '\'' +
                ", id_player=" + id_player +
                ", year_start=" + year_start +
                ", year_end=" + year_end +
                ", dribbles_per_game=" + dribbles_per_game +
                ", fouled_per_game=" + fouled_per_game +
                ", offsides_per_game=" + offsides_per_game +
                ", dispossessed_per_game=" + dispossessed_per_game +
                ", bad_control_per_game=" + bad_control_per_game +
                ", id_roster=" + id_roster.getId_roster() +
                '}';
    }
}
